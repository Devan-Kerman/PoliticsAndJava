package ai.play.devtech.core.api;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.enums.Resource;
import ai.play.devtech.core.enums.TradeOfferType;
import ai.play.devtech.core.objects.manipulation.DataName;
import java.util.Date;

/**
 * An object representing a trade that happened between 2 nations
 *
 * @author devan
 */
public class TradeHistory extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName (name = "date")
	public Date date;

	@DataName (name = "offerer_nation_id")
	public int offeringnid;

	@DataName (name = "accepter_nation_id")
	public int acceptornid;

	@DataName (name = "resource")
	public Resource resource;

	@DataName (name = "offer_type")
	public TradeOfferType type;

	@DataName (name = "quantity")
	public float quantity;

	@DataName (name = "price")
	public float price;

	@Override
	public long getID() {
		return (long) acceptornid << 32 | offeringnid & 0xFFFFFFFFL;
	}

}
