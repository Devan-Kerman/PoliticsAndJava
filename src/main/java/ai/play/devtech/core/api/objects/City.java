package ai.play.devtech.core.api.objects;

import java.util.Date;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Continents;
import ai.play.devtech.core.objects.manipulation.DataName;

public class City extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName(name = "cityid")
	public int id;
	
	@DataName(name = "url")
	public String url;
	
	@DataName(name = "nationid")
	public String nationid;
	
	@DataName(name = "name")
	public String name;
	
	@DataName(name = "nation")
	public String nation;
	
	@DataName(name = "leader")
	public String leader;
	
	@DataName(name = "continent")
	public Continents continent;
	
	@DataName(name = "founded")
	public Date founded;
	
	@DataName(name = "age")
	public int age;
	
	@DataName(name = "powered")
	public boolean powered;
	
	@DataName(name = "infrastructure")
	public float infra;
	
	@DataName(name = "land")
	public float land;
	
	@DataName(name = "population")
	public double pop;
	
	@DataName(name = "popdensity")
	public float density;
	
	@DataName(name = "crime")
	public float crime;
	
	@DataName(name = "disease")
	public float disease;
	
	@DataName(name = "commerce")
	public float commerce;
	
	@DataName(name = "avgincome")
	public float avgincome;
	
	@DataName(name = "pollution")
	public float pollution;
	
	@DataName(name = "nuclearpollution")
	public float radiation;
	
	@DataName(name = "basepop")
	public float basepop;
	
	@DataName(name = "basepopdensity")
	public float basedense;
	
	@DataName(name = "minimumwage")
	public float minwage;
	
	@DataName(name = "poplostdisease")
	public float deathdisease;
	
	@DataName(name = "poplostcrime")
	public float deathcrime;
	
	@DataName(name = "imp_coalpower")
	public byte coalpowers;
	
	@DataName(name = "imp_oilpower")
	public byte oilpowers;
	
	@DataName(name = "imp_nuclearpower")
	public byte nukepowers;
	
	@DataName(name = "imp_windpower")
	public byte windpowers;
	
	@DataName(name = "imp_coalmine")
	public byte coalmines;
	
	@DataName(name = "imp_oilwell")
	public byte oilwells;
	
	@DataName(name = "imp_ironmine")
	public byte ironmines;
	
	@DataName(name = "imp_bauxitemine")
	public byte bauxmines;
	
	@DataName(name = "imp_leadmine")
	public byte leadmines;
	
	@DataName(name = "imp_uramine")
	public byte uranmines;
	
	@DataName(name = "imp_farm")
	public byte farms;
	
	@DataName(name = "imp_gasrefinery")
	public byte gasorefines;
	
	@DataName(name = "imp_steelmill")
	public byte steelmills;
	
	@DataName(name = "imp_aluminumrefinery")
	public byte alumrefines;
	
	@DataName(name = "imp_munitionsfactory")
	public byte munitrefines;
	
	@DataName(name = "imp_policestation")
	public byte police;
	
	@DataName(name = "imp_hospital")
	public byte hospitals;
	
	@DataName(name = "imp_recyclingcenter")
	public byte recyclers;
	
	@DataName(name = "imp_subway")
	public byte subways;
	
	@DataName(name = "imp_supermarket")
	public byte supermarkets;
	
	@DataName(name = "imp_bank")
	public byte banks;
	
	@DataName(name = "imp_mall")
	public byte malls;
	
	@DataName(name = "imp_stadium")
	public byte stadiums;
	
	@DataName(name = "imp_barracks")
	public byte barracks;
	
	@DataName(name = "imp_factory")
	public byte factories;
	
	@DataName(name = "imp_hangar")
	public byte hangars;
	
	@DataName(name = "imp_drydock")
	public byte drydocks;

	@Override
	public long getID() {
		return id;
	}

}
