package ai.play.devtech.core.api.objects;


import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Colors;
import ai.play.devtech.core.api.enums.WarPolicies;
import ai.play.devtech.core.objects.manipulation.JSONName;

/**
 * An object represented in the Alliance Member api
 * @author devan
 *
 */
public class AllianceMember extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "nationid")
	public int nationid;
	
	@JSONName(name = "nation")
	public String nation;
	
	@JSONName(name = "leader")
	public String leader;
	
	@JSONName(name = "war_policy")
	public WarPolicies war;
	
	@JSONName(name = "color")
	public Colors color;
	
	@JSONName(name = "alliance")
	public String alliance;
	
	@JSONName(name = "allianceid")
	public short allianceid;
	
	@JSONName(name = "allianceposition")
	public byte alliancerank;
	
	@JSONName(name = "cities")
	public short cities;
	
	@JSONName(name = "offensivewars")
	public byte offWars;
	
	@JSONName(name = "defensivewars")
	public byte defWars;
	
	@JSONName(name = "score")
	public float score;
	
	@JSONName(name = "vacmode")
	public int vacturns;
	
	@JSONName(name = "minutessinceactive")
	public long inactivity; // In minuets
	
	@JSONName(name = "infrastructure")
	public double infra;
	
	@JSONName(name = "cityprojecttimerturns")
	public byte cityturns;
	
	@JSONName(name = "bauxiteworks")
	public boolean bauxworks;
	
	@JSONName(name = "ironworks")
	public boolean ironworks;
	
	@JSONName(name = "armsstockpile")
	public boolean stockpile;
	
	@JSONName(name = "emgasreserve")
	public boolean gasreserve;
	
	@JSONName(name = "massirrigation")
	public boolean irrigation;
	
	@JSONName(name = "inttradecenter")
	public boolean tradecenter;
	
	@JSONName(name = "missilepad")
	public boolean missilepad;
	
	@JSONName(name = "nuclearresfac")
	public boolean nukeproj;
	
	@JSONName(name = "irondome")
	public boolean irondome;
	
	@JSONName(name = "vitaldefsys")
	public boolean vitaldefense;
	
	@JSONName(name = "intagncy")
	public boolean spyProject;
	
	@JSONName(name = "uraniumenrich")
	public boolean uranrich;
	
	@JSONName(name = "propbureau")
	public boolean propbureau;
	
	@JSONName(name = "cenciveng")
	public boolean engineering;
	
	@JSONName(name = "money")
	public double money;
	
	@JSONName(name = "food")
	public double food;
	
	@JSONName(name = "coal")
	public double coal;
	
	@JSONName(name = "oil")
	public double oil;
	
	@JSONName(name = "uranium")
	public double uran;
	
	@JSONName(name = "bauxite")
	public double baux;
	
	@JSONName(name = "iron")
	public double iron;
	
	@JSONName(name = "lead")
	public double lead;
	
	@JSONName(name = "gasoline")
	public double gaso;
	
	@JSONName(name = "munitions")
	public double munit;
	
	@JSONName(name = "aluminum")
	public double alum;
	
	@JSONName(name = "steel")
	public double steel;
	
	@JSONName(name = "credits")
	public int creds;
	
	@JSONName(name = "soldiers")
	public long soldiers;
	
	@JSONName(name = "tanks")
	public int tanks;
	
	@JSONName(name = "aircraft")
	public int aircraft;
	
	@JSONName(name = "ships")
	public short ships;
	
	@JSONName(name = "missiles")
	public short missiles;
	
	@JSONName(name = "nukes")
	public short nukes;
	
	@JSONName(name = "spies")
	public byte spies;

	@Override
	public long getID() {
		return nationid;
	}
	
}