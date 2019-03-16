package ai.play.devtech.core.api.objects;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.objects.manipulation.DataName;

public class Applicant extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName(name = "nationid")
	public int nationid;

	@DataName(name = "nation")
	public String nation;
	
	@DataName(name = "leader")
	public String leader;
	
	@DataName(name = "continent")
	public String continent;
	
	@DataName(name = "cities")
	public byte cities;
	
	@DataName(name = "score")
	public float score;

	@Override
	public long getID() {
		return nationid;
	}
}
