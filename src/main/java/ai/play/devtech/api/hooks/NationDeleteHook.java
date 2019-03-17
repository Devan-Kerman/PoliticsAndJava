package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.api.objects.NationExcerpt;

/**
 * Triggers listeners when a nation is deleted
 *
 * @author devan
 */
public class NationDeleteHook extends ArrayHook<NationExcerpt> {

	public NationDeleteHook(APIAggregator agg) {
		super(agg::getAllNations, (i, i2) -> i.nationid == i2.nationid, true);
	}

}
