package ai.play.devtech.core.hooks.newj;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.objects.WarExcerpt;
import ai.play.devtech.core.hooks.ArrayHook;

public class WarDecHook extends ArrayHook<WarExcerpt> {

	public WarDecHook(APIAggregator agg) {
		super(agg::getWars, (w, w2) -> w.wid == w2.wid, false);
	}

	public WarDecHook(APIAggregator agg, int... aaid) {
		super(() -> agg.getWars(5000, aaid), (w, w2) -> w.wid == w2.wid, false);
	}

	public WarDecHook(APIAggregator agg, int limit, int... aaid) {
		super(() -> agg.getWars(limit, aaid), (w, w2) -> w.wid == w2.wid, false);
	}

}
