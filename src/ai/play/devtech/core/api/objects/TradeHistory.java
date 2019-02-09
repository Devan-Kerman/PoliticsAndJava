package ai.play.devtech.core.api.objects;

import java.util.Date;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Resource;
import ai.play.devtech.core.api.enums.TradeOfferType;
import ai.play.devtech.core.objects.manipulation.JSONName;
import ai.play.devtech.util.math.CastMath;

public class TradeHistory extends APIObject {
	private static final long serialVersionUID = 1L;

	@JSONName(name = "cityids")
	public int[] cityids;
	
	@JSONName(name = "date")
	public Date date;
	
	@JSONName(name = "offerer_nation_id")
	public int offeringnid;
	
	@JSONName(name = "accepter_nation_id")
	public int acceptornid;
	
	@JSONName(name = "resource")
	public Resource resource;
	
	@JSONName(name = "offer_type")
	public TradeOfferType type;
	
	@JSONName(name = "quantity")
	public float quantity;
	
	@JSONName(name = "price")
	public float price;

	@Override
	public long getID() {
		return CastMath.twoIntsToLong(offeringnid, acceptornid);
	}

}
