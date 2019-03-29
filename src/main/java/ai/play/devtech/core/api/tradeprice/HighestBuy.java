package ai.play.devtech.core.api.tradeprice;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.util.Date;

/**
 * The best price to sell at
 *
 * @author devan
 */
public class HighestBuy extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * The time this was found
	 */
	@DataName (name = "date")
	public Date date;

	/**
	 * The buyers nation's id
	 */
	@DataName (name = "nationid")
	public int nid;

	/**
	 * The amount of the resource being sold
	 */
	@DataName (name = "amount")
	public float amount;

	/**
	 * The value at which the resource is selling
	 */
	@DataName (name = "price")
	public float price;

	/**
	 * The total value (amont*price)
	 */
	@DataName (name = "totalvalue")
	public float totalval;

	@Override
	public long getID() {
		return nid;
	}

}
