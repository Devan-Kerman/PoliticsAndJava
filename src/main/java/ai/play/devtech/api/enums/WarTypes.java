package ai.play.devtech.api.enums;

/**
 * A list of all the ingame types of war
 *
 * @author devan
 */
public enum WarTypes {
	RAID, ATT, ORD;

	public static WarTypes getByString(String name) {
		String upp = name.toUpperCase();
		if (upp.startsWith("ATT")) return ATT;
		else if (upp.startsWith("ORD")) return ORD;
		else if (upp.startsWith("RAID")) return RAID;
		return ORD;
	}

}
