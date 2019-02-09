package main.java.ai.play.devtech.core.hooks.gon;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.objects.AllianceExcerpt;
import main.java.ai.play.devtech.core.hooks.ArrayHook;

public class AllianceDeleteHook extends ArrayHook<AllianceExcerpt> {

	public AllianceDeleteHook(APIAggregator agg) {
		super(agg::getAlliances, (a, a2) -> a.aaid == a2.aaid, true);
	}

}
