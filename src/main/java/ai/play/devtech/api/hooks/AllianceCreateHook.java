package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.api.objects.AllianceExcerpt;

/**
 * This class will trigger all of it's listeners when a new alliance is created
 *
 * @author devan
 */
public class AllianceCreateHook extends ArrayHook<AllianceExcerpt> {
	public AllianceCreateHook(APIAggregator agg) {
		super(agg::getAlliances, (a, a2) -> a.aaid == a2.aaid, false);
	}
}
