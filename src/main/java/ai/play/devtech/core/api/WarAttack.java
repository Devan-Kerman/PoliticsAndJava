package ai.play.devtech.core.api;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.AttackType;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.util.Date;

/**
 * Represents an attack in a war between 2 nations ingame
 *
 * @author devan
 */
public class WarAttack extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "war_attack_id")
	public long attackid;

	@DataName (name = "date")
	public Date date;

	@DataName (name = "war_id")
	public long warId;

	@DataName (name = "attacker_nation_id")
	public int attackernid;

	@DataName (name = "defender_nation_id")
	public int deffendernid;

	@DataName (name = "attack_type")
	public AttackType attackType;

	@DataName (name = "victor")
	public int victorid;

	@DataName (name = "success")
	public byte success;

	@DataName (name = "attcas1")
	public String attcas1; // TODO find out wtf this is

	@DataName (name = "attcas2")
	public String attcas2;

	@DataName (name = "defcas1")
	public String defcas1;

	@DataName (name = "defcas2")
	public String defcas2;

	@DataName (name = "city_id")
	public int cityId;

	@DataName (name = "infra_destroyed")
	public float infraDed;

	@DataName (name = "improvements_destroyed")
	public int improveded;

	@DataName (name = "money_looted")
	public double moneyLooted;

	@DataName (name = "note")
	public String note;

	@DataName (name = "city_infra_before")
	public float infrabefore;

	@DataName (name = "infra_destroyed_value")
	public double infradedVal;

	@DataName (name = "att_gas_used")
	public float attGasUsed;

	@DataName (name = "att_mun_used")
	public float attMunUsed;

	@DataName (name = "def_gas_used")
	public float defGasUsed;

	@DataName (name = "def_mun_used")
	public float defMunUsed;

	@Override
	public long getID() {
		return attackid;
	}

}
