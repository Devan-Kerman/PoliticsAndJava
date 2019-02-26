package ai.play.devtech.core.api.objects;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.AARanks;
import ai.play.devtech.core.objects.manipulation.JSONName;

public class NationMilitary extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "nation_id")
	public int nid;
	
	@JSONName(name = "vm_indicator")
	public int vmturns;
	
	@JSONName(name = "score")
	public int score;
	
	@JSONName(name = "soldiers")
	public int soldiers;
	
	@JSONName(name = "tanks")
	public int tanks;
	
	@JSONName(name = "aircraft")
	public int planes;
	
	@JSONName(name = "ships")
	public short ships;
	
	@JSONName(name = "missiles")
	public short missles;
	
	@JSONName(name = "nukes")
	public short nukes;
	
	@JSONName(name = "alliance")
	public String alliance;
	
	@JSONName(name = "alliance_id")
	public int aaid;
	
	/**
	 * {@link AARanks}
	 */
	@JSONName(name = "alliance_position")
	public byte aarank;

	@Override
	public long getID() {
		return nid;
	}

}
