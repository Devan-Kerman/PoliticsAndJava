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
import ai.play.devtech.api.objects.NationExcerpt;
import ai.play.devtech.api.queries.NationsQuery;

public class Nations {

	/**
	 * Maps a
	 * 
	 * @param agg
	 * @return
	 */
	public static Map<Integer, NationExcerpt> getIDMap(APIAggregator agg) {
		return streamAll(agg).collect(Collectors.toMap(n -> n.nationid, n -> n));
	}

	/**
	 * Goes through all the nations provided by
	 * {@link APIAggregator#getAllNations()}
	 * 
	 * @param agg
	 * @param consumer
	 */
	public static void forEach(APIAggregator agg, Consumer<NationExcerpt> consumer) {
		for (NationExcerpt ne : agg.getAllNations())
			consumer.accept(ne);
	}

	/**
	 * gets a set of all the nations using {@link APIAggregator#getAllNations()}
	 * 
	 * @param agg
	 * @return
	 */
	public static Set<NationExcerpt> getNationSet(APIAggregator agg) {
		return new HashSet<>(Arrays.asList(agg.getAllNations()));
	}

	/**
	 * Filters nations api for those in an alliance, I would recommend just using
	 * the alliances api for this, unless you know that the nations api is already
	 * in cache
	 * 
	 * @param agg
	 * @param aaid
	 * @return
	 */
	public static List<NationExcerpt> getInAlliance(APIAggregator agg, int aaid) {
		return streamAll(agg).filter(n -> n.aaid == aaid).collect(Collectors.toList());
	}

	private Nations() {
		throw new UnsupportedOperationException("Utility class");
	}

	/**
	 * Returns a stream of all nations uses {@link APIAggregator#getAllNations()}
	 * 
	 * @param agg
	 * @return
	 */
	public static Stream<NationExcerpt> streamAll(APIAggregator agg) {
		return Arrays.stream(agg.getAllNations());
	}

	/**
	 * Returns a stream of nations that was retrieved from
	 * {@link APIAggregator#getNations(NationsQuery)}
	 * 
	 * @param agg
	 * @param query
	 * @return
	 */
	public static Stream<NationExcerpt> streamQueried(APIAggregator agg, NationsQuery query) {
		return Arrays.stream(agg.getNations(query));
	}
}
