package ai.play.devtech.core.util.strings;

import java.util.Arrays;
import java.util.List;

public class StrnCompile {

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
}
