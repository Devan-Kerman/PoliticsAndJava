package ai.play.devtech.core.web;


import java.io.Closeable;
import java.util.LinkedList;
import java.util.List;

import ai.play.devtech.DLogger;
import ai.play.devtech.core.api.enums.Colors;
import ai.play.devtech.core.objects.lists.ListUtils;
import ai.play.devtech.core.web.objects.ColorVal;
import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;

public class WebAggregator implements Closeable, AutoCloseable{
	BrowserEngine browser;
	WebCache cache;
	public WebAggregator() {
		browser = BrowserFactory.getWebKit();
		cache = new WebCache();
	}
	
	public ColorVal[] getColors() {
		return cache.<ColorVal[]>request("https://politicsandwar.com/leaderboards/display=color", doc -> {
			List<ColorVal> colors = new LinkedList<>();
			for(int x = 2; x < 18; x++)
				colors.add(new ColorVal(Colors.valueOf(doc.select(String.format("#rightcolumn > table > tbody > tr:nth-child(%d) > td.center > img", x)).first().attr("title").toUpperCase()), Float.parseFloat(doc.select(String.format("#rightcolumn > table > tbody > tr:nth-child(%d) > td:nth-child(6)", x)).first().html().replaceAll("[^0-9.]", "").trim())));
			return ListUtils.listToArray(colors, ColorVal.class);
		});
	}
	
	

	public static void main(String[] args) {
		WebAggregator wagg = new WebAggregator();
		ColorVal[] vals = wagg.getColors();
		for(ColorVal cv : vals)
			wagg.getColors();
		wagg.close();
	}

	@Override
	public void close() {
		browser.shutdown();
	}
	
	
	
}
