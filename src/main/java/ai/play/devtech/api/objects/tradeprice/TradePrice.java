package ai.play.devtech.api.objects.tradeprice;

import ai.play.devtech.APIObject;
import ai.play.devtech.api.enums.Resource;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * Current market for a resource
 *
 * @author devan
 */
public class TradePrice extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "resource")
	public Resource resource;

	@DataName (name = "avgprice")
	public float avgprice;

	@DataName (name = "marketindex")
	public String marketindex;

	@DataName (name = "highestbuy")
	public HighestBuy bestSell;

	@DataName (name = "lowestbuy")
	public LowestBuy bestBuy;

	@Override
	public long getID() {
		return resource.ordinal();
	}

}
