package ai.play.devtech.core.api.queries;

import ai.play.devtech.core.api.enums.Resource;

public class TradeHistoryQuery {
	int records = 1000;
	public TradeHistoryQuery records(int records) {
		this.records = records;
		return this;
	}
	
	String resources = "&resources=";
	public TradeHistoryQuery addResource(Resource resource) {
		resources+=resource.name().toLowerCase()+',';
		return this;
	}
	public static final String BASE = "key=%s&records=%d";
	public String build(String key) {
		StringBuilder add = new StringBuilder(String.format(BASE, key, records));
		if(resources.length() != "&resources=".length())
			add.append(resources);
		return add.toString();
	}
	
}
