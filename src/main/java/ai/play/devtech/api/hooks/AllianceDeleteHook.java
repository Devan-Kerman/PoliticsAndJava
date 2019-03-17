package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.api.objects.AllianceExcerpt;

/**
 * Triggers all listeners when an alliance is deleted
 *
 * @author devan
 */
public class AllianceDeleteHook extends ArrayHook<AllianceExcerpt> {

	public AllianceDeleteHook(APIAggregator agg) {
		super(agg::getAlliances, (a, a2) -> a.aaid == a2.aaid, true);
	}

}
