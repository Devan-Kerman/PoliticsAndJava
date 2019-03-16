package ai.play.devtech.core.fun;

import sun.misc.Unsafe;

public class UnsafeObjects {
	
	private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
	/**
	 * This will create a new object, using the "default" java no-arg constructor, even if it is overriden
	 */
	@SuppressWarnings("unchecked")
	public static <T> T blankObj(Class<T> classt) {
		try {
			return (T) UNSAFE.allocateInstance(classt);
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
