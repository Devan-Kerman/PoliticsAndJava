package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.api.objects.WarAttack;

/**
 * Will try to automatically kill itself if the war ends by running the provided "killme" runnable
 *
 * @author devan
 */
public class AttackHook extends ArrayHook<WarAttack> {
	/**
	 * @param agg The api it needs to run itself
	 * @param warid The war id
	 * @param killme The runnable that will be run when the war is over, (so you can kill the thread this object is using)
	 */
	public AttackHook(APIAggregator agg, int warid, Runnable killme) {
		super(() -> {
			WarAttack[] attacks = agg.getAttacks(warid);
			if (agg.getWar(attacks[0].warId).warEnded) killme.run();
			return attacks;
		}, (w1, w2) -> w1.warId == w2.warId, false);
	}

}
