package ai.play.devtech.core.objects.manipulation;

import java.awt.Color;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.beryx.awt.color.ColorFactory;

import ai.play.devtech.Sys;
import ai.play.devtech.core.util.logic.Try;

/**
 * Initializes objects given their DataName or FieldName using provided data
 *
 * @param <T>
 * @author devan
 */
public class ObjectBuilder<T> {
	private Class<T> type;
	private Map<String, Object> psudoobj;

	public ObjectBuilder(Class<T> type) {
		this.type = type;
		psudoobj = new HashMap<>();
	}

	public ObjectBuilder<T> add(String varname, Object value) {
		psudoobj.put(varname, value);
		return this;
	}

	public ObjectBuilder<T> addAll(Map<String, Object> map) {
		map.forEach((s, o) -> psudoobj.put(s, o));
		return this;
	}

	public T build() {
		try {
			if (type.isArray())
				return deepCorrect(psudoobj.get("array"), type);
			return deepCorrect(psudoobj, type);
		} catch (Exception e) {
			Sys.err("Exception on build");
			e.printStackTrace();
			return null;
		}
	}

	// Map -> War object
	// X simple
	// V in is map, out is not map
	//
	@SuppressWarnings({ "unchecked" })
	private <K> K deepCorrect(Object in, Class<K> type) throws Exception {
		if (isSimple(in))
			return correct(in, type);
		if (in instanceof List && type.isArray()) {
			List<?> list = (List<?>) in;
			Object o = Array.newInstance(type.getComponentType(), list.size());
			for (int x = 0; x < list.size(); x++)
				Array.set(o, x, deepCorrect(list.get(x), type.getComponentType()));
			return (K) o;
		} else if (in instanceof Map && !Map.class.isAssignableFrom(type)) {
			Map<String, Object> obj = (Map<String, Object>) in;
			Field[] des = type.getFields();
			K k = type.newInstance();
			for (Field f : des) {
				DataName anno = f.getAnnotation(DataName.class);
				try {
					if (anno == null)
						f.set(k, deepCorrect(obj.get(f.getName()), f.getType()));
					else
						f.set(k, deepCorrect(obj.get(anno.name()), f.getType()));
				} catch (Exception e) {
					e.printStackTrace();
					Sys.err("ERROR %s -> %s", obj.get(anno.name()), f.getType());
				}
			}
			return k;
		}

		if (type.isPrimitive()) {
			if (type == boolean.class || type == Boolean.class)
				return (K) (Object) false;
			if (type == int.class || type == Integer.class)
				return (K) (Object) 0;
			if (type == byte.class || type == Byte.class)
				return (K) (Object) (byte) 0;
			if (type == short.class || type == Short.class)
				return (K) (Object) (short) 0;
			if (type == long.class || type == Long.class)
				return (K) (Object) 0L;
			if (type == float.class || type == Float.class)
				return (K) (Object) 0.0f;
			if (type == double.class || type == Double.class)
				return (K) (Object) 0.0d;

		}
		return null;
	}

	private boolean isSimple(Object o) {
		return o instanceof Number || o instanceof String || o instanceof Character || o instanceof Boolean;
	}

	
	private final SimpleDateFormat DTF1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");
	private final SimpleDateFormat DTF2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final SimpleDateFormat DTF3 = new SimpleDateFormat("yyyy-mm-dd");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Enum<?> getEnum(Class tckass, String in) {
		return Enum.valueOf(tckass, in.toUpperCase().replace(' ', '_'));
	}

