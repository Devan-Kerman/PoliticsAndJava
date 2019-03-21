package ai.play.devtech.api.enums;

/**
 * Ingame resources
 *
 * @author devan
 */
public enum Resource implements CharSequence {
	COAL, OIL, URANIUM, IRON, BAUXITE, LEAD, GASOLINE, MUNITIONS, STEEL, ALUMINUM, CREDITS;

	/**
	 * Gets the enum based on the first 2 letters
	 *
	 * @param thing
	 * @return the enum, or coal if all else fails
	 */
	public static Resource getUsingStart(char a, char b) {
		char upa = Character.toUpperCase(a);
		char upb = Character.toUpperCase(b);
		for (Resource r : values()) {
			String strn = r.name();
			if (strn.charAt(0) == upa && strn.charAt(1) == upb) return r;
		}
		return COAL;
	}

	@Override
	public int length() {
		return name().length();
	}

	@Override
	public char charAt(int index) {
		return name().charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return name().subSequence(start, end);
	}
}

