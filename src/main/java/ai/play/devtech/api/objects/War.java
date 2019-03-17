package ai.play.devtech.api.objects;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.util.Date;

/**
 * This class represents a war between 2 nations
 *
 * @author devan
 */
public class War extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "war_ended")
	public boolean warEnded;

	@DataName (name = "date")
	public Date date;

	@DataName (name = "aggressor_id")
	public int aggID;

	@DataName (name = "defender_id")
	public int defID;

	@DataName (name = "aggressor_alliance_name")
	public String aggAAName;

	@DataName (name = "aggressor_is_applicant")
	public boolean aggApplicant;

	@DataName (name = "defender_alliance_name")
	public String defAAName;

	@DataName (name = "defender_is_applicant")
	public boolean defApplicant;

	@DataName (name = "aggressor_offering_peace")
	public boolean aggOfferingPeace;

	@DataName (name = "war_reason")
	public String warReason;

	@DataName (name = "ground_control")
	public int groundControl;

	@DataName (name = "air_superiority")
	public int airSuperiority;

	@DataName (name = "blockade")
	public int blockade;

	@DataName (name = "aggressor_military_action_points")
	public byte aggMAP;

	@DataName (name = "defender_military_action_points")
	public byte defMAP;

	@DataName (name = "aggressor_resistance")
	public byte aggResist;

	@DataName (name = "defender_resistance")
	public byte defResist;

	@DataName (name = "aggressor_is_fortified")
	public boolean aggFortified;

	@DataName (name = "defender_is_fortified")
	public boolean defFortified;

	@DataName (name = "turns_left")
	public byte turnsLeft;

	@Override
	public long getID() {
		return (long) aggID << 32 | defID & 0xFFFFFFFFL;
	}

}
