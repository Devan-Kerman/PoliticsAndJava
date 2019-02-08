package ai.play.devtech.core.api;

import java.util.Arrays;
import java.util.Map;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Resource;
import ai.play.devtech.core.api.objects.*;
import ai.play.devtech.core.api.objects.tradeprice.TradePrice;
import ai.play.devtech.core.api.queries.NationsQuery;
import ai.play.devtech.core.api.queries.TradeHistoryQuery;
import ai.play.devtech.core.api.queries.WarAttacksQuery;
import ai.play.devtech.core.errors.UnsuccessfullAPIException;
import ai.play.devtech.core.objects.ObjectBuilder;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class APIAggregator {

	protected APICache cache;
	protected String key = "nokey";
	public static final String BASE = "https://politicsandwar.com/api/%s/%s";

	/**
	 * Use {@link APIAggregatorBuilder}
	 */
	APIAggregator() {
	}

	public WarAttack[] getAttacks(WarAttacksQuery query) {
		return getArray("war-attacks", query.build(key), "war_attacks", WarAttack[].class);
	}
	
	public WarExcerpt[] getWars(int numofwars, int...alliances) {
		String strn = Arrays.toString(alliances);
		return getArray("wars", (alliances==null || alliances.length == 0)? "wars/"+numofwars : String.format("wars/%d?allianceid=%s", numofwars, strn.substring(0, strn.length()-1)), "wars", WarExcerpt[].class);
	}
	
	public War getWar(int id) {
		return getObj("war", String.valueOf(id), War.class);
	}
	
	public TradePrice getPrice(Resource r) {
		return getObj("tradeprice", "resource="+r.name().toLowerCase(), TradePrice.class);
	}
	
	public TradeHistory[] getTradeHistory(TradeHistoryQuery query) {
		return getArray("trade-history", query.build(key), "trades", TradeHistory[].class);
	}
	
	public NationExcerpt[] getNations(NationsQuery query) {
		return getArray("nations", query.build(), "nations", NationExcerpt[].class);
	}
	public AllianceMember[] getMembers(int id) {
		return getArray("alliance-members", "?allianceid="+id+"&key="+key, "nations", AllianceMember[].class);
	}
	
	public Alliance getAlliance(int id) {
		return getObj("alliance", "id=" + id, Alliance.class);
	}

	public CityExcerpt[] getCities() {
		return getArray("all-cities", "key=" + key, "all_cities", CityExcerpt[].class);
	}
	
	public Alliance[] getAlliances() {
		return getArray("alliances", "", "alliances", Alliance[].class);
	}

	public City getCity(int id) {
		return getObj("city", "id="+id, City.class);
	}
	
	public Nation getNation(int id) {
		return getObj("nation", "id="+id, Nation.class);
	}
	
	public NationMilitary[] getMilitaries() {
		return getArray("nation-military", "key="+key, "nation_militaries", NationMilitary[].class);
	}
	/*public Bank getBank(int aaid) {
		return getObj("alliance-bank", "?allianceid="+aaid+"&key="+key);
	}*/
	
	/**
	 * Gets an object from the api (if the object is returned as a singleton or a regular object)
	 * @param cat
	 * 		the catagory AKA what goes after /api/ but before the /parameters=here
	 * @param extend
	 * 		the parameters, AKA what goes after api/cat/
	 * @param clas
	 * 		the desired type
	 * @return
	 * 		the (hopefulyl correct type)
	 */
	protected <T extends APIObject> T[] getArray(String cat, String extend, String id, Class<T[]> clas) {
		String url = String.format(BASE, cat, extend);
		Map<String, Object> map = cache.<Map>request(url, Map.class);
		Object o = map.get("success");
		if (o == null || !(Boolean) o)
			throw new UnsuccessfullAPIException("URL: " + url + " returned \n");
		ObjectBuilder<T[]> obj = new ObjectBuilder<>(clas);
		obj.add("array",map.get(id));
		return obj.build();
	}

	/**
	 * Gets an object from the api (if the object is returned as a singleton or a regular object)
	 * @param cat
	 * 		the catagory AKA what goes after /api/ but before the /parameters=here
	 * @param extend
	 * 		the parameters, AKA what goes after api/cat/
	 * @param clas
	 * 		the desired type
	 * @return
	 * 		the (hopefulyl correct type)
	 */
	protected <T extends APIObject> T getObj(String cat, String extend, Class<T> clas) {
		String url = String.format(BASE, cat, extend);
		Map<String, Object> map = cache.<Map>request(url, Map.class);
		Object o = map.remove("success");
		if (o != null && !(Boolean) o)
			throw new UnsuccessfullAPIException("URL: " + url + " returned \n");
		ObjectBuilder<T> obj = new ObjectBuilder<>(clas);
		obj.addAll(map);
		return obj.build();
	}

}
