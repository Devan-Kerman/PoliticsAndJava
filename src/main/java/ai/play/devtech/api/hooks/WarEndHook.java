package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.core.api.WarExcerpt;

/**
 * Triggers listeners when a war ends
 *
 * @author devan
 */
public class WarEndHook extends ArrayHook<WarExcerpt> {

	public WarEndHook(APIAggregator agg) {
		super(agg::getWars, (w, w2) -> w.wid == w2.wid, true);
	}

	public WarEndHook(APIAggregator agg, int... aaid) {
		super(() -> agg.getAAWars(aaid), (w, w2) -> w.wid == w2.wid, true);
	}

	public WarEndHook(APIAggregator agg, int limit, int... aaid) {
		super(() -> agg.getMaxAAWars(limit, aaid), (w, w2) -> w.wid == w2.wid, true);
	}

}
