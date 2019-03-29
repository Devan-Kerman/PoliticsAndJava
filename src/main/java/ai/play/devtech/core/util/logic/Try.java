package ai.play.devtech.core.util.logic;

import java.util.function.Predicate;

import ai.play.devtech.core.interfaces.EProducer;
import ai.play.devtech.core.interfaces.ERunnable;

public class Try {

	private Try() {}

	/**
	 * if the runnable throws an exception, it catches it and does nothing
	 *
	 * @param r
	 */
	public static void tryIgnore(Runnable r) {
		try {
			r.run();
		} catch (Exception e) {}
	}
	
	public static void tryEIgnore(ERunnable r) {
		try {
			r.run();
		} catch(Exception e) {}
	}
	
	
	
	@SafeVarargs
	public static <T> T tryElse(Predicate<Throwable> print, EProducer<T>...prods) {
		return tryElse(print, prods, 0);
	}
	
	private static <T> T tryElse(Predicate<Throwable> print, EProducer<T>[] arr, int start) {
		try {
			return arr[start].run();
		} catch(Throwable e) {
			if(print.test(e))
				throw new RuntimeException(e);
			return tryElse(print, arr, start+1);
		}
	}
	
}
