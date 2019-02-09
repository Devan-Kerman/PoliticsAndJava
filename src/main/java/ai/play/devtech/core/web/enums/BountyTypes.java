package main.java.ai.play.devtech.core.web.enums;


public enum BountyTypes {
	ORDINARY, ATTRITION, RAID, NUCLEAR;
	public static BountyTypes getByString(String name) {
		String upp = name.toUpperCase();
		if(upp.startsWith("ATT"))
			return ATTRITION;
		else if(upp.startsWith("ORD"))
			return ORDINARY;
		else if(upp.startsWith("RAI"))
			return RAID;
		else if(upp.startsWith("NUC"))
			return NUCLEAR;
		return ORDINARY;
	}
}
