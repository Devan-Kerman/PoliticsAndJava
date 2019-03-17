package ai.play.devtech.api.objects.tradeprice;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.objects.manipulation.DataName;
import com.google.common.base.MoreObjects;
import java.util.Date;

/**
 * The best price to buy at
 *
 * @author devan
 */
public class LowestBuy extends APIObject {
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
	public String toString() {
		return MoreObjects.toStringHelper(this).add("date", date).add("nationid", nid).add("amount", amount).add("price", price).add("totalval", totalval).toString();
	}

	@Override
	public long getID() {
		return nid;
	}
}
