package ai.play.devtech.core.api.objects;

import java.util.Date;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Continents;
import ai.play.devtech.core.objects.JSONName;

public class City extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "cityid")
	public int id;
	
	@JSONName(name = "url")
	public String url;
	
	@JSONName(name = "nationid")
	public String nationid;
	
	@JSONName(name = "name")
	public String name;
	
	@JSONName(name = "nation")
	public String nation;
	
	@JSONName(name = "leader")
	public String leader;
	
	@JSONName(name = "continent")
	public Continents continent;
	
	@JSONName(name = "founded")
	public Date founded;
	
	@JSONName(name = "age")
	public int age;
	
	@JSONName(name = "powered")
	public boolean powered;
	
	@JSONName(name = "infrastructure")
	public float infra;
	
	@JSONName(name = "land")
	public float land;
	
	@JSONName(name = "population")
	public double pop;
	
	@JSONName(name = "popdensity")
	public float density;
	
	@JSONName(name = "crime")
	public float crime;
	
	@JSONName(name = "disease")
	public float disease;
	
	@JSONName(name = "commerce")
	public float commerce;
	
	@JSONName(name = "avgincome")
	public float avgincome;
	
	@JSONName(name = "pollution")
	public float pollution;
	
	@JSONName(name = "nuclearpollution")
	public float radiation;
	
	@JSONName(name = "basepop")
	public float basepop;
	
	@JSONName(name = "basepopdensity")
	public float basedense;
	
	@JSONName(name = "minimumwage")
	public float minwage;
	
	@JSONName(name = "poplostdisease")
	public float deathdisease;
	
	@JSONName(name = "poplostcrime")
	public float deathcrime;
	
	@JSONName(name = "imp_coalpower")
	public byte coalpowers;
	
	@JSONName(name = "imp_oilpower")
	public byte oilpowers;
	
	@JSONName(name = "imp_nuclearpower")
	public byte nukepowers;
	
	@JSONName(name = "imp_windpower")
	public byte windpowers;
	
	@JSONName(name = "imp_coalmine")
	public byte coalmines;
	
	@JSONName(name = "imp_oilwell")
	public byte oilwells;
	
	@JSONName(name = "imp_ironmine")
	public byte ironmines;
	
	@JSONName(name = "imp_bauxitemine")
	public byte bauxmines;
	
	@JSONName(name = "imp_leadmine")
	public byte leadmines;
	
	@JSONName(name = "imp_uramine")
	public byte uranmines;
	
	@JSONName(name = "imp_farm")
	public byte farms;
	
	@JSONName(name = "imp_gasrefinery")
	public byte gasorefines;
	
	@JSONName(name = "imp_steelmill")
	public byte steelmills;
	
	@JSONName(name = "imp_aluminumrefinery")
	public byte alumrefines;
	
	@JSONName(name = "imp_munitionsfactory")
	public byte munitrefines;
	
	@JSONName(name = "imp_policestation")
	public byte police;
	
	@JSONName(name = "imp_hospital")
	public byte hospitals;
	
	@JSONName(name = "imp_recyclingcenter")
	public byte recyclers;
	
	@JSONName(name = "imp_subway")
	public byte subways;
	
	@JSONName(name = "imp_supermarket")
	public byte supermarkets;
	
	@JSONName(name = "imp_bank")
	public byte banks;
	
	@JSONName(name = "imp_mall")
	public byte malls;
	
	@JSONName(name = "imp_stadium")
	public byte stadiums;
	
	@JSONName(name = "imp_barracks")
	public byte barracks;
	
	@JSONName(name = "imp_factory")
	public byte factories;
	
	@JSONName(name = "imp_hangar")
	public byte hangars;
	
	@JSONName(name = "imp_drydock")
	public byte drydocks;

}
