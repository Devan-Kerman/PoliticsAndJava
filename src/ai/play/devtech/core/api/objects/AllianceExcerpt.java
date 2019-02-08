package ai.play.devtech.core.api.objects;

import java.util.Date;

import ai.play.devtech.core.api.enums.Colors;
import ai.play.devtech.core.api.enums.Continents;
import ai.play.devtech.core.objects.JSONName;

/**
 * The object in the Alliances API
 * @author devan
 *
 */
public class AllianceExcerpt {

	@JSONName(name = "id")
	public short id;
	
	@JSONName(name = "founddate")
	public Date founded;
	
	@JSONName(name = "name")
	public String name;
	
	@JSONName(name = "acronym")
	public String acro;
	
	@JSONName(name = "color")
	public Colors color;
	
	@JSONName(name = "continent")
	public Continents continent;
	
	@JSONName(name = "rank")
	public byte rank;
	
	@JSONName(name = "members")
	public short members;
	
	@JSONName(name = "score")
	public double score;
	
	@JSONName(name = "leaderids")
	public int[] leaders;
	
	@JSONName(name = "officerids")
	public int[] officers;
	
	@JSONName(name = "heirids")
	public int[] heirs;
	
	@JSONName(name = "avgscore")
	public float avgscore;
	
	@JSONName(name = "flagurl")
	public String flagurl;
	
	@JSONName(name = "forumurl")
	public String forum;
	
	@JSONName(name = "ircchan")
	public String irc;

}
