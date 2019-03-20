package ai.play.devtech.api.caches;

import ai.play.devtech.api.interfaces.APICache;
import ai.play.devtech.api.misc.Entry;
import ai.play.devtech.core.errors.InvalidAPIURLException;
import ai.play.devtech.core.objects.manipulation.ObjectBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Function;

/**
 * This cache is a simple implmenetation, it evicts data based on how long they've been in the cache, if it's over the
 * specified time, it evicts it from the cache and retrieves a new one.
 *
 * @author devan
 */
public class SimpleAPICache implements APICache {

	protected Map<String, Entry> datamap;
	protected long msdecay;
	protected static Gson gson = new GsonBuilder().setLenient().create();

	protected Set<String> current = new ConcurrentSkipListSet<>();

	public SimpleAPICache() {
		this(50, Duration.of(1, ChronoUnit.HOURS));
	}

	public SimpleAPICache(int initialsize) {
		this(initialsize, Duration.of(1, ChronoUnit.HOURS));
	}

	public SimpleAPICache(TemporalUnit time, long amount) {
		this(50, Duration.of(amount, time));
	}

	public SimpleAPICache(TemporalUnit time, long amount, int initialsize) {
		this(initialsize, Duration.of(amount, time));
	}

	public SimpleAPICache(int size, Duration d) {
		datamap = new ConcurrentHashMap<>(size);
		msdecay = d.toMillis();
	}

	@SuppressWarnings ("unchecked")
	@Override
	public <T> T get(String url, Class<T> type, Function<Map<String, Object>, Map<String, Object>> processor) {
		while (true) if (!current.contains(url)) break;
		current.add(url);
		Entry in = datamap.get(url);
		if (in != null) if (in.death.isAfter(Instant.now())) {
			current.remove(url);
			return (T) in.data;
		} else datamap.remove(url);
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			reader.lines().forEach(builder::append);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			current.remove(url);
			throw new InvalidAPIURLException(url + " is not responding or is malformed");
		}
		String ret = builder.toString();
		Map<String, Object> map = gson.<Map<String, Object>>fromJson(ret, Map.class);
		map = processor.apply(map);
		ObjectBuilder<T> obj = new ObjectBuilder<>(type);
		obj.addAll(map);
		T t = obj.build();
		datamap.put(url, new Entry(t, Instant.now().plusMillis(msdecay)));
		current.remove(url);
		return t;
	}
}