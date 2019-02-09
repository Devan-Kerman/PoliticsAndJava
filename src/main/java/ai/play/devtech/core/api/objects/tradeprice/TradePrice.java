package main.java.ai.play.devtech.core.api.objects.tradeprice;

import main.java.ai.play.devtech.APIObject;
import main.java.ai.play.devtech.core.api.enums.Resource;
import main.java.ai.play.devtech.core.objects.manipulation.JSONName;

public class TradePrice extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "resource")
	public Resource resource;
	
	@JSONName(name = "avgprice")
	public float avgprice;
	
	@JSONName(name = "marketindex")
	public String marketindex;
	
	@JSONName(name = "highestbuy")
	public HighestBuy bestSell;
	
	@JSONName(name = "lowestbuy")
	public LowestBuy bestBuy;

	@Override
	public long getID() {
		return resource.ordinal();
	}

}
