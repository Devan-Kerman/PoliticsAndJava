package ai.play.devtech.api;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ai.play.devtech.APIObject;
import ai.play.devtech.api.caches.SimpleAPICache;
import ai.play.devtech.api.enums.Resource;
import ai.play.devtech.api.enums.Urls;
import ai.play.devtech.api.interfaces.APICache;
import ai.play.devtech.api.objects.Alliance;
import ai.play.devtech.api.objects.AllianceExcerpt;
import ai.play.devtech.api.objects.AllianceMember;
import ai.play.devtech.api.objects.City;
import ai.play.devtech.api.objects.CityExcerpt;
import ai.play.devtech.api.objects.Nation;
import ai.play.devtech.api.objects.NationExcerpt;
import ai.play.devtech.api.objects.NationMilitary;
import ai.play.devtech.api.objects.TradeHistory;
import ai.play.devtech.api.objects.War;
import ai.play.devtech.api.objects.WarAttack;
import ai.play.devtech.api.objects.WarExcerpt;
import ai.play.devtech.api.objects.tradeprice.TradePrice;
import ai.play.devtech.api.queries.NationsQuery;
import ai.play.devtech.core.errors.UnsuccessfullAPIException;

/**
 * An object that is used to interface with the API
 *
 * @author devan
 */
public class APIAggregator {

	protected APICache cache;
	protected String key = "nokey";
	public static final String BASE = "https://politicsandwar.com/api/%s/%s&key=%s";

	/**
	 * Creates a new APIAggregator using the given key and api cache
	 *
	 * @param key
	 * @param cache
	 */
	public APIAggregator(String key, APICache cache) {
		this.cache = cache;
		this.key = key;
	}

	/**
	 * Creates a new APIAggregator using a simple api cache
	 *
	 * @param key an API key
	 * @param unit unit of time
	 * @param time amount of that time
	 * @param initialsize initial size
	 */
	public APIAggregator(String key, TemporalUnit unit, int time, int initialsize) {
		this(key, new SimpleAPICache(unit, time, initialsize));
	}

	/**
	 * {@link APIAggregator#APIAggregator(String, TemporalUnit, int, int)} But with
	 * 1 hour and 50 as inital size
	 *
	 * @param key
	 */
	public APIAggregator(String key) {
		this(key, ChronoUnit.HOURS, 1, 50);
	}

	/**
	 * {@link APIAggregator#APIAggregator(String, TemporalUnit, int, int)} but with
	 * 1 hour default
	 *
	 * @param key key
	 * @param initialsize initial size of cache
	 */
	public APIAggregator(String key, int initialsize) {
		this(key, ChronoUnit.HOURS, 1, initialsize);
	}

	/**
	 * {@link APIAggregator#APIAggregator(String, TemporalUnit, int, int)}
	 * but with default 50 initial capacity
	 *
	 * @param key
	 * @param unit
	 * @param time
	 */
	public APIAggregator(String key, TemporalUnit unit, int time) {
		this(key, unit, time, 50);
	}

	public WarAttack[] getAttacks(int warid) {
		return getArray(Urls.WAR_ATTACKS_ID.format(key, warid), "war_attacks", WarAttack[].class);
	}
	
	public WarAttack[] getAttacksMin(int minid) {
		return getArray(Urls.WAR_ATTACKS_MIN.format(key, minid), "war_attacks", WarAttack[].class);
	}
	
	public WarAttack[] getAttacksMax(int maxid) {
		return getArray(Urls.WAR_ATTACKS_MIN.format(key, maxid), "war_attacks", WarAttack[].class);
	}
	
	public WarAttack[] getAttacksRange(int maxid, int minid) {
		return getArray(Urls.WAR_ATTACKS_RANGE.format(key, maxid, minid), "war_attacks", WarAttack[].class);
	}
	
	public WarExcerpt[] getMaxAAWars(int num, int...alliances) {
		return getArray(Urls.WARS_AA_LIMIT.format(num, key, String.join(",",Arrays.stream(alliances).mapToObj(Integer::toString).collect(Collectors.toList()))), "wars", WarExcerpt[].class);
	}
	
	public WarExcerpt[] getAAWars(int...alliances) {
		return getArray(Urls.WARS_AA.format(String.join(",",Arrays.stream(alliances).mapToObj(Integer::toString).collect(Collectors.toList())), key), "wars", WarExcerpt[].class);
	}
	
	public WarExcerpt[] getMaxWars(int num) {
		return getArray(Urls.WARS_LIMIT.format(num, key), "wars", WarExcerpt[].class);
	}

	public WarExcerpt[] getWars() {
		return getArray(Urls.WARS.format(key), "wars", WarExcerpt[].class);
	}

	public War getWar(long id) {
		return getObj(Urls.WAR.format(id), War.class);
	}

	public TradePrice getPrice(Resource r) {
		return getObj(Urls.TRADE_PRICE.format(r.name().toLowerCase(), key), TradePrice.class);
	}
	
	public TradeHistory[] getTradeHistory() {
		return getArray(Urls.TRADE_HISTORY.format(key), "trades", TradeHistory[].class);
	}
	
	public TradeHistory[] getTradeHistory(int trades) {
		return getArray(Urls.TRADE_HISTORY_RECORDS.format(key, trades), "trades", TradeHistory[].class);
	}
	
