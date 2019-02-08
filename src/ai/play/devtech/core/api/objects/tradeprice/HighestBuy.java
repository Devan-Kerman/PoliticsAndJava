package ai.play.devtech.core.api.objects.tradeprice;

import java.util.Date;

import com.google.common.base.MoreObjects;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.objects.JSONName;

public class HighestBuy extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "date")
	public Date date;
	
	@JSONName(name = "nationid")
	public int nationid;
	
	@JSONName(name = "amount")
	public float amount;
	
	@JSONName(name = "price")
	public float price;
	
	@JSONName(name = "totalvalue")
	public float totalval;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("date", date)
				.add("nationid", nationid)
				.add("amount", amount)
				.add("price", price)
				.add("totalval", totalval).toString();
	}

}
