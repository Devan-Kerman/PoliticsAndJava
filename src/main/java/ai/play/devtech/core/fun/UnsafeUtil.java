package ai.play.devtech.core.fun;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.IdentityHashMap;

import sun.misc.Unsafe;

/*
 * Copy pasted from SO https:
 * @author devan
 *
 */
public class UnsafeUtil {
	enum AddressMode {
		UNKNOWN,
		MEM_32BIT,
		MEM_64BIT,
		MEM_64BIT_COMPRESSED_OOPS
	}

	
	public static final AddressMode ADDRESS_MODE;

	private static final Unsafe UNSAFE;

	private static final long ADDRESS_SIZE; 
	private static final long REFERENCE_SIZE; 
												
	private static final long OBJECT_BASE_SIZE; 
												
	private static final long OBJECT_ALIGNMENT = 8;

	static {
		try {
			
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			UNSAFE = (Unsafe) f.get(null);
			class T {
				@SuppressWarnings("unused")
				byte b;
			}
			OBJECT_BASE_SIZE = UNSAFE.objectFieldOffset(T.class.getDeclaredField("b"));

			ADDRESS_SIZE = UNSAFE.addressSize();
			REFERENCE_SIZE = UNSAFE.arrayIndexScale(Object[].class);

			if (ADDRESS_SIZE == 4) {
				ADDRESS_MODE = AddressMode.MEM_32BIT;
			} else if (ADDRESS_SIZE == 8 && REFERENCE_SIZE == 8) {
				ADDRESS_MODE = AddressMode.MEM_64BIT;
			} else if (ADDRESS_SIZE == 8 && REFERENCE_SIZE == 4) {
				ADDRESS_MODE = AddressMode.MEM_64BIT_COMPRESSED_OOPS;
			} else {
				ADDRESS_MODE = AddressMode.UNKNOWN;
			}
		} catch (Exception e) {
			throw new Error(e);
		}
	}
	
	public static Unsafe getUnsafe() {
		return UNSAFE;
	}
	
	public static long shallowSizeOf(final Object object) {
		Class<?> objectClass = object.getClass();
		if (objectClass.isArray()) {
			
			long size = UNSAFE.arrayBaseOffset(objectClass)
					+ (long)UNSAFE.arrayIndexScale(objectClass) * Array.getLength(object);
			return padSize(size);
		} else {
			
			long size = OBJECT_BASE_SIZE;
			do {
				for (Field field : objectClass.getDeclaredFields()) {
					if ((field.getModifiers() & Modifier.STATIC) == 0) {
						long offset = UNSAFE.objectFieldOffset(field);
						if (offset >= size) {
							size = offset + 1; 
												
						}
					}
				}
				objectClass = objectClass.getSuperclass();
			} while (objectClass != null);

			return padSize(size);
		}
	}

	private static final long padSize(final long size) {
		return (size + (OBJECT_ALIGNMENT - 1)) & ~(OBJECT_ALIGNMENT - 1);
	}

	
	public static long deepSizeOf(final Object object) {
		IdentityHashMap<Object, Object> visited = new IdentityHashMap<>();
		Deque<Object> stack = new ArrayDeque<>();
		if (object != null)
			stack.push(object);

		long size = 0;
		while (!stack.isEmpty()) {
			size += internalSizeOf(stack.pop(), stack, visited);
		}
		return size;
	}

	private static long internalSizeOf(final Object object, final Deque<Object> stack,
			final IdentityHashMap<Object, Object> visited) {
		
		Class<?> c = object.getClass();
		if (c.isArray() && !c.getComponentType().isPrimitive()) {
			
			for (int i = Array.getLength(object) - 1; i >= 0; i--) {
				Object val = Array.get(object, i);
				if (val != null && visited.put(val, val) == null) {
					stack.add(val);
				}
			}
		} else {
			
			for (; c != null; c = c.getSuperclass()) {
				for (Field field : c.getDeclaredFields()) {
					if ((field.getModifiers() & Modifier.STATIC) == 0 && !field.getType().isPrimitive()) {
						field.setAccessible(true);
						try {
							Object val = field.get(object);
							if (val != null && visited.put(val, val) == null) {
								stack.add(val);
							}
						} catch (IllegalArgumentException e) {
							throw new IllegalArgumentException(e);
						} catch (IllegalAccessException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return shallowSizeOf(object);
	}

}
