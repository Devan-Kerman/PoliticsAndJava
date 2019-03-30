package ai.play.devtech.api.caches;

import java.util.Map;
import java.util.function.Function;

/**
 * An api object provider
 *
 * @author devan
 */
public interface APICache {
	/**
	 * @param url the URL
	 * @param type the desired type
	 * @param processor a pre-processor, to edit the psudo object before it's compiled into an object
	 * @return the compiled/retrieved object
	 */
	public <T> T get(String url, Class<T> type, Function<Map<String, Object>, Map<String, Object>> processor);
}
