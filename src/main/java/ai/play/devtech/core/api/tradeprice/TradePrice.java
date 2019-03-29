package ai.play.devtech.core.api.tradeprice;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.Resource;
import ai.play.devtech.core.objects.manipulation.DataName;

/**
 * Current market for a resource
 *
 * @author devan
 */
public class TradePrice extends APIObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Resource that is being traded
	 */
	@DataName (name = "resource")
	public Resource resource;

	/**
	 * Average price
	 */
	@DataName (name = "avgprice")
	public float avgprice;

	/**
	 * The market index (idk what this means)
	 */
	@DataName (name = "marketindex")
	public String marketindex;

	/**
	 * The best price to sell at
	 */
	@DataName (name = "highestbuy")
	public HighestBuy bestSell;

	/**
	 * The best price to buy at
	 */
	@DataName (name = "lowestbuy")
	public LowestBuy bestBuy;

	@Override
	public long getID() {
		return resource.ordinal();
	}

}
