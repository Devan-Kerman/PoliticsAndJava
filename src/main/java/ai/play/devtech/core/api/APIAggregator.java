package ai.play.devtech.core.api;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.caches.SimpleAPICache;
import ai.play.devtech.core.api.enums.Resource;
import ai.play.devtech.core.api.interfaces.APICache;
import ai.play.devtech.core.api.objects.Alliance;
import ai.play.devtech.core.api.objects.AllianceExcerpt;
import ai.play.devtech.core.api.objects.AllianceMember;
import ai.play.devtech.core.api.objects.City;
import ai.play.devtech.core.api.objects.CityExcerpt;
import ai.play.devtech.core.api.objects.Nation;
import ai.play.devtech.core.api.objects.NationExcerpt;
import ai.play.devtech.core.api.objects.NationMilitary;
import ai.play.devtech.core.api.objects.TradeHistory;
import ai.play.devtech.core.api.objects.War;
import ai.play.devtech.core.api.objects.WarAttack;
import ai.play.devtech.core.api.objects.WarExcerpt;
import ai.play.devtech.core.api.objects.tradeprice.TradePrice;
import ai.play.devtech.core.api.queries.NationsQuery;
import ai.play.devtech.core.api.queries.TradeHistoryQuery;
import ai.play.devtech.core.api.queries.WarAttacksQuery;
import ai.play.devtech.core.errors.UnsuccessfullAPIException;

public class APIAggregator {

	protected APICache cache;
	protected String key = "nokey";
	public static final String BASE = "https://politicsandwar.com/api/%s/%s&key=%s";
	
	public APIAggregator(String key, APICache cache) {
		this.cache = cache;
		this.key = key;
	}

	/**
	 * you can use {@link APIAggregatorBuilder}
	 */
	public APIAggregator(String key, ChronoUnit unit, int time, int initialsize) {
		this(key, new SimpleAPICache(unit, time, initialsize));
	}
	
	/**
	 * you can use {@link APIAggregatorBuilder}
	 */
	public APIAggregator(String key) {
		this(key, ChronoUnit.HOURS, 1, 50);
	}
	
	/**
	 * you can use {@link APIAggregatorBuilder}
	 */
	public APIAggregator(String key, int initialsize) {
		this(key, ChronoUnit.HOURS, 1, initialsize);
	}
	
	/**
	 * you can use {@link APIAggregatorBuilder}
	 */
	public APIAggregator(String key, ChronoUnit unit, int time) {
		this(key, unit, time, 50);
	}

	public WarAttack[] getAttacks(WarAttacksQuery query) {
		return getArray("war-attacks", query.build(key), "war_attacks", WarAttack[].class);
	}

	public WarExcerpt[] getWars(int numofwars, int... alliances) {
		String strn = Arrays.toString(alliances);
		return getArray("wars",
				(alliances == null || alliances.length == 0) ? "wars/" + numofwars
						: String.format("wars/%d?allianceid=%s", numofwars, strn.substring(0, strn.length() - 1)),
				"wars", WarExcerpt[].class);
	}

	public WarExcerpt[] getWars() {
		return getArray("wars", "", "wars", WarExcerpt[].class);
	}

	public War getWar(long id) {
		return getObj("war", String.valueOf(id), War.class);
	}

	public TradePrice getPrice(Resource r) {
		return getObj("tradeprice", "resource=" + r.name().toLowerCase(), TradePrice.class);
	}

	public TradeHistory[] getTradeHistory(TradeHistoryQuery query) {
		return getArray("trade-history", query.build(), "trades", TradeHistory[].class);
	}

	public NationExcerpt[] getNations(NationsQuery query) {
		return getArray("nations", query.build(), "nations", NationExcerpt[].class);
	}

	public NationExcerpt[] getNations() {
		return getArray("nations", "", "nations", NationExcerpt[].class);
	}

	public NationExcerpt[] getAllNations() {
		return getArray("nations", new NationsQuery().includeVM(true).build(), "nations", NationExcerpt[].class);
	}

