package ai.play.devtech.core.hooks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * given arrays for data, it will give all of it's listeners the difference
 * between the 2 datas, in reverse or not
 *
 * @param <T> The component type (not array type)
 * @author devan
 */
public class ArrayHook<T> extends TimerTask implements Runnable {
	Map<String, Consumer<T>> listeners;
	T[] old;
	Supplier<T[]> agg;
	boolean reverse;
	BiPredicate<T, T> equals;
	Runnable escape;

	/**
	 * @param src Supplier of array data
	 * @param reverse True: new objects False: deleted objects
	 * @param equals to determine whether 2 objects are the same or not
	 */
	public ArrayHook(Supplier<T[]> src, BiPredicate<T, T> equals, boolean reverse) {
		listeners = new LinkedHashMap<>();
		this.agg = src;
		old = src.get();
		this.reverse = reverse;
		this.equals = equals;
	}

	public ArrayHook(Supplier<T[]> src, BiPredicate<T, T> equals, Runnable escape, boolean reverse) {
		this(src, equals, reverse);
		this.escape = escape;
	}

	public void addListener(String id, Consumer<T> joined) {
		listeners.put(id, joined);
	}

	public Consumer<T> removeListener(String id) {
		return listeners.remove(id);
	}

	@Override
	public void run() {
		T[] newdata = agg.get();
		if (reverse) outer:for (T t : old) {
			for (T c : newdata)
				if (equals.test(t, c)) continue outer;
			listeners.forEach((k, v) -> v.accept(t));
		}
		else outer:for (T t : newdata) {
			for (T c : old)
				if (equals.test(t, c)) continue outer;
			listeners.forEach((k, v) -> v.accept(t));
		}

		old = newdata;
		if (escape != null) escape.run();
	}

}
