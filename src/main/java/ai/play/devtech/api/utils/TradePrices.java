package ai.play.devtech.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.core.api.tradeprice.TradePrice;
import ai.play.devtech.core.enums.Resource;

public class TradePrices {
	public static List<TradePrice> listPrices(APIAggregator agg, ExecutorService serv) {
		List<Future<TradePrice>> trades = new ArrayList<>(11);
		trades.add(serv.submit(agg::getCoal));
		trades.add(serv.submit(agg::getOil));
		trades.add(serv.submit(agg::getIron));
		trades.add(serv.submit(agg::getUranium));
		trades.add(serv.submit(agg::getBauxite));
		trades.add(serv.submit(agg::getLead));
		trades.add(serv.submit(agg::getGasoline));
		trades.add(serv.submit(agg::getMunitions));
		trades.add(serv.submit(agg::getSteel));
		trades.add(serv.submit(agg::getAluminum));
		trades.add(serv.submit(agg::getCredits));
		return trades.stream().map(t -> {
			try {
				return t.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}
	
	public TradePrice[] arrayPrices(APIAggregator agg, ExecutorService serv) {
		return listPrices(agg, serv).toArray(new TradePrice[0]);
	}
	
	public Map<Resource, TradePrice> mappedPrices(APIAggregator agg, ExecutorService serv) {
		return stream(agg, serv).collect(Collectors.toMap(t -> t.resource, t -> t));
	}
	
	public static Stream<TradePrice> stream(APIAggregator agg, ExecutorService serv) {
		return listPrices(agg, serv).stream();
	}
}