	public TradeHistory[] getTradeHistory(int trades, Resource...resources) {
		return getArray(Urls.TRADE_HISTORY_RESOURCES_AND_RECORDS.format(key, trades, String.join(",", resources)), "trades", TradeHistory[].class);
	}
	
	public TradeHistory[] getTradeHistory(Resource...resources) {
		return getArray(Urls.TRADE_HISTORY_RESOURCES.format(key, String.join(",", resources)), "trades", TradeHistory[].class);
	}

	public NationExcerpt[] getNations(NationsQuery query) {
		List<String> build = query.build();
		if(build.isEmpty())
			return getArray(Urls.NATIONS.format(key), "nations", NationExcerpt[].class);
		return getArray(Urls.NATIONS.format(key)+'&'+String.join("&", query.build()), "nations", NationExcerpt[].class);
	}

	public NationExcerpt[] getNations() {
		return getNations(new NationsQuery());
	}

	public NationExcerpt[] getAllNations() {
		return getNations(new NationsQuery().includeVM(true));
	}

	public AllianceMember[] getMembers(int id) {
		return getArray(Urls.ALLIANCE_MEMBERS.format(key, id), "nations", AllianceMember[].class);
	}

	public Alliance getAlliance(int id) {
		return getObj(Urls.ALLIANCE.format(key, id), Alliance.class);
	}

	public CityExcerpt[] getCities() {
		return getArray(Urls.ALL_CITIES.format(key), "all_cities", CityExcerpt[].class);
	}

	public AllianceExcerpt[] getAlliances() {
		return getArray(Urls.ALLIANCES.format(key), "alliances", AllianceExcerpt[].class);
	}

	public City getCity(int id) {
		return getObj(Urls.CITY.format(key, id), City.class);
	}

	public Nation getNation(int id) {
		return getObj(Urls.NATION.format(key, id), Nation.class);
	}

	public NationMilitary[] getMilitaries() {
		return getArray(Urls.NATION_MILITARY.format(key), "nation_militaries", NationMilitary[].class);
	}

	public TradePrice getCoal() {
		return getObj(Urls.TRADE_PRICE.format(key, "coal"), TradePrice.class);
	}

	public TradePrice getOil() {
		return getObj(Urls.TRADE_PRICE.format(key, "oil"), TradePrice.class);
	}

	public TradePrice getIron() {
		return getObj(Urls.TRADE_PRICE.format(key, "iron"), TradePrice.class);
	}

	public TradePrice getUranium() {
		return getObj(Urls.TRADE_PRICE.format(key, "uranium"), TradePrice.class);
	}

	public TradePrice getBauxite() {
		return getObj(Urls.TRADE_PRICE.format(key, "bauxite"), TradePrice.class);
	}

	public TradePrice getLead() {
		return getObj(Urls.TRADE_PRICE.format(key, "lead"), TradePrice.class);
	}

	public TradePrice getGasoline() {
		return getObj(Urls.TRADE_PRICE.format(key, "gasoline"), TradePrice.class);
	}

	public TradePrice getMunitions() {
		return getObj(Urls.TRADE_PRICE.format(key, "munitions"), TradePrice.class);
	}

	public TradePrice getSteel() {
		return getObj(Urls.TRADE_PRICE.format(key, "steel"), TradePrice.class);
	}

	public TradePrice getAluminum() {
		return getObj(Urls.TRADE_PRICE.format(key, "aluminum"), TradePrice.class);
	}

	public TradePrice getCredits() {
		return getObj(Urls.TRADE_PRICE.format(key, "credits"), TradePrice.class);
	}

	/*
	 * public Bank getBank(int aaid) { return getObj("alliance-bank",
	 * "?allianceid="+aaid+"&key="+key); }
	 */

	/**
	 * Gets an object from the api (if the object is returned as a singleton or a
	 * regular object)
	 *
	 * @param cat the catagory AKA what goes after /api/ but before the
	 * /parameters=here
	 * @param extend the parameters, AKA what goes after api/cat/
	 * @param clas the desired type
	 * @return the (hopefulyl correct type)
	 */
	protected <T extends APIObject> T[] getArray(String url, String id, Class<T[]> clas) {
		System.out.printf("New URL request: %s\n", url);
		return cache.<T[]>get(url, clas, m -> {
			Object o = m.remove("success");
			if (o == null || !(Boolean) o) throw new UnsuccessfullAPIException("URL: " + url + " returned \n");
			Map<String, Object> map = new HashMap<>();
			map.put("array", map.get(id));
			return map;
		});
	}

	/**
	 * Gets an object from the api (if the object is returned as a singleton or a
	 * regular object)
	 *
	 * @param cat the catagory AKA what goes after /api/ but before the
	 * /parameters=here
	 * @param extend the parameters, AKA what goes after api/cat/
	 * @param clas the desired type
	 * @return the (hopefulyl correct type)
	 */
	protected <T extends APIObject> T getObj(String url, Class<T> clas) {
		return cache.get(url, clas, m -> {
			Object o = m.remove("success");
			if (o == null || !(Boolean) o) throw new UnsuccessfullAPIException("URL: " + url + " returned \n");
			return m;
		});
	}
}
