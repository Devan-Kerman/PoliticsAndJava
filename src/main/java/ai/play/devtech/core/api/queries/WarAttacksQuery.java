package ai.play.devtech.core.api.queries;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to query the war attacks api
 *
 * @author devan
 */
public class WarAttacksQuery {

	Map<String, String> query;

	public WarAttacksQuery() {
		query = new HashMap<>();
	}

	public WarAttacksQuery minWarID(int score) {
		query.put("min_war_attack_id", String.valueOf(score));
		return this;
	}

	public WarAttacksQuery maxWarID(int score) {
		query.put("max_war_attack_id", String.valueOf(score));
		return this;
	}

	/**
	 * Takes precedence over {@link WarAttacksQuery#minWarID(int)} and {@link WarAttacksQuery#maxWarID(int)}
	 *
	 * @param score
	 * @return
	 */
	public WarAttacksQuery setID(int score) {
		query.put("war_id", String.valueOf(score));
		return this;
	}

	public String build(String key) {
		if (query.size() == 0) return "";
		else if (!query.containsKey("war_id")) {
			StringBuilder add = new StringBuilder();
			query.forEach((k, v) -> add.append(k + '=' + v + '&'));
			add.delete(add.length() - 1, add.length());
			return add.toString();
		} else {
			return "war_id=" + query.get("war_id");
		}
	}

}
