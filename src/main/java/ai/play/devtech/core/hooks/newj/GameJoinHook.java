package ai.play.devtech.core.hooks.newj;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.objects.NationExcerpt;
import ai.play.devtech.core.hooks.ArrayHook;

/**
 * An instance of this class will trigger all of it's listeners when a new nation joins the game, make sure to put this in a thread/timer of your choice
 * @author devan
 *
 */
public class GameJoinHook extends ArrayHook<NationExcerpt> {
	
	/**
	 * @param agg
	 * 		The api aggregator needed to run the hook
	 */
	public GameJoinHook(APIAggregator agg) {
		super(agg::getAllNations, (i, i2) -> i.nationid == i2.nationid, true);
	}
	
}
