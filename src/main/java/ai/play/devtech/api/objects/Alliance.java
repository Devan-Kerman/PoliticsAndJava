package ai.play.devtech.api.objects;


import ai.play.devtech.APIObject;
import ai.play.devtech.api.enums.Colors;
import ai.play.devtech.core.objects.manipulation.DataName;
import org.beryx.awt.color.ColorFactory;

/**
 * This is the api object representing an alliance
 *
 * @author devan
 */
public class Alliance extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Leader ids
	 */
	@DataName (name = "leaderids")
	public int[] lids;

	/**
	 * Alliance id
	 */
	@DataName (name = "allianceid")
	public short aaid;

	/**
	 * Alliance Name
	 */
	@DataName (name = "name")
	public String name;

	/**
	 * Alliance acronym
	 */
	@DataName (name = "acronym")
	public String acronym;

	/**
	 * Total alliance score
	 */
	@DataName (name = "score")
	public float score;

	/**
	 * Color of the alliance (enum form) use {@link ColorFactory#valueOf(String)} in order to obtain java color object
	 */
	@DataName (name = "color")
	public Colors color;

	/**
	 * The alliances total member count
	 */
	@DataName (name = "members")
	public short members;

	/**
	 * All of the members in the alliance
	 */
	@DataName (name = "member_id_list")
	public int[] memberids;

	/**
	 * Number of members in vacation mode
	 */
	@DataName (name = "vmodemembers")
	public short vccount;

	/**
	 * Whether or not the alliance is accepting members
	 */
	@DataName (name = "accepting members")
	public boolean accepting;

	/**
	 * The number of applicants this alliance currently has
	 */
	@DataName (name = "applicants")
	public byte applicants;

	/**
	 * The image url of this alliances flag
	 */
	@DataName (name = "flagurl")
	public String flag;

	/**
	 * Forum
	 */
	@DataName (name = "forumurl")
	public String forum;

	/**
	 * Discord or sum ghetto irc (what is this, 2012?)
	 */
	@DataName (name = "irc")
	public String irc;

	/**
	 * Alliance GDP
	 */
	@DataName (name = "gdp")
	public double gdp;

	/**
	 * The total amount of cities an alliance has
	 */
	@DataName (name = "cities")
	public short cities;

	/**
	 * Total amount of soldiers in alliance
	 */
	@DataName (name = "soldiers")
	public int soldiers;

	/**
	 * Total amount of tanks in alliance
	 */
	@DataName (name = "tanks")
	public int tanks;

	/**
	 * Total amount of aircraft in alliance
	 */
	@DataName (name = "aircraft")
	public int aircraft;

	/**
	 * Total amount of ship
	 */
	@DataName (name = "ships")
	public short ships;

	/**
	 * Total amount of missiles
	 */
	@DataName (name = "missiles")
	public short missles;

	/**
	 * Total amount of nukes
	 */
	@DataName (name = "nukes")
	public short nukes;

	/**
	 * The number of treasures the alliance has
	 */
	@DataName (name = "treasures")
	public byte treasures;

	@Override
	public long getID() {
		return aaid;
	}
}
