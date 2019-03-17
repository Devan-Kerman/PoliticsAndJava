package ai.play.devtech.api.objects;

import ai.play.devtech.APIObject;
import ai.play.devtech.api.enums.Colors;
import ai.play.devtech.api.enums.Continents;
import ai.play.devtech.core.objects.manipulation.DataName;
import org.beryx.awt.color.ColorFactory;
import java.util.Date;

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
	public short aaid;

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
	public String acro;

	/**
	 * Color of the alliance (enum form) use {@link ColorFactory#valueOf(String)} in order to obtain java color object
	 */
	@DataName (name = "color")
	public Colors color;

	/**
	 * The current continent that the nation is on
	 */
	@DataName (name = "continent")
	public Continents continent;

	/**
	 * The alliances rank
	 */
	@DataName (name = "rank")
	public short rank;

	@DataName (name = "members")
	public short members;

	@DataName (name = "score")
	public double score;

	@DataName (name = "leaderids")
	public int[] lids;

	@DataName (name = "officerids")
	public int[] oids;

	@DataName (name = "heirids")
	public int[] hids;

	@DataName (name = "avgscore")
	public float avgscore;

	@DataName (name = "flagurl")
	public String flagurl;

	@DataName (name = "forumurl")
	public String forum;

	@DataName (name = "ircchan")
	public String irc;

	@Override
	public long getID() {
		return aaid;
	}

}
