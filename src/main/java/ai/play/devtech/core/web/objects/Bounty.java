package ai.play.devtech.core.web.objects;


import ai.play.devtech.core.web.enums.BountyTypes;
import ai.play.devtech.util.strings.ToString;

/**
 * An ingame bounty
 *
 * @author devan
 */
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
