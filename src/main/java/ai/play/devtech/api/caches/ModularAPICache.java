package ai.play.devtech.api.caches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Function;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ai.play.devtech.api.caches.util.locks.EmptyLock;
import ai.play.devtech.api.caches.util.locks.Lock;
import ai.play.devtech.api.caches.util.locks.StandardLock;
import ai.play.devtech.core.errors.InvalidAPIURLException;
import ai.play.devtech.core.objects.manipulation.ObjectBuilder;

public class ModularAPICache implements APICache {
	private static final int CORES = Runtime.getRuntime().availableProcessors();
	private Lock<String> lock;
	private Cache cache;
	private Executor exec;
	private long wait;
	protected static final Gson GSON = new GsonBuilder().setLenient().create();

	public ModularAPICache(boolean safe, Executor exec, Duration duration) {
		if (safe)
			lock = new StandardLock<>();
		else
			lock = new EmptyLock<>();
		if (exec == null)
			exec = Executors.newFixedThreadPool(CORES);
		if (duration == null)
			duration = Duration.ofMinutes(30);
		this.exec = exec;
		this.wait = duration.toMillis();
		cache = new Cache();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String url, Class<T> type, Function<Map<String, Object>, Map<String, Object>> processor) {
		lock.lock(url);
		T t = (T) cache.get(url);
		if (t == null) {
			StringBuilder builder = new StringBuilder();
			try {
				URL uurl = new URL(url);
				URLConnection conn = uurl.openConnection();
				conn.addRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
				conn.setReadTimeout(30000);
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				reader.lines().forEach(builder::append);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				lock.unlock(url);
				throw new InvalidAPIURLException(url + " is not responding or is malformed");
			}
			String ret = builder.toString();
			Map<String, Object> map = GSON.<Map<String, Object>>fromJson(ret, Map.class);
			map = processor.apply(map);
			ObjectBuilder<T> obj = new ObjectBuilder<>(type);
			obj.addAll(map);
			t = obj.build();
			cache.put(url, t);
			exec.execute(() -> {
				try {
					Thread.sleep(wait);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
				cache.remove(url);
			});
		}
		lock.unlock(url);
		return t;
	}

}
