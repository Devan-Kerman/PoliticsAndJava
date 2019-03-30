package ai.play.devtech.core.api.tradeprice;

import java.util.Date;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.objects.manipulation.DataName;
import ai.play.devtech.core.util.s.Strings;

/**
 * The best price to buy at
 *
 * @author devan
 */
public class LowestBuy extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * When this trade offer was made
	 */
	@DataName (name = "date")
	public Date date;

	/**
	 * Offerer's nation ID
	 */
	@DataName (name = "nationid")
	public int nid;

	/**
	 * The amount of the resource they are selling
	 */
	@DataName (name = "amount")
	public float amount;

	/**
	 * The price atwhich they are selling it
	 */
	@DataName (name = "price")
	public float price;

	/**
	 * The total value (price*amount)
	 */
	@DataName (name = "totalvalue")
	public float totalval;

	@Override
	public String toString() {
		return Strings.toJson(this);
	}

	@Override
	public long getID() {
		return nid;
	}
}
