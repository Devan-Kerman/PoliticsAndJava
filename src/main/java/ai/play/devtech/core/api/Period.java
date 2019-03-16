package ai.play.devtech.core.api;

import java.time.temporal.ChronoUnit;

public class Period {
	public ChronoUnit unit;
	public int time;
	public Period(ChronoUnit unit, int time) {
		this.unit = unit;
		this.time = time;
	}
}