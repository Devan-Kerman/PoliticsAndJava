package ai.play.devtech.core.api;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is not thread-safe, as you should only be using this occassionally, and definetly not multithreadedly
 * The {@link APIAggregator} is thread-safe on the other hand
 * @author devan
 *
 */
public class APIAggregatorBuilder {
	
	protected Map<String, Object> data;
	public APIAggregatorBuilder() {
		data = new HashMap<>();
		data.put("key", "none");
		data.put("time", new Period(ChronoUnit.HOURS, 1));
		data.put("size", 50);
	}

	/**
	 * Sets the API key for this Aggregator
	 * @param key
	 * 		Your Politics And War API Key
	 */
	public void setKey(String key) {
		data.put("key", key);
	}
	
	/**
	 * Defines how long until a set of information is deemed "out-dated"
	 * @param unit
	 * 		The unit (hours, seconds, minuets, etc.)
	 * @param amount
	 * 		The amount of units that need to be waited
	 */
	public void setTimeout(ChronoUnit unit, int amount) {
		data.put("time", new Period(unit, amount));
	}
	
	/**
	 * Sets the cache's size (in objects)
	 * @param objs
	 */
	public void setCacheSize(int objs) {
		data.put("size", objs);
	}
	
	public APIAggregator build() {
		APIAggregator agg = new APIAggregator();
		agg.cache = new APICache((int)data.get("size"), (Period)data.get("time"));
		agg.key = (String)data.get("key");
		return agg;
	}
	
}
