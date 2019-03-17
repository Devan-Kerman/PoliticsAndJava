package ai.play.devtech.core.hooks;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.objects.NationExcerpt;
import java.util.Arrays;
import java.util.List;

/**
 * Triggers all listeners when a nations joins an alliance
 *
 * @author devan
 */
public class AllianceJoinHook extends ListHook<NationExcerpt> {

	public AllianceJoinHook(APIAggregator agg) {
		super(() -> {
			List<NationExcerpt> ex = Arrays.asList(agg.getAllNations());
			ex.forEach(n -> doNothing(n.aaid == 0 ? ex.remove(n) : null));
			return ex;
		}, (n1, n2) -> n1.nationid == n2.nationid, false);
	}

	public static void doNothing(Object o) {/*This litterally does nothing, it's for lambdas and shit*/}

}
