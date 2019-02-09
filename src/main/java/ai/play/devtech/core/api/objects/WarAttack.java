package main.java.ai.play.devtech.core.api.objects;

import java.util.Date;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.api.enums.AttackType;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;

public class WarAttack extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "war_attack_id")
	public long attackid;
	
	@JSONName(name = "date")
	public Date date;
	
	@JSONName(name = "war_id")
	public long warId;
	
	@JSONName(name = "attacker_nation_id")
	public int attackernid;
	
	@JSONName(name = "defender_nation_id")
	public int deffendernid;
	
	@JSONName(name = "attack_type")
	public AttackType attackType;
	
	@JSONName(name = "victor")
	public int victorid;
	
	@JSONName(name = "success")
	public byte success;
	
	@JSONName(name = "attcas1")
	public String attcas1; // TODO find out wtf this is
	
	@JSONName(name = "attcas2")
	public String attcas2;
	
	@JSONName(name = "defcas1")
	public String defcas1;
	
	@JSONName(name = "defcas2")
	public String defcas2;
	
	@JSONName(name = "city_id")
	public int cityId;
	
	@JSONName(name = "infra_destroyed")
	public float infraDed;
	
	@JSONName(name = "improvements_destroyed")
	public int improveded;
	
	@JSONName(name = "money_looted")
	public double moneyLooted;
	
	@JSONName(name = "note")
	public String note;
	
	@JSONName(name = "city_infra_before")
	public float infrabefore;
	
	@JSONName(name = "infra_destroyed_value")
	public double infradedVal;
	
	@JSONName(name = "att_gas_used")
	public float attGasUsed;
	
	@JSONName(name = "att_mun_used")
	public float attMunUsed;
	
	@JSONName(name = "def_gas_used")
	public float defGasUsed;
	
	@JSONName(name = "def_mun_used")
	public float defMunUsed;

	@Override
	public long getID() {
		return attackid;
	}
	
}
