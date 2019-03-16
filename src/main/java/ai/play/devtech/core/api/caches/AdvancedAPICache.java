package ai.play.devtech.core.api.caches;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ai.play.devtech.core.api.interfaces.APICache;
import ai.play.devtech.core.api.interfaces.Evictor;
import ai.play.devtech.core.errors.RequestDeniedException;
import ai.play.devtech.core.objects.manipulation.ObjectBuilder;
import ai.play.devtech.util.logic.ExceptionWrapper;
import ai.play.devtech.util.logic.Lock;

public class AdvancedAPICache implements APICache {
	private List<Evictor> evictors;
	private Lock<String> lock = new Lock<>();
	private static final Gson GSON = new GsonBuilder().setLenient().create();
	private Map<String, Object> cache = new ConcurrentHashMap<>();
	public AdvancedAPICache(Evictor... evictors) {
		this.evictors = Arrays.asList(evictors);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String url, Class<T> type, Function<Map<String, Object>, Map<String, Object>> function) {
		lock.lock(url);
		for (Evictor e : evictors)
			e.attemptEviction(cache);
		evictors.forEach(e -> e.refresh(cache));
		if(evictors.stream().anyMatch(e -> e.newRequest(cache, url)))
			throw new RequestDeniedException();
		T obj = (T) cache.get(url);
		if (obj == null) {
			StringBuilder contents = new StringBuilder();
			BufferedReader buff = new BufferedReader(new InputStreamReader(new ExceptionWrapper<>(() -> new URL(url).openStream()).run()));
			buff.lines().forEach(contents::append);
			new ExceptionWrapper<Void>(buff::close).run();
			ObjectBuilder<T> objbuilder = new ObjectBuilder<>(type);
			objbuilder.addAll(function.apply(GSON.<Map<String, Object>>fromJson(contents.toString(), Map.class)));
			obj = objbuilder.build();
			for (Evictor e : evictors)
				e.newEntry(cache, url, obj);
		}
		lock.unlock(url);
		return obj;
	}
}
