package ai.play.devtech.api.caches.util.locks;

public class EmptyLock<T> implements Lock<T> {

	@Override
	public void lock(T key) {
		
	}

	@Override
	public void unlock(T key) {
		
	}

}
