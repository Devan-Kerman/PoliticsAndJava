package ai.play.devtech.core.util.logic;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Used for better thread-safeing
 *
 * @param <T> the type of lock
 * @author devan
 */
public class Lock<T> {
	private Set<T> lock = Collections.newSetFromMap(new ConcurrentHashMap<>());

	public void lock(T thing) {
		while (true) if (!lock.contains(thing)) break;
		lock.add(thing);
	}

	public void unlock(T thing) {
		lock.remove(thing);
	}
}
