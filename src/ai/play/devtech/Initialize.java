package ai.play.devtech;

import com.google.gson.GsonBuilder;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.api.APIAggregatorBuilder;
import ai.play.devtech.core.api.objects.NationExcerpt;
import ai.play.devtech.core.api.queries.NationsQuery;

public class Initialize {
	
	public static void main(String[] args) {
		APIAggregatorBuilder builder = new APIAggregatorBuilder();
		builder.setCacheSize(500);
		builder.setKey("");
		APIAggregator aggregator = builder.build();
		NationExcerpt[] a = aggregator.getNations(new NationsQuery());
		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(a));
	}

	private Initialize() {
		
	}
	
}