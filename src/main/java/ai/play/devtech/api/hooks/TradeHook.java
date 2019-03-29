package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.core.api.tradeprice.TradePrice;

/**
 * Triggers all listeners every time it's called with new trade info
 *
 * @author devan
 */
public class TradeHook extends VarietyHook<TradePrice> {

	public TradeHook(APIAggregator agg) {
		super(agg::getCoal, agg::getOil, agg::getUranium, agg::getIron, agg::getBauxite, agg::getLead, agg::getSteel, agg::getMunitions, agg::getGasoline, agg::getAluminum, agg::getCredits);
	}

}
