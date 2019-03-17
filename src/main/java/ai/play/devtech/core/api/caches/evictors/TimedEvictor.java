package ai.play.devtech.core.api.caches.evictors;

import ai.play.devtech.core.api.interfaces.Evictor;
import com.google.common.collect.Maps;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class TimedEvictor implements Evictor {

	private Map<String, Instant> deaths;
	private long ms;

	public TimedEvictor(Duration expiry) {
		ms = expiry.toMillis();
		deaths = Maps.newConcurrentMap();
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
