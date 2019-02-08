package ai.play.devtech.core.api.objects.tradeprice;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Resource;
import ai.play.devtech.core.objects.JSONName;

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

}
