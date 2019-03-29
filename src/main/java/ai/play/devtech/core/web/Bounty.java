package ai.play.devtech.core.web;


import java.io.Serializable;

import ai.play.devtech.core.enums.BountyTypes;
import ai.play.devtech.core.util.strings.ToString;

/**
 * An ingame bounty
 *
 * @author devan
 */
public class Bounty  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
