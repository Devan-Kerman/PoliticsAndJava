package ai.play.devtech.core.util.strings;

import com.google.gson.Gson;
import javax.xml.bind.JAXB;
import java.io.StringWriter;

public class ToString {

	static final Gson gson = new Gson();

	public static String toXML(Object in) {
		StringWriter sw = new StringWriter();
		JAXB.marshal(in, sw);
		return sw.toString();
	}

	public static String toJson(Object in) {
		return gson.toJson(in);
	}

	private ToString() {
		throw new UnsupportedOperationException("utility class");
	}

}