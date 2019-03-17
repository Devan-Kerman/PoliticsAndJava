package ai.play.devtech.api.hooks;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.api.objects.NationExcerpt;
import java.util.Arrays;
import java.util.List;

/**
 * Triggers all listeners when a nation leaves an alliance
 *
 * @author devan
 */
public class AllianceLeaveHook extends ListHook<NationExcerpt> {

	public AllianceLeaveHook(APIAggregator agg) {
		super(() -> {
			List<NationExcerpt> ex = Arrays.asList(agg.getAllNations());
			ex.forEach(n -> doNothing(n.aaid == 0 ? ex.remove(n) : null));
			return ex;
		}, (n1, n2) -> n1.nationid == n2.nationid, true);
	}

	public static void doNothing(Object o) {/*This litterally does nothing, it's for lambdas and shit*/}

}
