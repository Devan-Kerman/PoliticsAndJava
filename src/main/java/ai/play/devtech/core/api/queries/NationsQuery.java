package main.java.ai.play.devtech.core.api.queries;

import java.util.HashMap;
import java.util.Map;

public class NationsQuery {

	Map<String, String> query;
	public NationsQuery() {
		query = new HashMap<>();
	}
	
	public NationsQuery includeVM(boolean inclde) {
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
	public String build() {
		if(query.size() == 0)
			return "";
		else {
			StringBuilder add = new StringBuilder();
			add.append('?');
			query.forEach((k, v) -> add.append(k+'='+v+"&"));
			add.delete(add.length()-1, add.length()-1);
			return add.toString();
		}
	}
}
