package tests.test.testing;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ai.play.devtech.Sys;
import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.core.api.tradeprice.TradePrice;
import ai.play.devtech.core.enums.Resource;

public class Tests {

	private static APIAggregator agg = new APIAggregator("REDACTED");

	public static void main(String[] args) {
		queue(() -> {
			TradePrice price = agg.getPrice(Resource.COAL);
			System.out.println("Tradeprice");
			test(price);
		});
		queue(() -> {
			Object o = agg.getAlliance(2082);
			System.out.println("Alliance");
			test(o);
		});
		queue(() -> {
			Object o = agg.getNation(106571);
			System.out.println("Nation");
			test(o);
		});
		queue(() -> {
			Object o = agg.getWar(416547);
			System.out.println("War");
			test(o);
		});
		queue(() -> {
			Object o = agg.getAAWars(2082)[0];
			System.out.println("Wars");
			test(o);
		});
		queue(() -> {
			Object o = agg.getAllNations()[0];
			System.out.println("Nations");
			test(o);
		});
		queue(() -> {
			Object o = agg.getAlliances()[0];
			System.out.println("Alliances");
			test(o);
		});
		queue(() -> {
			Object o = agg.getWars()[0];
			System.out.println("All wars");
			test(o);
		});
		queue(() -> {
			Object o = agg.getMaxWars(10)[0];
			System.out.println("Limited wars");
			test(o);
		});
		queue(() -> {
			Object o = agg.getCities()[0];
			System.out.println("Cities");
			test(o);
		});
		queue(() -> {
			Object o = agg.getMilitaries()[0];
			System.out.println("Military");
			test(o);
		});
		queue(() -> {
			Object o = agg.getCity(183895);
			System.out.println("City");
			test(o);
		});
		queue(() -> {
			Object o = agg.getTradeHistory()[0];
			System.out.println("Trade History");
			test(o);
		});
		queue(() -> {
			Object o = agg.getTradeHistory(10)[0];
			System.out.println("Trade records");
			test(o);
		});
		queue(() -> {
			Object o = agg.getTradeHistory(Resource.IRON);
			System.out.println("Trade rss");
			test(o);
		});
		queue(() -> {
			Object o = agg.getAttacks(416547)[0];
			System.out.println("War attacks");
			test(o);
		});
		queue(() -> {
			Object o = 0;
			System.out.println("War attacks min");
			test(o);
		});
	}

	private static ExecutorService serv = Executors.newFixedThreadPool(2);

	private static void queue(Runnable r) {
		serv.execute(r);
	}

	private static <T> boolean test(T o) {
		Class<? extends Object> tclass = o.getClass();
		for (Field field : tclass.getDeclaredFields()) {
			boolean ens = field.isAccessible();
			field.setAccessible(true);
			try {
				Class<?> type = field.getType();
				PrintStream stream = System.out;

				if (type.isPrimitive()) {
					if (type == byte.class && field.getByte(o) == 0)
						stream = System.err;
					if (type == short.class && field.getShort(o) == 0)
						stream = System.err;
					if (type == int.class && field.getInt(o) == 0)
						stream = System.err;
					if (type == long.class && field.getLong(o) == 0)
						stream = System.err;

					if (type == float.class && field.getFloat(o) == 0)
						stream = System.err;
					if (type == double.class && field.getDouble(o) == 0)
						stream = System.err;
					if (type == char.class && field.getChar(o) == 0)
						Sys.err("[%s] was 0", field, tclass);
				} else if (field.get(o) == null) {
					stream = System.err;
				}
				stream.printf("\t- %s : %s\n", field.getName(), toStrn(field.get(o)));
				stream.flush();
				System.out.flush();
				System.err.flush();
			} catch (Throwable t) {
				t.printStackTrace();
				Sys.err("ERROR");
			}
			field.setAccessible(ens);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private static <T> String toStrn(Object o) {
		if (o == null)
			return "null";
		Class<?> _class = o.getClass();
		if (_class.isArray()) {
			Class<?> comp = _class.getComponentType();
			if (comp == boolean.class)
				return Arrays.toString((boolean[]) o);
			if (comp == byte.class)
				return Arrays.toString((byte[]) o);
			if (comp == short.class)
				return Arrays.toString((short[]) o);
			if (comp == char.class)
				return Arrays.toString((char[]) o);
			if (comp == int.class)
				return Arrays.toString((int[]) o);
			if (comp == long.class)
				return Arrays.toString((long[]) o);

			if (comp == float.class)
				return Arrays.toString((float[]) o);
			if (comp == double.class)
				return Arrays.toString((double[]) o);
			return Arrays.toString((T[]) o);
		} else
			return String.valueOf(o);
	}
}
