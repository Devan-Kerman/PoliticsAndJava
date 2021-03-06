package ai.play.devtech.api.caches.evictors;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ai.play.devtech.core.interfaces.Evictor;

public class TimedEvictor implements Evictor {

	private Map<String, Instant> deaths;
	private long ms;

	public TimedEvictor(Duration expiry) {
		ms = expiry.toMillis();
		deaths = new ConcurrentHashMap<>();
	}

	@Override
	public boolean newEntry(Map<String, Object> cache, String entry, Object result) {
		deaths.put(entry, Instant.now().plusMillis(ms));
		return true;
	}

	@Override
	public void attemptEviction(Map<String, Object> cache) {
		Instant now = Instant.now();
		for (String url : cache.keySet())
			if (deaths.get(url).isBefore(now)) cache.remove(url);
	}

	@Override
	public boolean newRequest(Map<String, Object> cache, String request) {
		return true;
	}

	@Override
	public void refresh(Map<String, Object> cache) {
		for (String url : deaths.keySet())
			if (!cache.containsKey(url)) deaths.remove(url);
	}

}
