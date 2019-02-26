package ai.play.devtech.core.api.enums;

public enum Resource {
	COAL, OIL, URANIUM, IRON, BAUXITE, LEAD, GASOLINE, MUNITIONS, STEEL, ALUMINUM, CREDITS;
	
	/**
	 * Gets the enum based on the first 2 letters
	 * @param thing
	 * @return
	 */
	public static Resource getUsingStart(char a, char b) {
		char upa = Character.toUpperCase(a);
		char upb = Character.toUpperCase(b);
		for(Resource r : values()) {
			String strn = r.name();
			if(strn.charAt(0) == upa && strn.charAt(1) == upb)
				return r;
		}
		return COAL;
	}
}

