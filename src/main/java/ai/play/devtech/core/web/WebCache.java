package ai.play.devtech.core.web;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Function;


/**
 * Cache for the web aggregator
 *
 * @author devan
 */
public class WebCache {

	protected Map<String, Entry> datamap;
	protected Period decay;
	protected static Gson gson = new Gson();

	protected Set<String> current = new ConcurrentSkipListSet<>();

	@SuppressWarnings ("unchecked")
	protected <T> T request(String url, Function<Document, T> parse) {
		while (true) if (!current.contains(url)) break;
		current.add(url);
		Entry in = datamap.get(url);
		if (in != null) if (in.death.isAfter(Instant.now())) {
			current.remove(url);
			return (T) in.data;
		} else datamap.remove(url);

		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			T parsed = parse.apply(doc);
			datamap.put(url, new Entry(parsed, Instant.now().plus(decay.time, decay.unit)));
			current.remove(url);
			return parsed;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebCache() {
		this(50, new Period(ChronoUnit.HOURS, 1));
	}

	public WebCache(int size) {
		this(size, new Period(ChronoUnit.HOURS, 1));
	}

	public WebCache(ChronoUnit time, int amount) {
		this(50, new Period(time, amount));
	}


	public WebCache(int size, Period p) {
		datamap = new ConcurrentHashMap<>(size);
		decay = p;
	}
}

class Entry {
	Object data;
	Instant death;

	Entry(Object data, Instant death) {
		this.data = data;
		this.death = death;
	}
}

class Period {
	public ChronoUnit unit;
	public int time;

	public Period(ChronoUnit unit, int time) {
		this.unit = unit;
		this.time = time;
	}
}