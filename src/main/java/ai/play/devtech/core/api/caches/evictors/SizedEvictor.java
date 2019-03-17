package ai.play.devtech.core.api.caches.evictors;

import ai.play.devtech.core.api.interfaces.Evictor;
import com.google.common.collect.Queues;
import java.util.Map;
import java.util.Queue;

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
		urls = Queues.newConcurrentLinkedQueue();
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
