package ai.play.devtech.core.util.s;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Strings {
	public static String appendln(List<String> strn) {
		StringBuilder builder = new StringBuilder();
		strn.stream().map(s -> String.format("%s\n", s)).forEach(builder::append);
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

	public static String appendln(String... strn) {
		StringBuilder builder = new StringBuilder();
		Arrays.stream(strn).map(s -> String.format("%s\n", s)).forEach(builder::append);
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
	
	static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


	public static String toJson(Object in) {
		return gson.toJson(in);
	}
	
	public static <T> String join(String delim, List<T> list) {
		StringBuilder builder = new StringBuilder();
		list.forEach(t -> builder.append(t).append(delim));
		builder.setLength(builder.length()-1);
		return builder.toString();
	}
	
	@SafeVarargs
	public static <T> String join(String delim, T...ts) {
		return join(delim, Arrays.asList(ts));
	}
	
	
}
