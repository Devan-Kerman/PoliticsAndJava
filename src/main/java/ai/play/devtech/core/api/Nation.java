package ai.play.devtech.core.api;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.*;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.util.Date;

/**
 * A class that represents an ingame nation
 *
 * @author devan
 */
public class Nation extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "cityids")
	public int[] cityids;

	@DataName (name = "cityprojecttimerturns")
	public byte citytimer;

	@DataName (name = "nationid")
	public int nationid;

	@DataName (name = "name")
	public String name;

	@DataName (name = "prename")
	public String prename;

	@DataName (name = "continent")
	public Continents continent;

	@DataName (name = "socialpolicy")
	public SocialPolicies social;

	@DataName (name = "color")
	public Colors color;

	@DataName (name = "minutessinceactive")
	public long mininactive;

	@DataName (name = "uniqueid")
	public String uuid;

	@DataName (name = "government")
	public String gov;

	@DataName (name = "domestic_policy")
	public DomesticPolicies domestic;

	@DataName (name = "war_policy")
	public WarPolicies war;

	@DataName (name = "founded")
	public Date founded;

	/**
	 * This is the age in days
	 */
	@DataName (name = "daysold")
	public int age;

	@DataName (name = "alliance")
	public String alliance;

	@DataName (name = "allianceposition")
	public int aarank;

	@DataName (name = "allianceid")
	public int aaid;

	@DataName (name = "flagurl")
	public String flag;

	@DataName (name = "leadername")
	public String leader;

	@DataName (name = "title")
	public String title;

	@DataName (name = "ecopolicy")
	public EconomicPolicies econ;

	@DataName (name = "approvalrating")
	public float approval;

	@DataName (name = "nationrank")
	public short rank;

	@DataName (name = "nationrankstrings")
	public String rankstrn;

	@DataName (name = "nrtotal")
	public float nrtotal;

	@DataName (name = "cities")
	public byte cities;

	@DataName (name = "latitude")
	public float latitude;

	@DataName (name = "longitude")
	public float longitude;

	@DataName (name = "score")
	public double score;

	@DataName (name = "population")
	public long pop;

	@DataName (name = "gdp")
	public double gdp;

	@DataName (name = "totalinfrastructure")
	public double totalinfra;

	@DataName (name = "landarea")
	public double totalland;

	@DataName (name = "soldiers")
	public int soldiers;

	@DataName (name = "soldiercasualties")
	public int soldiersded;

	@DataName (name = "soldierskilled")
	public int soldierskilled;

	@DataName (name = "tanks")
	public int tanks;

	@DataName (name = "tankcasualties")
	public int tanksded;

	@DataName (name = "tankskilled")
	public int tankskilled;

	@DataName (name = "aircraft")
	public int planes;

	@DataName (name = "aircraftcasualties")
	public int planesded;

	@DataName (name = "aircraftkilled")
	public int planeskilled;

	@DataName (name = "ships")
	public int ships;

	@DataName (name = "shipcasualties")
	public int shipsded;

	@DataName (name = "shipskilled")
	public int shipskilled;

	@DataName (name = "missiles")
	public int missles;

	@DataName (name = "missilelaunched")
	public int misslaunched;

	@DataName (name = "missileseaten")
	public int misseaten;

	@DataName (name = "nukes")
	public int nukes;

	@DataName (name = "nukeslaunched")
	public int nukeslaunched;

	@DataName (name = "nukeseaten")
	public int nukeseaten;

	@DataName (name = "infdesttot")
	public double infrakilled;

	@DataName (name = "infraLost")
	public double infraded;

	@DataName (name = "moneyLooted")
	public double moneylooted;

	@DataName (name = "ironworks")
	public boolean ironworks;

	@DataName (name = "bauxiteworks")
	public boolean bauxworks;

	@DataName (name = "armsstockpile")
	public boolean armsstock;

	@DataName (name = "emgasreserve")
	public boolean gasoreserve;

	@DataName (name = "massirrigation")
	public boolean irrigation;

	@DataName (name = "inttradecenter")
	public boolean tradecenter;

	@DataName (name = "missilelpad")
	public boolean misslepad;

	@DataName (name = "nuclearresfac")
	public boolean nukepad;

	@DataName (name = "irondome")
	public boolean irondome;

	@DataName (name = "vitaldefsys")
	public boolean vitaldef;

	@DataName (name = "intagncy")
	public boolean intelagency;

	@DataName (name = "uraniumenrich")
	public boolean uranrich;

	@DataName (name = "propbureau")
	public boolean propbureau;

	@DataName (name = "cenciveng")
	public boolean engineer;

	@DataName (name = "vmode")
	public int vmturns;

	@DataName (name = "offensivewars")
	public byte offwars;

	@DataName (name = "defensivewars")
	public byte defwars;

	@DataName (name = "offensivewar_ids")
	public int[] offwarids;

	@DataName (name = "defensivewar_ids")
	public int[] defwarids;

	@DataName (name = "beige_turns_left")
	public short beigeturns;

	@DataName (name = "radiation_index")
	public float radiation;

	@DataName (name = "season")
	public Season season;

	public long getID() {
		return nationid;
	}
}
