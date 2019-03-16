package ai.play.devtech.core.api.enums;

import java.awt.Color;

import org.beryx.awt.color.ColorFactory;

public enum Colors {
	BEIGE, LIME, GREEN, PINK, BROWN, OLIVE, BLUE, RED, ORANGE, PURPLE, YELLOW, AQUA, WHITE, MAROON, BLACK, GRAY;

	
	private Colors() {
		color = ColorFactory.valueOf(name());
	}
	private Color color;
	public String lowerCaseName() {
		return this.name().toLowerCase();
	}
	
	public Color getColor() {
		return color;
	}
}
