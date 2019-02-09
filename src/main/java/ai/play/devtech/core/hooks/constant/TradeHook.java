package main.java.ai.play.devtech.core.hooks.constant;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.objects.tradeprice.TradePrice;
import main.java.ai.play.devtech.core.hooks.VarietyHook;

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