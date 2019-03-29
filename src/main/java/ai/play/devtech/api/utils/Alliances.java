package ai.play.devtech.api.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ai.play.devtech.api.APIAggregator;
import ai.play.devtech.core.api.AllianceExcerpt;

public class Alliances {
	public static Set<AllianceExcerpt> getAllianceSet(APIAggregator agg) {
		return new HashSet<>(Arrays.asList(agg.getAlliances()));
	}

	public static Stream<AllianceExcerpt> stream(APIAggregator agg) {
		return Arrays.stream(agg.getAlliances());
	}
	
	public static void forEach(APIAggregator agg, Consumer<AllianceExcerpt> consumer) {
		stream(agg).forEach(consumer);
	}
	
	public static List<AllianceExcerpt> asList(APIAggregator agg) {
		return stream(agg).collect(Collectors.toList());
	}
	
	public static Map<Integer, AllianceExcerpt> getIDMap(APIAggregator agg) {
		return stream(agg).collect(Collectors.toMap(a -> a.allianceid, a -> a));
	}

}
