package ai.play.devtech.core.api.objects;


import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Colors;
import ai.play.devtech.core.objects.JSONName;

/**
 * This is the api object representing an alliance
 * @author devan
 *
 */
public class Alliance extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Leader ids
	 */
	@JSONName(name = "leaderids")
	public int[] lids;
	
	/**
	 * Alliance id
	 */
	@JSONName(name = "allianceid")
	public short aaid;
	
	/**
	 * Alliance Name
	 */
	@JSONName(name = "name")
	public String name;
	
	/**
	 * Alliance acronym
	 */
	@JSONName(name = "acronym")
	public String acronym;
	
	/**
	 * Total alliance score
	 */
	@JSONName(name = "score")
	public float score;
	
	/**
	 * The alliance color
	 */
	@JSONName(name = "color")
	public Colors color;
	
	/**
	 * The alliances total member count
	 */
	@JSONName(name = "members")
	public short members;
	
	/**
	 * All of the members in the alliance
	 */
	@JSONName(name = "member_id_list")
	public int[] memberids;
	
	/**
	 * Number of members in vacation mode
	 */
	@JSONName(name = "vmodemembers")
	public short vccount;
	
	/**
	 * Whether or not the alliance is accepting members
	 */
	@JSONName(name = "accepting members")
	public boolean accepting;
	
	/**
	 * The number of applicants this alliance currently has
	 */
	@JSONName(name = "applicants")
	public byte applicants;
	
	/**
	 * The image url of this alliances flag
	 */
	@JSONName(name = "flagurl")
	public String flag;
	
	/**
	 * Forum
	 */
	@JSONName(name = "forumurl")
	public String forum;
	
	/**
	 * Discord or sum ghetto irc (what is this, 2012?)
	 */
	@JSONName(name = "irc")
	public String irc;
	
	/**
	 * Alliance GDP
	 */
	@JSONName(name = "gdp")
	public double gdp;
	
	/**
	 * The total amount of cities an alliance has
	 */
	@JSONName(name = "cities")
	public short cities;
	
	/**
	 * Total amount of soldiers in alliance
	 */
	@JSONName(name = "soldiers")
	public int soldiers;
	
	/**
	 * Total amount of tanks in alliance
	 */
	@JSONName(name = "tanks")
	public int tanks;
	
	/**
	 * Total amount of aircraft in alliance
	 */
	@JSONName(name = "aircraft")
	public int aircraft;
	
	/**
	 * Total amount of ship
	 */
	@JSONName(name = "ships")
	public short ships;
	
	/**
	 * Total amount of missiles
	 */
	@JSONName(name = "missiles")
	public short missles;
	
	/**
	 * Total amount of nukes
	 */
	@JSONName(name = "nukes")
	public short nukes;
	
	/**
	 * The number of treasures the alliance has
	 */
	@JSONName(name = "treasures")
	public byte treasures;
}
