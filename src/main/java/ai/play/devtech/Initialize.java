package main.java.ai.play.devtech;

import com.google.gson.GsonBuilder;

import main.java.ai.play.devtech.core.api.APIAggregator;
import main.java.ai.play.devtech.core.api.APIAggregatorBuilder;
import main.java.ai.play.devtech.core.api.objects.NationExcerpt;
import main.java.ai.play.devtech.core.api.queries.NationsQuery;

public class Initialize {
	
	public static void main(String[] args) {
		APIAggregatorBuilder builder = new APIAggregatorBuilder();
		builder.setCacheSize(500);
		builder.setKey("testkey");
		APIAggregator aggregator = builder.build();
		NationExcerpt[] a = aggregator.getNations(new NationsQuery());
		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(a));
	}

	private Initialize() {
		
	}
	
}