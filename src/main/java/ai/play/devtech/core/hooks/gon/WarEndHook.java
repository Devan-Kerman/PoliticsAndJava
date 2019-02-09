package main.java.ai.play.devtech.core.hooks.gon;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.objects.WarExcerpt;
import main.java.ai.play.devtech.core.hooks.ArrayHook;

public class WarEndHook extends ArrayHook<WarExcerpt> {

	public WarEndHook(APIAggregator agg) {
		super(agg::getWars, (w, w2) -> w.wid == w2.wid, true);
	}

	public WarEndHook(APIAggregator agg, int... aaid) {
		super(() -> agg.getWars(5000, aaid), (w, w2) -> w.wid == w2.wid, true);
	}

	public WarEndHook(APIAggregator agg, int limit, int... aaid) {
		super(() -> agg.getWars(limit, aaid), (w, w2) -> w.wid == w2.wid, true);
	}

}
