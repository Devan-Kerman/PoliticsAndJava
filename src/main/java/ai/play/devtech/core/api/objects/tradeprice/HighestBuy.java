package ai.play.devtech.core.api.objects.tradeprice;

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

	@DataName (name = "date")
	public Date date;

	@DataName (name = "nationid")
	public int nid;

	@DataName (name = "amount")
	public float amount;

	@DataName (name = "price")
	public float price;

	@DataName (name = "totalvalue")
	public float totalval;

	@Override
	public long getID() {
		return nid;
	}

}
