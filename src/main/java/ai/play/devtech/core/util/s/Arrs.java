package ai.play.devtech.core.util.s;

import java.lang.reflect.Array;
import java.util.List;

public class Arrs {
	
	@SafeVarargs
	public static <T> T[] vargs(T...ts) {return ts;}
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T[]> arrayClass(Class<T> clas) {return (Class<T[]>) Array.newInstance(clas, 0).getClass();}
	
	public static <T> T[] toArray(List<T> list) {
		return toArray(list, findClass(list));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(List<T> list, Class<T> _class) {
		T[] arr = (T[]) Array.newInstance(_class, list.size());
		for(int x = 0; x < arr.length; x++)
			arr[x] = list.get(x);
		return arr;
	}
	
	@SuppressWarnings("unchecked")
	private static <T> Class<T> findClass(List<T> list) {
		Class<T> highest = null;
		for(T t : list)
			if (t != null && (highest == null || !highest.isInstance(t)))
				highest = (Class<T>) t.getClass();
		return null;
	}
}