	@SuppressWarnings("unchecked")
	private <K> K correct(Object input, Class<K> outtype) {
		Class<?> inclass = input.getClass();
		Object in = input instanceof Optional<?> ? ((Optional<?>) input).get() : input;
		K k = null;
		if (in == null)
			;
		else if (outtype.isAssignableFrom(in.getClass()))
			k = outtype.cast(in);
		else if (inclass.isArray() && !outtype.isArray() && inclass.getComponentType().isAssignableFrom(outtype))
			return (K) Array.get(in, 0);
		else if (inclass.isArray() && !outtype.isArray())
			return correct(Array.get(in, 0), outtype);
		else if (outtype == String.class)
			k = (K) in.toString();
		else if (outtype.isEnum()) {
			if (in instanceof String)
				k = (K) getEnum(outtype, (String) in);
		} else if (Date.class == outtype) {
			if (in instanceof String)
				k = (K) Try.tryElse(t -> !(t instanceof ParseException), () -> DTF1.parse(in.toString()), () -> DTF2.parse(in.toString()), () -> DTF3.parse(in.toString()));
		} else if (Color.class.isAssignableFrom(outtype)) {
			if (in instanceof String)
				k = (K) ColorFactory.valueOf(in.toString());
		} else if (outtype == Boolean.class || outtype == boolean.class) {
			if (in instanceof Number)
				k = (K) Boolean.valueOf(((Number) in).byteValue() != 0);
			else if (in instanceof String)
				k = (K) Boolean.valueOf(!((String) in).equals("0") || !((String) in).equals("no"));
			else if (in instanceof Character)
				k = (K) Boolean.valueOf(Character.toUpperCase((Character) in) == 'Y');
			else
				k = (K) Boolean.valueOf(in != null);
		} else if (outtype == Byte.class || outtype == byte.class) {
			if (in instanceof Number)
				k = (K) Byte.valueOf(((Number) in).byteValue());
			else if (in instanceof String)
				k = (K) Byte.valueOf(Byte.parseByte(in.toString()));
			else if (in instanceof Character)
				k = (K) Byte.valueOf(Byte.parseByte(in.toString()));
			else
				k = (K) Byte.valueOf((byte) in.hashCode());
		} else if (outtype == Short.class || outtype == short.class) {
			if (in instanceof Number)
				k = (K) Short.valueOf(((Number) in).shortValue());
			else if (in instanceof String)
				k = (K) Short.valueOf(Short.parseShort(in.toString()));
			else if (in instanceof Character)
				k = (K) Short.valueOf(Short.parseShort(in.toString()));
			else
				k = (K) Short.valueOf((short) in.hashCode());
		} else if (outtype == Integer.class || outtype == int.class) {
			if (in instanceof Number)
				k = (K) Integer.valueOf(((Number) in).intValue());
			else if (in instanceof String)
				k = (K) Integer.valueOf(Integer.parseInt(in.toString()));
			else if (in instanceof Character)
				k = (K) Integer.valueOf(Integer.parseInt(in.toString()));
			else
				k = (K) Integer.valueOf(in.hashCode());
		} else if (outtype == Long.class || outtype == long.class) {
			if (in instanceof Number)
				k = (K) Long.valueOf(((Number) in).longValue());
			else if (in instanceof String)
				k = (K) Long.valueOf(Long.parseLong(in.toString()));
			else if (in instanceof Character)
				k = (K) Long.valueOf(Long.parseLong(in.toString()));
			else
				k = (K) Long.valueOf(in.hashCode());
		} else if (outtype == Float.class || outtype == float.class) {
			if (in instanceof Number)
				k = (K) Float.valueOf(((Number) in).floatValue());
			else if (in instanceof String)
				k = (K) Float.valueOf(Float.parseFloat(in.toString()));
			else if (in instanceof Character)
				k = (K) Float.valueOf(Float.parseFloat(in.toString()));
			else
				k = (K) Float.valueOf(in.hashCode());
		} else if (outtype == Double.class || outtype == double.class) {
			if (in instanceof Number)
				k = (K) Double.valueOf(((Number) in).doubleValue());
			else if (in instanceof String)
				k = (K) Double.valueOf(Double.parseDouble(in.toString()));
			else if (in instanceof Character)
				k = (K) Double.valueOf(Double.parseDouble(in.toString()));
			else
				k = (K) Double.valueOf(in.hashCode());
		}
		return k;
	}
}
