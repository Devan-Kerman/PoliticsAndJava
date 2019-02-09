package main.java.ai.play.devtech.core.api.objects;

import java.awt.Color;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.api.enums.Colors;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;

public class NationExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "nation_id")
	public int nid;
	
	@JSONName(name = "nation")
	public String name;
	
	@JSONName(name = "leader")
	public String leader;
	
	@JSONName(name = "continent")
	public String continent;
	
	@JSONName(name = "war_policy")
	public String war;
	
	@JSONName(name = "color")
	public Colors color;
	
	public Color rgb;
	
	@JSONName(name = "alliance")
	public String allaince;
	
	@JSONName(name = "allianceid")
	public int aaid;
	
	@JSONName(name = "allianceposition")
	public byte aarank;
	
	@JSONName(name = "cities")
	public byte cities;
	
	@JSONName(name = "infrastructure")
	public float infra;
	
	@JSONName(name = "offensivewars")
	public byte offwars;
	
	@JSONName(name = "defensivewars")
	public byte defwars;
	
	@JSONName(name = "score")
	public float score;
	
	@JSONName(name = "rank")
	public int rank;
	
	@JSONName(name = "vacmode")
	public int vacturns;
	
	@JSONName(name = "minutessinceactive")
	public long mininactive;

	@Override
	public long getID() {
		return nid;
	}
	
	
}
