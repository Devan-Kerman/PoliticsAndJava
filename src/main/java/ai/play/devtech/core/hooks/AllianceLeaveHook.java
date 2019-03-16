package ai.play.devtech.core.hooks;

import java.util.Arrays;
import java.util.List;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.objects.NationExcerpt;

public class AllianceLeaveHook extends ListHook<NationExcerpt> {

	public AllianceLeaveHook(APIAggregator agg) {
		super(() -> {
			List<NationExcerpt> ex = Arrays.asList(agg.getAllNations());
			ex.forEach(n -> doNothing(n.aaid==0?ex.remove(n):null));
			return ex;
		}, (n1, n2) -> n1.nationid == n2.nationid, true);
	}
	
	public static void doNothing(Object o) {/*This litterally does nothing, it's for lambdas and shit*/}

}
