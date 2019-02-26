package ai.play.devtech.core.api.objects;

import java.util.Date;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Colors;
import ai.play.devtech.core.api.enums.Continents;
import ai.play.devtech.core.api.enums.DomesticPolicies;
import ai.play.devtech.core.api.enums.EconomicPolicies;
import ai.play.devtech.core.api.enums.Season;
import ai.play.devtech.core.api.enums.SocialPolicies;
import ai.play.devtech.core.api.enums.WarPolicies;
import ai.play.devtech.core.objects.manipulation.JSONName;

public class Nation extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "cityids")
	public int[] cityids;
	
	@JSONName(name = "cityprojecttimerturns")
	public byte citytimer;
	
	@JSONName(name = "nationid")
	public int nationid;
	
	@JSONName(name = "name")
	public String name;
	
	@JSONName(name = "prename")
	public String prename;
	
	@JSONName(name = "continent")
	public Continents continent;
	
	@JSONName(name = "socialpolicy")
	public SocialPolicies social;
	
	@JSONName(name = "color")
	public Colors color;
	
	@JSONName(name = "minutessinceactive")
	public long mininactive;
	
	@JSONName(name = "uniqueid")
	public String uuid;
	
	@JSONName(name = "government")
	public String gov;
	
	@JSONName(name = "domestic_policy")
	public DomesticPolicies domestic;
	
	@JSONName(name = "war_policy")
	public WarPolicies war;
	
	@JSONName(name = "founded")
	public Date founded;
	
	/**
	 * This is the age in days
	 */
	@JSONName(name = "daysold")
	public int age;
	
	@JSONName(name = "alliance")
	public String alliance;
	
	@JSONName(name = "allianceposition")
	public int aarank;
	
	@JSONName(name = "allianceid")
	public int aaid;
	
	@JSONName(name = "flagurl")
	public String flag;
	
	@JSONName(name = "leadername")
	public String leader;
	
	@JSONName(name = "title")
	public String title;
	
	@JSONName(name = "ecopolicy")
	public EconomicPolicies econ;
	
	@JSONName(name = "approvalrating")
	public float approval;
	
	@JSONName(name = "nationrank")
	public short rank;
	
	@JSONName(name = "nationrankstrings")
	public String rankstrn;
	
	@JSONName(name = "nrtotal")
	public float nrtotal;
	
	@JSONName(name = "cities")
	public byte cities;
	
	@JSONName(name = "latitude")
	public float latitude;
	
	@JSONName(name = "longitude")
	public float longitude;
	
	@JSONName(name = "score")
	public double score;
	
	@JSONName(name = "population")
	public long pop;
	
	@JSONName(name = "gdp")
	public double gdp;
	
	@JSONName(name = "totalinfrastructure")
	public double totalinfra;
	
	@JSONName(name = "landarea")
	public double totalland;
	
	@JSONName(name = "soldiers")
	public int soldiers;
	
	@JSONName(name = "soldiercasualties")
	public int soldiersded;
	
	@JSONName(name = "soldierskilled")
	public int soldierskilled;
	
	@JSONName(name = "tanks")
	public int tanks;
	
	@JSONName(name = "tankcasualties")
	public int tanksded;
	
	@JSONName(name = "tankskilled")
	public int tankskilled;
	
	@JSONName(name = "aircraft")
	public int planes;
	
	@JSONName(name = "aircraftcasualties")
	public int planesded;
	
	@JSONName(name = "aircraftkilled")
	public int planeskilled;
	
	@JSONName(name = "ships")
	public int ships;
	
	@JSONName(name = "shipcasualties")
	public int shipsded;
	
	@JSONName(name = "shipskilled")
	public int shipskilled;
	
	@JSONName(name = "missiles")
	public int missles;
	
	@JSONName(name = "missilelaunched")
	public int misslaunched;
	
	@JSONName(name = "missileseaten")
	public int misseaten;
	
	@JSONName(name = "nukes")
	public int nukes;
	
	@JSONName(name = "nukeslaunched")
	public int nukeslaunched;
	
	@JSONName(name = "nukeseaten")
	public int nukeseaten;
	
	@JSONName(name = "infdesttot")
	public double infrakilled;
	
	@JSONName(name = "infraLost")
	public double infraded;
	
	@JSONName(name = "moneyLooted")
	public double moneylooted;
	
	@JSONName(name = "ironworks")
	public boolean ironworks;
	
	@JSONName(name = "bauxiteworks")
	public boolean bauxworks;
	
	@JSONName(name = "armsstockpile")
	public boolean armsstock;
	
	@JSONName(name = "emgasreserve")
	public boolean gasoreserve;
	
	@JSONName(name = "massirrigation")
	public boolean irrigation;
	
	@JSONName(name = "inttradecenter")
	public boolean tradecenter;
	
	@JSONName(name = "missilelpad")
	public boolean misslepad;
	
	@JSONName(name = "nuclearresfac")
	public boolean nukepad;
	
	@JSONName(name = "irondome")
	public boolean irondome;
	
	@JSONName(name = "vitaldefsys")
	public boolean vitaldef;
	
	@JSONName(name = "intagncy")
	public boolean intelagency;
	
	@JSONName(name = "uraniumenrich")
	public boolean uranrich;
	
	@JSONName(name = "propbureau")
	public boolean propbureau;
	
	@JSONName(name = "cenciveng")
	public boolean engineer;
	
	@JSONName(name = "vmode") 
	public int vmturns;
	
	@JSONName(name = "offensivewars") 
	public byte offwars;
	
	@JSONName(name = "defensivewars")
	public byte defwars;
	
	@JSONName(name = "offensivewar_ids")
	public int[] offwarids;
	
	@JSONName(name = "defensivewar_ids")
	public int[] defwarids;
	
	@JSONName(name = "beige_turns_left")
	public short beigeturns;
	
	@JSONName(name = "radiation_index")
	public float radiation;
	
	@JSONName(name = "season")
	public Season season;

	public long getID() {
		return nationid;
	}
}
