package ai.play.devtech.core.hooks;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.objects.tradeprice.TradePrice;

public class TradeHook extends VarietyHook<TradePrice> {

	public TradeHook(APIAggregator agg) {
		super(
			agg::getCoal, agg::getOil, agg::getUranium,
			agg::getIron, agg::getBauxite, agg::getLead,
			agg::getSteel, agg::getMunitions, agg::getGasoline,
			agg::getAluminum, agg::getCredits
		);
	}

}
