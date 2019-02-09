package main.java.ai.play.devtech.core.hooks.newj;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.objects.WarAttack;
import main.java.ai.play.devtech.core.api.queries.WarAttacksQuery;
import main.java.ai.play.devtech.core.hooks.ArrayHook;

/**
 * Will try to automatically kill itself if the war ends by running the provided "killme" runnable
 * @author devan
 *
 */
public class AttackHook extends ArrayHook<WarAttack> {
	/**
	 * @param agg
	 * 		The api it needs to run itself
	 * @param warid
	 * 		The war id
	 * @param killme
	 * 		The runnable that will be run when the war is over, (so you can kill the thread this object is using)
	 */
	public AttackHook(APIAggregator agg, int warid, Runnable killme) {
		super(() -> {
			WarAttack[] attacks = agg.getAttacks(new WarAttacksQuery().setID(warid));
			if(agg.getWar(attacks[0].warId).warEnded)
				killme.run();
			return attacks;
		}, (w1, w2) -> w1.warId == w2.warId, false);
	}
	
}
