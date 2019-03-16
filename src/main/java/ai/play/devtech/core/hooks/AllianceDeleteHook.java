package ai.play.devtech.core.hooks;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.objects.AllianceExcerpt;

public class AllianceDeleteHook extends ArrayHook<AllianceExcerpt> {

	public AllianceDeleteHook(APIAggregator agg) {
		super(agg::getAlliances, (a, a2) -> a.aaid == a2.aaid, false);
	}

}
