package ai.play.devtech.api.queries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Used to query to the nations api
 *
 * @author devan
 */
public class NationsQuery {

	Map<String, String> query;

	public NationsQuery() {
		query = new HashMap<>();
	}

	public NationsQuery includeVM(boolean inclde) { // 17
		query.put("vm", String.valueOf(inclde));
		return this;
	}
	
	public NationsQuery minScore(float score) {
		query.put("min_score", String.valueOf(score));
		return this;
	}

	public NationsQuery maxScore(float score) {
		query.put("max_score", String.valueOf(score));
		return this;
	}

	public NationsQuery alliance(int aaid) {
		query.put("alliance_id", String.valueOf(aaid));
		return this;
	}

	public List<String> build() {
		return query.entrySet().stream().map(e -> e.getKey()+"="+e.getValue()).collect(Collectors.toList());
	}
}
