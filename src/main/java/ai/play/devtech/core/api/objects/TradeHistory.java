package ai.play.devtech.core.api.objects;

import java.util.Date;

import ai.play.devtech.APIObject;
import ai.play.devtech.core.api.enums.Resource;
import ai.play.devtech.core.api.enums.TradeOfferType;
import ai.play.devtech.core.objects.manipulation.DataName;

public class TradeHistory extends APIObject {
	private static final long serialVersionUID = 1L;

	@DataName(name = "cityids")
	public int[] cityids;
	
	@DataName(name = "date")
	public Date date;
	
	@DataName(name = "offerer_nation_id")
	public int offeringnid;
	
	@DataName(name = "accepter_nation_id")
	public int acceptornid;
	
	@DataName(name = "resource")
	public Resource resource;
	
	@DataName(name = "offer_type")
	public TradeOfferType type;
	
	@DataName(name = "quantity")
	public float quantity;
	
	@DataName(name = "price")
	public float price;

	@Override
	public long getID() {
		return (long)acceptornid << 32 | offeringnid & 0xFFFFFFFFL;
	}

}
