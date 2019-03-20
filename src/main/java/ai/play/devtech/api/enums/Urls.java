package ai.play.devtech.api.enums;

public enum Urls {
  NATION("http://politicsandwar.com/api/nation/id=%d&key=%s"),
  NATIONS("https://politicsandwar.com/api/nations/?key=%s"),
  ALLIANCE("https://politicsandwar.com/api/alliance/id=%d&key=%s"),
  ALLIANCES("https://politicsandwar.com/api/alliances/?key=%s"),
  WAR("https://politicsandwar.com/api/war/%d&key=%s"),
  WARS("https://politicsandwar.com/api/wars/?key=%s"),
  BANK("http://politicsandwar.com/api/alliance-bank/?allianceid=%d&key=%s"),
  ALLIANCE_MEMBERS("http://politicsandwar.com/api/alliance-members/?allianceid=%d&key=%s"),
  APPLICANTS("http://politicsandwar.com/api/applicants/%d/?key=%s"),
  ALL_CITIES("https://politicsandwar.com/api/all-cities/key=%s"),
  NATION_MILITARY("https://politicsandwar.com/api/nation-military/key=%s"),
  CITY("http://politicsandwar.com/api/city/id=%d&key=%s"),
  TRADE_HISTORY("https://politicsandwar.com/api/trade-history/key=%s"),
  TRADE_PRICE("http://politicsandwar.com/api/tradeprice/resource=%s&key=%s");
  String format;
  Urls(String format) {
    this.format = format;
  }
  public String getFormat() {
    return format;
  }
}
