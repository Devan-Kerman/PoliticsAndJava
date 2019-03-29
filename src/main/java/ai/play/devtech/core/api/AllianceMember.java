package ai.play.devtech.core.api;


import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.AARanks;
import ai.play.devtech.core.enums.Colors;
import ai.play.devtech.core.enums.WarPolicies;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * An object represented in the Alliance Member api
 * @author devan
 */
public class AllianceMember extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * The nation's id
	 */
	@DataName (name = "nationid")
	public int nationid;

	/**
	 * Nation name
	 */
	@DataName (name = "nation")
	public String name;

	/**
	 * Leader name
	 */
	@DataName (name = "leader")
	public String leader;

	/**
	 * War policies
	 */
	@DataName (name = "war_policy")
	public WarPolicies war;

	/**
	 * Color
	 */
	@DataName (name = "color")
	public Colors color;

	/**
	 * Alliance name
	 */
	@DataName (name = "alliance")
	public String alliance;

	/**
	 * Alliance id
	 */
	@DataName (name = "allianceid")
	public int allianceid;

	/**
	 * Alliance rank (position, member, heir, leader, etc.)
	 * @see {@link AARanks}
	 */
	@DataName (name = "allianceposition")
	public byte alliancerank;

	/**
	 * City count
	 */
	@DataName (name = "cities")
	public short cities;

	/**
	 * The amount of offensive wars the nation is in (MAX: 5)
	 */
	@DataName (name = "offensivewars")
	public byte offWars;

	/**
	 * The amount of defensive wars a nation is in (MAX: 3)
	 */
	@DataName (name = "defensivewars")
	public byte defWars;

	/**
	 * The current nation's score
	 */
	@DataName (name = "score")
	public float score;

	/**
	 * How many turns the member has left in vacation mode
	 */
	@DataName (name = "vacmode")
	public int vacturns;

	/**
	 * The time in minutes since the player last logged on
	 */
	@DataName (name = "minutessinceactive")
	public long inactivity;

	/**
	 * The total infrastructure this nation has
	 */
	@DataName (name = "infrastructure")
	public double infra;

	/**
	 * The amount of turns until the player can purchase a new city or project
	 */
	@DataName (name = "cityprojecttimerturns")
	public byte cityturns;

	/**
	 * Whether or not the player has the bauxite works project
	 */
	@DataName (name = "bauxiteworks")
	public boolean bauxworks;

	/**
	 * Whether or not the player has the iron works project
	 */
	@DataName (name = "ironworks")
	public boolean ironworks;

	/**
	 * Whether or not the player has the munitions stockpile project
	 */
	@DataName (name = "armsstockpile")
	public boolean stockpile;

	/**
	 * Whether or not the player has the emergency gasoline reserves project
	 */
	@DataName (name = "emgasreserve")
	public boolean gasreserve;

	/**
	 * Whether or not the player has the mass irrigation project
	 */
	@DataName (name = "massirrigation")
	public boolean irrigation;

	/**
	 * Whether or not the player has the international trade center project
	 */
	@DataName (name = "inttradecenter")
	public boolean tradecenter;

	/**
	 * Whether or not the player has the missile launch pad project
	 */
	@DataName (name = "missilepad")
	public boolean missilepad;

	/**
	 * Whether or not the player has the nuclear launch facility project
	 */
	@DataName (name = "nuclearresfac")
	public boolean nukeproj;

	/**
	 * Whether or not the player has the iron dome project
	 */
	@DataName (name = "irondome")
	public boolean irondome;

	/**
	 * Whether or not the player has the vital defense system project
	 */
	@DataName (name = "vitaldefsys")
	public boolean vitaldefense;

	/**
	 * Whether or not the player has the intelligence bureu project (idk it's the thing that gives u more spys and stuff)
	 */
	@DataName (name = "intagncy")
	public boolean spyProject;

	/**
	 * Whether or not the player has the uranium enrichment project
	 */
	@DataName (name = "uraniumenrich")
	public boolean uranrich;

	/**
	 * Whether or not the player has the propaganda bureau project
	 */
	@DataName (name = "propbureau")
	public boolean propbureau;

	/**
	 * Whether or not the player has the civil engineering project
	 */
	@DataName (name = "cenciveng")
	public boolean engineering;

	/**
	 * How much money the player has
	 */
	@DataName (name = "money")
	public double money;

	/**
	 * How much food the player has
	 */
	@DataName (name = "food")
	public double food;

	/**
	 * How much coal the player has
	 */
	@DataName (name = "coal")
	public double coal;

	/**
	 * How much oil the player has
	 */
	@DataName (name = "oil")
	public double oil;

	/**
	 * How much uranium the player has
	 */
	@DataName (name = "uranium")
	public double uran;

	/**
	 * How much bauxite the player has
	 */
	@DataName (name = "bauxite")
	public double baux;

	/**
	 * How much iron the player has
	 */
	@DataName (name = "iron")
	public double iron;

	/**
	 * How much lead the player has
	 */
	@DataName (name = "lead")
	public double lead;

	/**
	 * How much gasoline the player has
	 */
	@DataName (name = "gasoline")
	public double gaso;

	/**
	 * How much munitions the player has
	 */
	@DataName (name = "munitions")
	public double munit;

	/**
	 * How much aluminum the player has
	 */
	@DataName (name = "aluminum")
	public double alum;

	/**
	 * How much steel the player has
	 */
	@DataName (name = "steel")
	public double steel;

	/**
	 * How much credits the player has
	 */
	@DataName (name = "credits")
	public int creds;

	/**
	 * Total soldiers the member has
	 */
	@DataName (name = "soldiers")
	public long soldiers;

	/**
	 * Total tanks the member has
	 */
	@DataName (name = "tanks")
	public int tanks;

	/**
	 * Total aircraft the player has
	 */
	@DataName (name = "aircraft")
	public int aircraft;

	/**
	 * Total ships the player has
	 */
	@DataName (name = "ships")
	public short ships;

	/**
	 * Total missiles the player hass
	 */
	@DataName (name = "missiles")
	public short missiles;

	/**
	 * Total nukes the player has
	 */
	@DataName (name = "nukes")
	public short nukes;

	/**
	 * Total spies the player has
	 */
	@DataName (name = "spies")
	public byte spies;

	@Override
	public long getID() {
		return nationid;
	}

}