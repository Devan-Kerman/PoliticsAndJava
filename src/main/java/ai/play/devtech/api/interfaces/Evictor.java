package ai.play.devtech.api.interfaces;

import java.util.Map;

/**
 * This interface is used to evict objects from a cache
 *
 * @author devan
 */
public interface Evictor {

	/**
	 * Accept or deny the new entry into the cache
	 *
	 * @param cache the cache
	 * @param entry the new entry
	 * @param result the retrieved value from the api
	 * @return whether or not you should insert this object into the cache
	 */
	public boolean newEntry(Map<String, Object> cache, String entry, Object result);

	/**
	 * Attempts to clear the cache of all invalidated values deemed unworthy by the evictor
	 *
	 * @param cache the cache
	 */
	public void attemptEviction(Map<String, Object> cache);

	/**
	 * This is called when the cache is called for an object, this is purely for resetting priorities etc.
	 *
	 * @param cache the cache
	 * @param request the requested object
	 * @return accept or deny the request
	 */
	public boolean newRequest(Map<String, Object> cache, String request);


	/**
	 * This is called each time the cache is called
	 *
	 * @param cache the cache
	 */
	public void refresh(Map<String, Object> cache);

}
