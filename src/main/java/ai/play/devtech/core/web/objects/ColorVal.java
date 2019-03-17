package ai.play.devtech.core.web.objects;

import ai.play.devtech.core.api.enums.Colors;

/**
 * The value of a color
 *
 * @author devan
 */
public class ColorVal {
	float bonus;
	Colors color;


	public ColorVal() {
		color = Colors.BEIGE;
		bonus = 0.0f;
	}

	public ColorVal(Colors color, float bonus) {
		this.color = color;
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString() + "\nBonus: " + bonus + "\nColor: " + color.lowerCaseName();
	}

	public static ColorVal getColorVal(Colors obj, ColorVal[] arr) {
		for (ColorVal cv : arr)
			if (cv.color == obj) return cv;
		return new ColorVal();
	}
}
