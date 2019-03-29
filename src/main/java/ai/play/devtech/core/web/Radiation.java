package ai.play.devtech.core.web;

import java.io.Serializable;

import ai.play.devtech.core.enums.Continents;

public class Radiation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The continent this object represents
	 */
	public final Continents continent;
	/**
	 * The current local radiation value
	 */
	public final float value;
	/**
	 * The food penalty
	 */
	public final float food;
	/**
	 * Global + local radiation
	 */
	public final float total;
	
	public Radiation(Continents continent, float value, float global) {
		this.continent = continent;
		this.value = value;
		this.total = value+global;
		this.food = total*-.1f;
	}
	
	@Override
	public String toString() {
		return String.format("%s %f %f", continent, value, food);
	}
}
