package ai.play.devtech.core.hooks.gon;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.objects.NationExcerpt;
import ai.play.devtech.core.hooks.ArrayHook;

public class NationDeleteHook extends ArrayHook<NationExcerpt> {

	public NationDeleteHook(APIAggregator agg) {
		super(agg::getAllNations, (i, i2) -> i.nationid == i2.nationid, true);
	}

}
