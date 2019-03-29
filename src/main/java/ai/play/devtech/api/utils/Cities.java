package ai.play.devtech.api.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.core.api.CityExcerpt;

public class Cities {
	
	public static List<CityExcerpt> getCities(APIAggregator agg) {
		return Arrays.asList(agg.getCities());
	}
	
	public static Stream<CityExcerpt> stream(APIAggregator agg) {
		return Arrays.stream(agg.getCities());
	}
	
}
