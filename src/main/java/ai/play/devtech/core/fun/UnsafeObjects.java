package ai.play.devtech.core.fun;

import sun.misc.Unsafe;

public class UnsafeObjects {
	
	private final static Unsafe UNSAFE = UnsafeUtil.getUnsafe();
	/**
	 * This will create a new object, using the "default" java no-arg constructor, even if it is overriden
	 */
	@SuppressWarnings("unchecked")
	public static <T> T blankObj(Class<T> classt) {
		try {
			T thing = (T) UNSAFE.allocateInstance(classt);
			return thing;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
