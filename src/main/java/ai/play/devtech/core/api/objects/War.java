package main.java.ai.play.devtech.core.api.objects;

import java.util.Date;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;
import main.java.ai.play.devtech.util.math.CastMath;

public class War extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "war_ended")
	public boolean warEnded;
	
	@JSONName(name = "date")
	public Date date;
	
	@JSONName(name = "aggressor_id")
	public int aggID;
	
	@JSONName(name = "defender_id")
	public int defID;
	
	@JSONName(name = "aggressor_alliance_name")
	public String aggAAName;
	
	@JSONName(name = "aggressor_is_applicant")
	public boolean aggApplicant;
	
	@JSONName(name = "defender_alliance_name")
	public String defAAName;
	
	@JSONName(name = "defender_is_applicant")
	public boolean defApplicant;
	
	@JSONName(name = "aggressor_offering_peace")
	public boolean aggOfferingPeace;
	
	@JSONName(name = "war_reason")
	public String warReason;
	
	@JSONName(name = "ground_control")
	public int groundControl;
	
	@JSONName(name = "air_superiority")
	public int airSuperiority;
	
	@JSONName(name = "blockade")
	public int blockade;
	
	@JSONName(name = "aggressor_military_action_points")
	public byte aggMAP;
	
	@JSONName(name = "defender_military_action_points")
	public byte defMAP;
	
	@JSONName(name = "aggressor_resistance")
	public byte aggResist;
	
	@JSONName(name = "defender_resistance")
	public byte defResist;
	
	@JSONName(name = "aggressor_is_fortified")
	public boolean aggFortified;
	
	@JSONName(name = "defender_is_fortified")
	public boolean defFortified;
	
	@JSONName(name = "turns_left")
	public byte turnsLeft;

	@Override
	public long getID() {
		return CastMath.twoIntsToLong(aggID, defID);
	}

}
