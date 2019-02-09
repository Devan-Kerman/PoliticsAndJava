package main.java.ai.play.devtech.core.hooks.newj;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.objects.AllianceExcerpt;
import main.java.ai.play.devtech.core.hooks.ArrayHook;

/**
 * This class will trigger all of it's listeners when a new alliance is created
 * @author devan
 *
 */
public class AllianceCreateHook extends ArrayHook<AllianceExcerpt> {
	public AllianceCreateHook(APIAggregator agg) {
		super(agg::getAlliances, (a, a2) -> a.aaid == a2.aaid,false);
	}
}
