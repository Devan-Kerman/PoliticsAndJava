package ai.play.devtech.core.api.objects;

import java.util.Date;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.WarTypes;
import ai.play.devtech.core.objects.manipulation.JSONName;

public class WarExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;
	@JSONName(name = "warID")
	public long wid;
	
	@JSONName(name = "attackerID")
	public int attacker;
	
	@JSONName(name = "defenderID")
	public int defender;
	
	@JSONName(name = "attackerAA")
	public short attackerAA;
	
	@JSONName(name = "defenderAA")
	public short defenderAA;
	
	@JSONName(name = "war_type")
	public WarTypes type;
	
	@JSONName(name = "status")
	public String status;
	
	@JSONName(name = "date")
	public Date date;

	@Override
	public long getID() {
		return wid;
	}
	
}