	public AllianceMember[] getMembers(int id) {
		return getArray("alliance-members", "?allianceid=" + id, "nations", AllianceMember[].class);
	}

	public Alliance getAlliance(int id) {
		return getObj("alliance", "id=" + id, Alliance.class);
	}

	public CityExcerpt[] getCities() {
		return getArray("all-cities", "", "all_cities", CityExcerpt[].class);
	}

	public AllianceExcerpt[] getAlliances() {
		return getArray("alliances", "", "alliances", AllianceExcerpt[].class);
	}

	public City getCity(int id) {
		return getObj("city", "id=" + id, City.class);
	}

	public Nation getNation(int id) {
		return getObj("nation", "id=" + id, Nation.class);
	}

	public NationMilitary[] getMilitaries() {
		return getArray("nation-military", "", "nation_militaries", NationMilitary[].class);
	}
	
	public TradePrice getCoal() {
		return getObj("tradeprice", "resource=coal", TradePrice.class);
	}

	public TradePrice getOil() {
		return getObj("tradeprice", "resource=oil", TradePrice.class);
	}

	public TradePrice getIron() {
		return getObj("tradeprice", "resource=iron", TradePrice.class);
	}

	public TradePrice getUranium() {
		return getObj("tradeprice", "resource=uranium", TradePrice.class);
	}

	public TradePrice getBauxite() {
		return getObj("tradeprice", "resource=bauxite", TradePrice.class);
	}

	public TradePrice getLead() {
		return getObj("tradeprice", "resource=lead", TradePrice.class);
	}

	public TradePrice getGasoline() {
		return getObj("tradeprice", "resource=gasoline", TradePrice.class);
	}

	public TradePrice getMunitions() {
		return getObj("tradeprice", "resource=munitions", TradePrice.class);
	}

	public TradePrice getSteel() {
		return getObj("tradeprice", "resource=steel", TradePrice.class);
	}

	public TradePrice getAluminum() {
		return getObj("tradeprice", "resource=aluminum", TradePrice.class);
	}

	public TradePrice getCredits() {
		return getObj("tradeprice", "resource=credits", TradePrice.class);
	}
	
	/*
	 * public Bank getBank(int aaid) { return getObj("alliance-bank",
	 * "?allianceid="+aaid+"&key="+key); }
	 */

	/**
	 * Gets an object from the api (if the object is returned as a singleton or a
	 * regular object)
	 * 
	 * @param cat    the catagory AKA what goes after /api/ but before the
	 *               /parameters=here
	 * @param extend the parameters, AKA what goes after api/cat/
	 * @param clas   the desired type
	 * @return the (hopefulyl correct type)
	 */
	protected <T extends APIObject> T[] getArray(String cat, String extend, String id, Class<T[]> clas) {
		String url = String.format(BASE, cat, extend, key);
		System.out.printf("New URL request: %s\n", url);
		return cache.<T[]>get(url, clas, m -> {
			Object o = m.remove("success");
			if (o == null || !(Boolean) o)
				throw new UnsuccessfullAPIException("URL: " + url + " returned \n");
			Map<String, Object> map = new HashMap<>();
			map.put("array", map.get(id));
			return map;
		});
	}

	/**
	 * Gets an object from the api (if the object is returned as a singleton or a
	 * regular object)
	 * 
	 * @param cat    the catagory AKA what goes after /api/ but before the
	 *               /parameters=here
	 * @param extend the parameters, AKA what goes after api/cat/
	 * @param clas   the desired type
	 * @return the (hopefulyl correct type)
	 */
	protected <T extends APIObject> T getObj(String cat, String extend, Class<T> clas) {
		String url = String.format(BASE, cat, extend, key);
		return cache.get(url, clas, m -> {
			Object o = m.remove("success");
			if (o == null || !(Boolean) o)
				throw new UnsuccessfullAPIException("URL: " + url + " returned \n");
			return m;
		});
	}

}
