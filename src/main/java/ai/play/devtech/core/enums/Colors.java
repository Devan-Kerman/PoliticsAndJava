package ai.play.devtech.core.enums;

import org.beryx.awt.color.ColorFactory;
import java.awt.Color;

/**
 * Enum for each of the colors ingame
 *
 * @author devan
 */
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
