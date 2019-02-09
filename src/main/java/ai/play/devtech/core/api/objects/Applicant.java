package main.java.ai.play.devtech.core.api.objects;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;

public class Applicant extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "nationid")
	public int nationid;

	@JSONName(name = "nation")
	public String nation;
	
	@JSONName(name = "leader")
	public String leader;
	
	@JSONName(name = "continent")
	public String continent;
	
	@JSONName(name = "cities")
	public byte cities;
	
	@JSONName(name = "score")
	public float score;

	@Override
	public long getID() {
		return nationid;
	}
}
