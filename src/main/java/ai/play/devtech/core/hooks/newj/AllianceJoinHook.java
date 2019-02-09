package main.java.ai.play.devtech.core.hooks.newj;

import java.util.Arrays;
import java.util.List;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.objects.NationExcerpt;
import main.java.ai.play.devtech.core.hooks.ListHook;

public class AllianceJoinHook extends ListHook<NationExcerpt> {

	public AllianceJoinHook(APIAggregator agg) {
		super(() -> {
			List<NationExcerpt> ex = Arrays.asList(agg.getAllNations());
			ex.forEach(n -> doNothing(n.aaid==0?ex.remove(n):null));
			return ex;
		}, (n1, n2) -> n1.nid == n2.nid, false);
	}
	
	public static void doNothing(Object o) {/*This litterally does nothing, it's for lambdas and shit*/}

}