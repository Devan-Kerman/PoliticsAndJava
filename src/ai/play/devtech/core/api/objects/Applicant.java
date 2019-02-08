package ai.play.devtech.core.api.objects;

import ai.play.devtech.core.objects.JSONName;

public class Applicant {

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
}
