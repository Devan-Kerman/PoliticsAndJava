package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.core.api.NationExcerpt;

/**
 * An instance of this class will trigger all of it's listeners when a new nation joins the game, make sure to put this in a thread/timer of your choice
 *
 * @author devan
 */
public class GameJoinHook extends ArrayHook<NationExcerpt> {

	/**
	 * @param agg The api aggregator needed to run the hook
	 */
	public GameJoinHook(APIAggregator agg) {
		super(agg::getAllNations, (i, i2) -> i.nationid == i2.nationid, false);
	}

}
