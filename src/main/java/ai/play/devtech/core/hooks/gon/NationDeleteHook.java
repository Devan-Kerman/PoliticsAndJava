package main.java.ai.play.devtech.core.hooks.gon;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.objects.NationExcerpt;
import main.java.ai.play.devtech.core.hooks.ArrayHook;

public class NationDeleteHook extends ArrayHook<NationExcerpt> {

	public NationDeleteHook(APIAggregator agg) {
		super(agg::getAllNations, (i, i2) -> i.nid == i2.nid, true);
	}

}
