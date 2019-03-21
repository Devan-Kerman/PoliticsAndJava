package ai.play.devtech.api.enums;

public enum Urls {
	BASE("http://politicsandwar.com/api/"), 
	NATION(BASE.getFormat() + "nation/id=%d&key=%s"),
	NATIONS(BASE.getFormat() + "nations/?key=%s"), 
	ALLIANCE(BASE.getFormat() + "alliance/id=%d&key=%s"),
	ALLIANCES(BASE.getFormat() + "alliances/?key=%s"), 
	WAR(BASE.getFormat() + "war/%d&key=%s"),
	WARS(BASE.getFormat() + "wars/?key=%s"),
	WARS_LIMIT(BASE.getFormat() + "wars/%d&key=%s"),
	WARS_AA(BASE.getFormat() + "wars/?alliance_id=%s&key=%s"),
	WARS_AA_LIMIT(BASE.getFormat() + "wars/%d&key=%s&alliance_id=%s"),
	BANK(BASE.getFormat() + "alliance-bank/?allianceid=%d&key=%s"),
	ALLIANCE_MEMBERS(BASE.getFormat() + "alliance-members/?allianceid=%d&key=%s"),
	APPLICANTS(BASE.getFormat() + "applicants/%d/?key=%s"), 
	ALL_CITIES(BASE.getFormat() + "all-cities/key=%s"),
	NATION_MILITARY(BASE.getFormat() + "nation-military/key=%s"), 
	CITY(BASE.getFormat() + "city/id=%d&key=%s"),
	TRADE_HISTORY(BASE.getFormat() + "trade-history/key=%s"),
	TRADE_HISTORY_RECORDS(BASE.getFormat() + "trade-history/key=%s&records=%d"),
	TRADE_HISTORY_RESOURCES(BASE.getFormat() + "trade-history/key=%s&resources=%s"),
	TRADE_HISTORY_RESOURCES_AND_RECORDS(BASE.getFormat() + "trade-history/key=%s&records=%d&resources=%s"),
	TRADE_PRICE(BASE.getFormat() + "tradeprice/resource=%s&key=%s"),
	WAR_ATTACKS_ID(BASE.getFormat() + "war-attacks/key=%s&war_id=%d"),
	WAR_ATTACKS_MIN(BASE.getFormat() + "war-attacks/key=%s&min_war_id=%d"),
	WAR_ATTACKS_MAX(BASE.getFormat() + "war-attacks/key=%s&max_war_id=%d"),
	WAR_ATTACKS_RANGE(BASE.getFormat() + "war-attacks/key=%s&max_war_id=%d&min_war_id=%d");
	
	
	String format;

	Urls(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}

	public String format(Object... args) {
		return String.format(format, args);
	}
}
