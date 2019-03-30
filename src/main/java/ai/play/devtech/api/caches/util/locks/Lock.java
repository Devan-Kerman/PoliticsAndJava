package ai.play.devtech.api.caches.util.locks;

public interface Lock<T> {
	
	/**
	 * Wait until the key is free, then add the key to the queue
	 * @param key the key to lock
	 */
	public void lock(T key);
	
	/**
	 * removes the key from the lock
	 * @param key
	 */
	public void unlock(T key);
}
