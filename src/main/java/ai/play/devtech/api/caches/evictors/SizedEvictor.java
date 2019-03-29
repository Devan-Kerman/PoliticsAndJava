package ai.play.devtech.api.caches.evictors;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import ai.play.devtech.core.interfaces.Evictor;

/**
 * An evictor that evicts objects based on priority, and only after the cache holds over the specified max size
 *
 * @author devan
 */
public class SizedEvictor implements Evictor {

	private Queue<String> urls;
	private int maxsize;

	/**
	 * @param maxsize max capacity of the cache
	 */
	public SizedEvictor(int maxsize) {
		this.maxsize = maxsize;
		urls = new ConcurrentLinkedQueue<>();
	}

	@Override
	public boolean newEntry(Map<String, Object> cache, String entry, Object result) {
		urls.add(entry);
		return true;
	}

	@Override
	public void attemptEviction(Map<String, Object> cache) {
		while (cache.size() > maxsize) cache.remove(urls.poll());
	}

	@Override
	public boolean newRequest(Map<String, Object> cache, String request) {
		urls.remove(request);
		urls.add(request);
		return true;
	}

	@Override
	public void refresh(Map<String, Object> cache) {
		for (String url : urls)
			if (!cache.containsKey(url)) urls.remove(url);
	}

}
