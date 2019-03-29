package ai.play.devtech.core.web;

import java.io.Serializable;

import ai.play.devtech.core.enums.Colors;

/**
 * The value of a color
 *
 * @author devan
 */
public class ColorVal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
