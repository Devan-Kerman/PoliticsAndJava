package main.java.ai.play.devtech.core.web;

import java.io.Closeable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Element;

import main.java.ai.play.devtech.DLogger;
import main.java.ai.play.devtech.core.api.enums.Colors;
import main.java.ai.play.devtech.core.objects.lists.ListUtils;
import main.java.ai.play.devtech.core.web.enums.BountyTypes;
import main.java.ai.play.devtech.core.web.objects.Bounty;
import main.java.ai.play.devtech.core.web.objects.ColorVal;
import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;

public class WebAggregator implements Closeable, AutoCloseable {
	BrowserEngine browser;
	WebCache cache;

	public WebAggregator() {
		browser = BrowserFactory.getWebKit();
		cache = new WebCache();
	}

	public ColorVal[] getColors() {
		return cache.<ColorVal[]>request("https://politicsandwar.com/leaderboards/display=color", doc -> {
			List<ColorVal> colors = new LinkedList<>();
			for (int x = 2; x < 18; x++)
				colors.add(
						new ColorVal(
								Colors.valueOf(doc
										.select(String.format(
												"#rightcolumn > table > tbody > tr:nth-child(%d) > td.center > img", x))
										.first().attr("title").toUpperCase()),
								Float.parseFloat(doc
										.select(String.format(
												"#rightcolumn > table > tbody > tr:nth-child(%d) > td:nth-child(6)", x))
										.first().html().replaceAll("[^0-9.]", "").trim())));
			return ListUtils.listToArray(colors, ColorVal.class);
		});
	}

	public Bounty[] getBounties(int nid) {
		return cache.<Bounty[]>request("https://politicsandwar.com/nation/id=" + nid, doc -> {
			List<Bounty> bounties = new LinkedList<>();
			doc.select("td[title=\"Bounty Type\"]").forEach(e -> {
				Element parent = e.parent();
				BountyTypes type = BountyTypes.getByString(parent.child(0).html());
				double money = Double.parseDouble(parent.child(1).html().replaceAll("[^0-9.]", "").trim());
				bounties.add(new Bounty(type, money));
			});
			return ListUtils.listToArray(bounties, Bounty.class);
		});
	}

	public static void main(String[] args) {
		WebAggregator wagg = new WebAggregator();
		DLogger.debug(Arrays.toString(wagg.getBounties(6563)));
		wagg.close();
	}

	@Override
	public void close() {
		browser.shutdown();
	}

}