package ai.play.devtech.core.api.caches.evictors;

import java.util.Map;
import java.util.Queue;

import com.google.common.collect.Queues;

import ai.play.devtech.core.api.interfaces.Evictor;

public class SizedEvictor implements Evictor {
	
	private Queue<String> urls;
	private int maxsize;
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
		while(cache.size() > maxsize)
			cache.remove(urls.poll());
	}

	@Override
	public boolean newRequest(Map<String, Object> cache, String request) {
		urls.remove(request);
		urls.add(request);
		return true;
	}

	@Override
	public void refresh(Map<String, Object> cache) {
		for(String url : urls)
			if(!cache.containsKey(url))
				urls.remove(url);
	}

}
