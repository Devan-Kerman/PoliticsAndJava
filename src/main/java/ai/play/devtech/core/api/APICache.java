package main.java.ai.play.devtech.core.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import com.google.gson.Gson;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.errors.InvalidAPIURLException;

public class APICache {

	protected Map<String, Entry> datamap;
	protected Period decay;
	protected static Gson gson = new Gson();
	
	protected Set<String> current = new ConcurrentSkipListSet<>();
	
	@SuppressWarnings("unchecked")
	protected <T> T request(String url, Class<T> cl) throws InvalidAPIURLException {
		while(true)
			if(!current.contains(url))
				break;
		current.add(url);
		Entry in = datamap.get(url);
		if(in != null)
			if(in.death.isAfter(Instant.now())) {
				current.remove(url);
				return (T) in.data;
			} else
				datamap.remove(url);
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			reader.lines().forEach(builder::append);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			current.remove(url);
			throw new InvalidAPIURLException(url+" is not responding or is malformed");
		}
		String ret = builder.toString();
		T t = gson.fromJson(ret, cl);
		Instant inception = Instant.now();
		Class<? extends Object> type = t.getClass();
		if(t instanceof APIObject)
			((APIObject) t).birth = inception;
		if(type != null && type.isArray() && APIObject.class.isAssignableFrom(type.getComponentType()))
			for(int x = 0; x < Array.getLength(t); x++)
				((APIObject)Array.get(t, x)).birth = inception;
		
		datamap.put(url, new Entry(t, inception.plus(decay.time, decay.unit)));
		current.remove(url);
		return t;
	}
	
	public APICache() {
		this(50, new Period(ChronoUnit.HOURS, 1));
	}
	
	public APICache(int size) {
		this(size, new Period(ChronoUnit.HOURS, 1));
	}
	
	public APICache(ChronoUnit time, int amount) {
		this(50, new Period(time, amount));
	}
	

	public APICache(int size, Period p) {
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