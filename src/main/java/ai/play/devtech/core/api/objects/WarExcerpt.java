package ai.play.devtech.core.api.objects;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.WarTypes;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.util.Date;

/**
 * Represents a war ingame between 2 nations, provided by the wars api
 *
 * @author devan
 */
public class WarExcerpt extends APIObject {
	private static final long serialVersionUID = 1L;
	@DataName (name = "warID")
	public long wid;

	@DataName (name = "attackerID")
	public int attacker;

	@DataName (name = "defenderID")
	public int defender;

	@DataName (name = "attackerAA")
	public short attackerAA;

	@DataName (name = "defenderAA")
	public short defenderAA;

	@DataName (name = "war_type")
	public WarTypes type;

	@DataName (name = "status")
	public String status;

	@DataName (name = "date")
	public Date date;

	@Override
	public long getID() {
		return wid;
	}

}
