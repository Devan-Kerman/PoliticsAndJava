package main.java.ai.play.devtech.core.web.objects;


import main.java.ai.play.devtech.core.web.enums.BountyTypes;
import main.java.ai.play.devtech.util.strings.ToString;

public class Bounty {

	BountyTypes type;
	double bounty;
	public Bounty() {
		type = BountyTypes.ORDINARY;
		bounty = 0;
	}
	
	public Bounty(BountyTypes type, double bounty) {
		this.type = type;
		this.bounty = bounty;
	}
	
	@Override
	public String toString() {
		return ToString.toJson(this);
	}

}
