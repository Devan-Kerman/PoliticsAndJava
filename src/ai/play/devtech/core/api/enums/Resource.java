package ai.play.devtech.core.api.enums;

public enum Resource {
	COAL, OIL, URANIUM, IRON, BAUXITE, LEAD, GASOLINE, MUNITIONS, STEEL, ALUMINUM, CREDITS;
	public static Resource getUsingStart(String thing) {
		String thng = thing.toUpperCase();
		for(Resource r : values()) {
			String strn = r.name();
			if(strn.charAt(0) == thng.charAt(0) && strn.charAt(1) == thng.charAt(1))
				return r;
		}
		return COAL;
	}
}

