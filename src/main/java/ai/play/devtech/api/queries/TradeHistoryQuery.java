package ai.play.devtech.api.queries;

import ai.play.devtech.core.enums.Resource;

/**
 * Used to query the trade history api
 *
 * @author devan
 */
public class TradeHistoryQuery {
	int records = 1000;

	public TradeHistoryQuery records(int records) {
		this.records = records;
		return this;
	}

	String resources = "&resources=";

	public TradeHistoryQuery addResource(Resource resource) {
		resources += resource.name().toLowerCase() + ',';
		return this;
	}

	public static final String BASE = "records=%d";

	public String build() {
		StringBuilder add = new StringBuilder(String.format(BASE, records));
		if (resources.length() != "&resources=".length()) add.append(resources);
		return add.toString();
	}

}
