package main.java.ai.play.devtech.core.api.objects.tradeprice;

import java.util.Date;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;

public class HighestBuy extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "date")
	public Date date;
	
	@JSONName(name = "nationid")
	public int nid;
	
	@JSONName(name = "amount")
	public float amount;
	
	@JSONName(name = "price")
	public float price;
	
	@JSONName(name = "totalvalue")
	public float totalval;

	@Override
	public long getID() {
		return nid;
	}

}
