package ai.play.devtech.core.api.caches.evictors;

import java.util.Map;
import java.util.Queue;

import com.google.common.collect.Queues;

import ai.play.devtech.core.api.interfaces.Evictor;
import ai.play.devtech.core.fun.UnsafeUtil;

public class MemorySizedEvictor implements Evictor {

	private Queue<String> urls;
	private long maxBytes;
	private long current;
	public MemorySizedEvictor(long maxBytes) {
		this.maxBytes = maxBytes;
		urls = Queues.newConcurrentLinkedQueue();
	}
	
	@Override
	public boolean newEntry(Map<String, Object> cache, String entry, Object result) {
		urls.remove(entry);
		urls.add(entry);
		return true;
	}

	@Override
	public void attemptEviction(Map<String, Object> cache) {
		cache.forEach((s, o) -> {
			if(UnsafeUtil.deepSizeOf(o) + current > maxBytes) {
				cache.remove(s);
				urls.remove(s);
			}
		});
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
		current = 0;
		for(Object o : cache.values())
			current+= UnsafeUtil.deepSizeOf(o);
			
	}
	
}