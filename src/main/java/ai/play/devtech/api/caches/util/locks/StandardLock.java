package ai.play.devtech.api.caches.util.locks;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StandardLock<T> implements Lock<T> {

	private volatile Set<T> lock = Collections.newSetFromMap(new ConcurrentHashMap<>());

	@Override
	public void lock(T key) {
		while(lock.contains(key));
		lock.add(key);
	}

	@Override
	public void unlock(T key) {
		lock.remove(key);
	}

}
