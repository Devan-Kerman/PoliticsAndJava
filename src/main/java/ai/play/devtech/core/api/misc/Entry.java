package ai.play.devtech.core.api.misc;

import java.time.Instant;

public class Entry {
	public Object data;
	public Instant death;

	public Entry(Object data, Instant death) {
		this.data = data;
		this.death = death;
	}
}