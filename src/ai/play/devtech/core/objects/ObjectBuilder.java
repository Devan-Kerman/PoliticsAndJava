package ai.play.devtech.core.objects;

import java.awt.Color;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.beryx.awt.color.ColorFactory;

import com.google.common.base.Defaults;

import ai.play.devtech.DLogger;

public class ObjectBuilder<T> {
	private Class<T> type;
	private Map<String, Object> psudoobj;
	
	public ObjectBuilder(Class<T> type) {
		this.type = type;
		psudoobj = new PsudObj<>();
	}
	
	public void add(String varname, Object value) {
		psudoobj.put(varname, value);
	}
	
	public void addAll(Map<String, Object> map) {
		map.forEach((s, o) -> psudoobj.put(s, o));
	}
	
	
	public T build() {
		try {
			if(type.isArray())
				return deepCorrect(psudoobj.get("array"), type);
			return deepCorrect(psudoobj, type);
		} catch(Exception e) {
			DLogger.error("Exception on build");
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private <K> K deepCorrect(Object in, Class<K> type) throws Exception {
		if(isSimple(in)) {
			return correct(in, type);
		} else if(in instanceof Map && !Map.class.isAssignableFrom(type)) {
			Map<String, Object> obj = (Map<String, Object>)in;
			Field[] des = type.getFields();
			K k = type.newInstance();
			for(Field f : des) {
				JSONName anno = f.getAnnotation(JSONName.class);
				if(anno==null)
					f.set(k, deepCorrect(obj.get(f.getName()), f.getType()));
				else
					f.set(k, deepCorrect(obj.get(anno.name()), f.getType()));
			}
			return k;
		} else if(in instanceof List && type.isArray()) {
			List<?> list = (List<?>)in;
			Object o = Array.newInstance(type.getComponentType(), list.size());
			for(int x = 0; x < list.size(); x++)
				Array.set(o, x, deepCorrect(list.get(x), o.getClass().getComponentType()));
			return (K)o;
		}
		return Defaults.defaultValue(type);
	}
	
	private boolean isSimple(Object o) {
		return o instanceof Number || o instanceof String || o instanceof Character || o instanceof Boolean;
	}
	public static final DateTimeFormatter dtf1 = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
	public static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
	
	@SuppressWarnings("unchecked")
	private <K> K correct(Object in, Class<K> outtype) {
		if(in instanceof Optional<?> || in instanceof Optional)
			in = ((Optional<?>)in).get();
		K k = null;
		if(in == null) {
			return k;
		} else if(outtype.isAssignableFrom(in.getClass())) {
			k = outtype.cast(in);
		} else if(outtype == String.class) {
			k =  (K) in.toString();
		} else if(outtype.isEnum()) {
			final Object en = in;
			if(in instanceof String)
				k =  Arrays.stream(outtype.getEnumConstants()).filter(e -> e.toString().equalsIgnoreCase(en.toString().replace(' ', '_'))).findFirst().get();
		} else if(Date.class.isAssignableFrom(outtype)) {
			if(in instanceof String)
				try {
					k =  (K)(Date)dtf1.parse(in.toString());
				} catch(Exception e) {
					k =  (K)(Date)dtf2.parse(in.toString());
				}
		} else if(Color.class.isAssignableFrom(outtype)) {
			if(in instanceof String)
				k =  (K) ColorFactory.valueOf(in.toString());
		} else if(outtype == Boolean.class || outtype == boolean.class) {
			if(in instanceof Number)
				k =  (K)Boolean.valueOf(((Number)in).byteValue() != 0);
			else if(in instanceof String)
				k =  (K)Boolean.valueOf(!((String)in).equals("0") || !((String)in).equals("no"));
			else if(in instanceof Character)
				k =  (K)Boolean.valueOf(Character.toUpperCase((Character)in) =='Y');
			else
				k =  (K)Boolean.valueOf(in!=null);
		} else if(outtype == Byte.class || outtype == byte.class) {
			if(in instanceof Number)
				k =  (K)Byte.valueOf(((Number)in).byteValue());
			else if(in instanceof String)
				k =  (K)Byte.valueOf(Byte.parseByte(in.toString()));
			else if(in instanceof Character)
				k =  (K)Byte.valueOf(Byte.parseByte(in.toString()));
			else
				k =  (K)Byte.valueOf((byte)in.hashCode());
		} else if(outtype == Short.class || outtype == short.class) {
			if(in instanceof Number)
				k =  (K)Short.valueOf(((Number)in).shortValue());
			else if(in instanceof String)
				k =  (K)Short.valueOf(Short.parseShort(in.toString()));
			else if(in instanceof Character)
				k =  (K)Short.valueOf(Short.parseShort(in.toString()));
			else
				k =  (K)Short.valueOf((short)in.hashCode());
		} else if(outtype == Integer.class || outtype == int.class) {
			if(in instanceof Number)
				k =  (K)Integer.valueOf(((Number)in).intValue());
			else if(in instanceof String)
				k =  (K)Integer.valueOf(Integer.parseInt(in.toString()));
			else if(in instanceof Character)
				k =  (K)Integer.valueOf(Integer.parseInt(in.toString()));
			else
				k =  (K)Integer.valueOf(in.hashCode());
		} else if(outtype == Long.class || outtype == long.class) {
			if(in instanceof Number)
				k =  (K)Long.valueOf(((Number)in).longValue());
			else if(in instanceof String)
				k =  (K)Long.valueOf(Long.parseLong(in.toString()));
			else if(in instanceof Character)
				k =  (K)Long.valueOf(Long.parseLong(in.toString()));
			else
				k =  (K)Long.valueOf(in.hashCode());
		} else if(outtype == Float.class || outtype == float.class) {
			if(in instanceof Number)
				k =  (K)Float.valueOf(((Number)in).floatValue());
			else if(in instanceof String)
				k =  (K)Float.valueOf(Float.parseFloat(in.toString()));
			else if(in instanceof Character)
				k =  (K)Float.valueOf(Float.parseFloat(in.toString()));
			else
				k =  (K)Float.valueOf(in.hashCode());
		} else if(outtype == Double.class || outtype == double.class) {
			if(in instanceof Number)
				k =  (K)Double.valueOf(((Number)in).doubleValue());
			else if(in instanceof String)
				k =  (K)Double.valueOf(Double.parseDouble(in.toString()));
			else if(in instanceof Character)
				k =  (K)Double.valueOf(Double.parseDouble(in.toString()));
			else
				k =  (K)Double.valueOf(in.hashCode());
		}
		return k;
	} 
}
