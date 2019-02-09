package main.java.ai.play.devtech.core.api.objects;

import java.util.Date;

import org.beryx.awt.color.ColorFactory;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.api.enums.Colors;
import main.java.ai.play.devtech.core.api.enums.Continents;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;

/**
 * The object in the Alliances API
 * @author devan
 *
 */
public class AllianceExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Alliance id
	 */
	@JSONName(name = "id")
	public short aaid;
	
	/**
	 * The day they were created
	 */
	@JSONName(name = "founddate")
	public Date founded;
	
	/**
	 * Alliance name
	 */
	@JSONName(name = "name")
	public String name;
	
	/**
	 * Alliance acronym
	 */
	@JSONName(name = "acronym")
	public String acro;
	
	/**
	 * Color of the alliance (enum form) use {@link ColorFactory#valueOf(String)} in order to obtain java color object
	 */
	@JSONName(name = "color")
	public Colors color;
	
	/**
	 * The current continent that the nation is on
	 */
	@JSONName(name = "continent")
	public Continents continent;
	
	/**
	 * The alliances rank
	 */
	@JSONName(name = "rank")
	public short rank;
	
	@JSONName(name = "members")
	public short members;
	
	@JSONName(name = "score")
	public double score;
	
	@JSONName(name = "leaderids")
	public int[] lids;
	
	@JSONName(name = "officerids")
	public int[] oids;
	
	@JSONName(name = "heirids")
	public int[] hids;
	
	@JSONName(name = "avgscore")
	public float avgscore;
	
	@JSONName(name = "flagurl")
	public String flagurl;
	
	@JSONName(name = "forumurl")
	public String forum;
	
	@JSONName(name = "ircchan")
	public String irc;

	@Override
	public long getID() {
		return aaid;
	}

}
