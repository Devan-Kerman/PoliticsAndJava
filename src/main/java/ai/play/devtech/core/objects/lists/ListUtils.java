package ai.play.devtech.core.objects.lists;

import java.lang.reflect.Array;
import java.util.List;

public class ListUtils {

	/**
	 * Converts a list to an array
	 *
	 * @param list the list
	 * @param clas component type
	 * @return
	 */
	@SuppressWarnings ("unchecked")
	public static <T> T[] listToArray(List<T> list, Class<T> clas) {
		Object o = Array.newInstance(clas, list.size());
		for (int x = 0; x < list.size(); x++)
			Array.set(o, x, list.get(x));
		return (T[]) o;
	}

}
