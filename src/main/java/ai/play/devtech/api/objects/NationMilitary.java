package ai.play.devtech.api.objects;

import ai.play.devtech.APIObject;
import ai.play.devtech.api.enums.AARanks;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * A nation's military
 *
 * @author devan
 */
public class NationMilitary extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "nation_id")
	public int nid;

	@DataName (name = "vm_indicator")
	public int vmturns;

	@DataName (name = "score")
	public int score;

	@DataName (name = "soldiers")
	public int soldiers;

	@DataName (name = "tanks")
	public int tanks;

	@DataName (name = "aircraft")
	public int planes;

	@DataName (name = "ships")
	public short ships;

	@DataName (name = "missiles")
	public short missles;

	@DataName (name = "nukes")
	public short nukes;

	@DataName (name = "alliance")
	public String alliance;

	@DataName (name = "alliance_id")
	public int aaid;

	/**
	 * {@link AARanks}
	 */
	@DataName (name = "alliance_position")
	public byte aarank;

	@Override
	public long getID() {
		return nid;
	}

}
