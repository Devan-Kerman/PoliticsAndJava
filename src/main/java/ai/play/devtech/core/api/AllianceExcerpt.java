package ai.play.devtech.core.api;

import java.util.Date;

import org.beryx.awt.color.ColorFactory;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.Colors;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * The object in the Alliances API
 *
 * @author devan
 */
public class AllianceExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Alliance id
	 */
	@DataName (name = "id")
	public int allianceid;

	/**
	 * The day they were created
	 */
	@DataName (name = "founddate")
	public Date founded;

	/**
	 * Alliance name
	 */
	@DataName (name = "name")
	public String name;

	/**
	 * Alliance acronym
	 */
	@DataName (name = "acronym")
	public String acronym;

	/**
	 * Color of the alliance (enum form) use {@link ColorFactory#valueOf(String)} in order to obtain java color object
	 */
	@DataName (name = "color")
	public Colors color;

	/**
	 * The alliances rank
	 */
	@DataName (name = "rank")
	public int rank;
	
	/**
	 * Total member count in the alliance
	 */
	@DataName (name = "members")
	public short members;

	/**
	 * Total score of all members combined (doens't include VM players iirc)
	 */
	@DataName (name = "score")
	public double score;

	/**
	 * Nation ids of all the leaders
	 */
	@DataName (name = "leaderids")
	public int[] leaderids;

	/**
	 * Nation ids of all the officers
	 */
	@DataName (name = "officerids")
	public int[] officerids;

	/**
	 * Nation ids of all the heirs
	 */
	@DataName (name = "heirids")
	public int[] heirids;

	/**
	 * The average nation's score in that alliance
	 */
	@DataName (name = "avgscore")
	public float avgscore;

	/**
	 * Flag image url
	 */
	@DataName (name = "flagurl")
	public String flagurl;

	/**
	 * Forum page url (DOE, etc.)
	 */
	@DataName (name = "forumurl")
	public String forum;

	/**
	 * Discord or some other ghetto communication channel
	 */
	@DataName (name = "ircchan")
	public String irc;

	@Override
	public long getID() {
		return allianceid;
	}

}
