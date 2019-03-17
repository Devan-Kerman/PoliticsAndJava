package ai.play.devtech.api.hooks;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ListHook<T> extends TimerTask implements Runnable {

	Map<String, Consumer<T>> listeners;
	List<T> old;
	Supplier<List<T>> agg;
	boolean reverse;
	BiPredicate<T, T> equals;
	Runnable escape;

	/**
	 * @param src Supplier of array data
	 * @param reverse True: new objects False: deleted objects
	 * @param equals to determine whether 2 objects are the same or not
	 */
	public ListHook(Supplier<List<T>> src, BiPredicate<T, T> equals, boolean reverse) {
		listeners = new LinkedHashMap<>();
		this.agg = src;
		old = src.get();
		this.reverse = reverse;
		this.equals = equals;
	}

	public ListHook(Supplier<List<T>> src, BiPredicate<T, T> equals, Runnable escape, boolean reverse) {
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
		List<T> newdata = agg.get();
		List<T> dif = new LinkedList<>();
		if (reverse) old.stream().filter(i -> pC(newdata, i)).forEach(dif::add);
		else newdata.stream().filter(i -> pC(old, i)).forEach(dif::add);
		old = newdata;
		dif.forEach(t -> listeners.forEach((k, v) -> v.accept(t)));
		if (escape != null) escape.run();
	}

	/*
	 * just ot check if this list has this object
	 */
	public boolean pC(List<T> t, T obj) {
		for (T tobj : t)
			if (equals.test(tobj, obj)) return true;
		return false;
	}

}
