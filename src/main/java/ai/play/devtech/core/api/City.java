package ai.play.devtech.core.api;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.Continents;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.util.Date;

/**
 * A class representing an ingame city
 *
 * @author devan
 */
public class City extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * City's id
	 */
	@DataName (name = "cityid")
	public int cityid;

	/**
	 * The url to open that city... Alex wtf, we can make that ourselves
	 */
	@DataName (name = "url")
	public String url;

	/**
	 * The id of the nation that this city is owned by
	 */
	@DataName (name = "nationid")
	public int nationid;

	/**
	 * The city's name
	 */
	@DataName (name = "name")
	public String name;

	/**
	 * The name of the nation that owns this city
	 */
	@DataName (name = "nation")
	public String nation;

	/**
	 * The name of the leader of the nation that owns this city
	 */
	@DataName (name = "leader")
	public String leader;

	/**
	 * The continent on which this city lies (owner nations continent)
	 */
	@DataName (name = "continent")
	public Continents continent;

	/**
	 * The date when this city was made
	 */
	@DataName (name = "founded")
	public Date founded;

	/**
	 * The age in days* this city has existed
	 * 
	 * *not sure
	 */
	@DataName (name = "age")
	public int age;

	/**
	 * If the city is powered or not
	 */
	@DataName (name = "powered")
	public boolean powered;

	/**
	 * How much infrastructure this city has
	 */
	@DataName (name = "infrastructure")
	public float infra;

	/**
	 * The amount of land this city has
	 */
	@DataName (name = "land")
	public float land;

	/**
	 * The cities total population
	 */
	@DataName (name = "population")
	public double pop;

	/**
	 * The population density of the city
	 */
	@DataName (name = "popdensity")
	public float density;

	/**
	 * The crime rate in the city
	 */
	@DataName (name = "crime")
	public float crime;

	/**
	 * The desease in the city (percent of people that die per turn due to desease iirc)
	 */
	@DataName (name = "disease")
	public float disease;

	/**
	 * The cities commerce percentage
	 */
	@DataName (name = "commerce")
	public float commerce;

	/**
	 * Average joe's income in that city
	 */
	@DataName (name = "avgincome")
	public float avgincome;

	/**
	 * Polution level in the city
	 */
	@DataName (name = "pollution")
	public float pollution;

	/**
	 * Polution level in the city caused by nuclear radiation
	 */
	@DataName (name = "nuclearpollution")
	public float radiation;

	/**
	 * The minimum amount of people that can live there
	 */
	@DataName (name = "basepop")
	public float basepop;

	/**
	 * Min amout of population density
	 */
	@DataName (name = "basepopdensity")
	public float basedense;
	
	/**
	 * Minimum wage
	 */
	@DataName (name = "minimumwage")
	public float minwage;

	/**
	 * The amount of people that die to desease each turn
	 */
	@DataName (name = "poplostdisease")
	public float deathdisease;

	/**
	 * The amount of people that die to crime
	 */
	@DataName (name = "poplostcrime")
	public float deathcrime;

	/**
	 * The amount of coal power plants in the city
	 */
	@DataName (name = "imp_coalpower")
	public byte coalpowers;

	/**
	 * The amount of coal power plants in the city
	 */
	@DataName (name = "imp_oilpower")
	public byte oilpowers;

	/**
	 * The amount of coal power plants in the city
	 */
	@DataName (name = "imp_nuclearpower")
	public byte nukepowers;

	/**
	 * The amount of coal power plants in the city
	 */
	@DataName (name = "imp_windpower")
	public byte windpowers;

	/**
	 * The amount of coal mines in the city
	 */
	@DataName (name = "imp_coalmine")
	public byte coalmines;

	/**
	 * The amount of oil wells in the city
	 */
	@DataName (name = "imp_oilwell")
	public byte oilwells;

	/**
	 * The amount of iron mines in the city
	 */
	@DataName (name = "imp_ironmine")
	public byte ironmines;

	/**
	 * The amount of coal power plants in the city
	 */
	@DataName (name = "imp_bauxitemine")
	public byte bauxmines;

	/**
	 * The amount of lead mines in the city
	 */
	@DataName (name = "imp_leadmine")
	public byte leadmines;

	/**
	 * The amount of uranium mines in the city
	 */
	@DataName (name = "imp_uramine")
	public byte uranmines;

	/**
	 * The amount of farms in the city
	 */
	@DataName (name = "imp_farm")
	public byte farms;

	/**
	 * The amount of gasoline refineries in the city
	 */
	@DataName (name = "imp_gasrefinery")
	public byte gasorefines;

	/**
	 * The amount of steel mills in the city
	 */
	@DataName (name = "imp_steelmill")
	public byte steelmills;

	/**
	 * The amount of aluminum refineries in the city
	 */
	@DataName (name = "imp_aluminumrefinery")
	public byte alumrefines;

	/**
	 * The amount of munitions factories in the city
	 */
	@DataName (name = "imp_munitionsfactory")
	public byte munitrefines;
	/**
	 * The amount of police stations in the city
	 */
	@DataName (name = "imp_policestation")
	public byte police;
	/**
	 * The amount of hospitals in the city
	 */
	@DataName (name = "imp_hospital")
	public byte hospitals;
	/**
	 * The amount of recycling centers in the city
	 */
	@DataName (name = "imp_recyclingcenter")
	public byte recyclers;
	/**
	 * The amount of subways in the city
	 */
	@DataName (name = "imp_subway")
	public byte subways;
	/**
	 * The amount of super markets in the city
	 */
	@DataName (name = "imp_supermarket")
	public byte supermarkets;
	/**
	 * The amount of banks in the city
	 */
	@DataName (name = "imp_bank")
	public byte banks;
	/**
	 * The amount of malls in the city
	 */
	@DataName (name = "imp_mall")
	public byte malls;
	/**
	 * The amount of stadiums in the city
	 */
	@DataName (name = "imp_stadium")
	public byte stadiums;
	/**
	 * The amount of barracks in the city
	 */
	@DataName (name = "imp_barracks")
	public byte barracks;
	/**
	 * The amount of factories in the city
	 */
	@DataName (name = "imp_factory")
	public byte factories;
	/**
	 * The amount of hangars in the city
	 */
	@DataName (name = "imp_hangar")
	public byte hangars;
	/**
	 * The amount of drydocks in the city
	 */
	@DataName (name = "imp_drydock")
	public byte drydocks;
	@Override
	public long getID() {
		return cityid;
	}

}
