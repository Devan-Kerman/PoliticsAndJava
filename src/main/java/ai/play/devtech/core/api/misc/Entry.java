package ai.play.devtech.core.api.misc;

import java.time.Instant;

/**
 * An entry into a timed cache, contains the data, and the time of death
 *
 * @author devan
 */
public class Entry {
	public Object data;
	public Instant death;

	public Entry(Object data, Instant death) {
		this.data = data;
		this.death = death;
	}
}