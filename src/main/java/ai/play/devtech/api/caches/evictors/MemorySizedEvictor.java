package ai.play.devtech.api.caches.evictors;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import ai.play.devtech.core.interfaces.Evictor;
import ai.play.devtech.core.util.misc.UnsafeUtil;

/**
 * Evitor that evicts based on the amount of memory consumed
 *
 * @author devan
 */
public class MemorySizedEvictor implements Evictor {

	private Set<String> urls;
	private long maxBytes;
	private long current;

	/**
	 * @param maxBytes maximum amount of bytes before the evictor will start evicting objects in order of priority
	 */
	public MemorySizedEvictor(long maxBytes) {
		this.maxBytes = maxBytes;
		urls = Collections.newSetFromMap(new ConcurrentHashMap<>());
	}

	@Override
	public boolean newEntry(Map<String, Object> cache, String entry, Object result) {
		urls.add(entry);
		return true;
	}

	@Override
	public void attemptEviction(Map<String, Object> cache) {
		cache.forEach((s, o) -> {
			if (UnsafeUtil.deepSizeOf(o) + current > maxBytes) {
				cache.remove(s);
				urls.remove(s);
			}
		});
	}

	@Override
	public boolean newRequest(Map<String, Object> cache, String request) {
		urls.add(request);
		return true;
	}

	@Override
	public void refresh(Map<String, Object> cache) {
		for (String url : urls)
			if (!cache.containsKey(url)) urls.remove(url);
		current = 0;
		for (Object o : cache.values())
			current += UnsafeUtil.deepSizeOf(o);

	}

}
