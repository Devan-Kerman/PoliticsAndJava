package ai.play.devtech.core.api.objects;


import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Colors;
import ai.play.devtech.core.api.enums.WarPolicies;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * An object represented in the Alliance Member api
 *
 * @author devan
 */
public class AllianceMember extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "nationid")
	public int nationid;

	@DataName (name = "nation")
	public String nation;

	@DataName (name = "leader")
	public String leader;

	@DataName (name = "war_policy")
	public WarPolicies war;

	@DataName (name = "color")
	public Colors color;

	@DataName (name = "alliance")
	public String alliance;

	@DataName (name = "allianceid")
	public short allianceid;

	@DataName (name = "allianceposition")
	public byte alliancerank;

	@DataName (name = "cities")
	public short cities;

	@DataName (name = "offensivewars")
	public byte offWars;

	@DataName (name = "defensivewars")
	public byte defWars;

	@DataName (name = "score")
	public float score;

	@DataName (name = "vacmode")
	public int vacturns;

	@DataName (name = "minutessinceactive")
	public long inactivity; // In minuets

	@DataName (name = "infrastructure")
	public double infra;

	@DataName (name = "cityprojecttimerturns")
	public byte cityturns;

	@DataName (name = "bauxiteworks")
	public boolean bauxworks;

	@DataName (name = "ironworks")
	public boolean ironworks;

	@DataName (name = "armsstockpile")
	public boolean stockpile;

	@DataName (name = "emgasreserve")
	public boolean gasreserve;

	@DataName (name = "massirrigation")
	public boolean irrigation;

	@DataName (name = "inttradecenter")
	public boolean tradecenter;

	@DataName (name = "missilepad")
	public boolean missilepad;

	@DataName (name = "nuclearresfac")
	public boolean nukeproj;

	@DataName (name = "irondome")
	public boolean irondome;

	@DataName (name = "vitaldefsys")
	public boolean vitaldefense;

	@DataName (name = "intagncy")
	public boolean spyProject;

	@DataName (name = "uraniumenrich")
	public boolean uranrich;

	@DataName (name = "propbureau")
	public boolean propbureau;

	@DataName (name = "cenciveng")
	public boolean engineering;

	@DataName (name = "money")
	public double money;

	@DataName (name = "food")
	public double food;

	@DataName (name = "coal")
	public double coal;

	@DataName (name = "oil")
	public double oil;

	@DataName (name = "uranium")
	public double uran;

	@DataName (name = "bauxite")
	public double baux;

	@DataName (name = "iron")
	public double iron;

	@DataName (name = "lead")
	public double lead;

	@DataName (name = "gasoline")
	public double gaso;

	@DataName (name = "munitions")
	public double munit;

	@DataName (name = "aluminum")
	public double alum;

	@DataName (name = "steel")
	public double steel;

	@DataName (name = "credits")
	public int creds;

	@DataName (name = "soldiers")
	public long soldiers;

	@DataName (name = "tanks")
	public int tanks;

	@DataName (name = "aircraft")
	public int aircraft;

	@DataName (name = "ships")
	public short ships;

	@DataName (name = "missiles")
	public short missiles;

	@DataName (name = "nukes")
	public short nukes;

	@DataName (name = "spies")
	public byte spies;

	@Override
	public long getID() {
		return nationid;
	}

}