package ai.play.devtech.core.util.strings;

import com.google.gson.Gson;

public class ToString {

	static final Gson gson = new Gson();


	public static String toJson(Object in) {
		return gson.toJson(in);
	}

	private ToString() {
		throw new UnsupportedOperationException("utility class");
	}

}
