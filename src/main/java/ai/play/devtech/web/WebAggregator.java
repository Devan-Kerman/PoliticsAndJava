package ai.play.devtech.web;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ai.play.devtech.core.enums.BountyTypes;
import ai.play.devtech.core.enums.Colors;
import ai.play.devtech.core.enums.Continents;
import ai.play.devtech.core.objects.lists.ListUtils;
import ai.play.devtech.core.web.Bounty;
import ai.play.devtech.core.web.ColorVal;
import ai.play.devtech.core.web.Radiation;

/**
 * An api aggregator, but for the politics and war website (webscraper)
 *
 * @author devan
 */
public class WebAggregator {
	WebCache cache;

	public WebAggregator() {
		cache = new WebCache();
	}

	public ColorVal[] getColors() {
		return cache.<ColorVal[]>request("https://politicsandwar.com/leaderboards/display=color", doc -> {
			List<ColorVal> colors = new LinkedList<>();
			for (int x = 2; x < 18; x++)
				colors.add(new ColorVal(Colors.valueOf(doc.select(String.format("#rightcolumn > table > tbody > tr:nth-child(%d) > td.center > img", x)).first().attr("title").toUpperCase()), Float.parseFloat(doc.select(String.format("#rightcolumn > table > tbody > tr:nth-child(%d) > td:nth-child(6)", x)).first().html().replaceAll("[^0-9.]", "").trim())));
			return ListUtils.listToArray(colors, ColorVal.class);
		});
	}
	
	public Map<Colors, ColorVal> getMappedColors() {
		return cache.<Map<Colors, ColorVal>>request("https://politicsandwar.com/leaderboards/display=color", doc -> {
			Map<Colors, ColorVal> colors = new EnumMap<>(Colors.class);
			for (int x = 2; x < 18; x++) {
				Colors color = Colors.valueOf(doc.select(String.format("#rightcolumn > table > tbody > tr:nth-child(%d) > td.center > img", x)).first().attr("title").toUpperCase());
				colors.put(color, new ColorVal(color, Float.parseFloat(doc.select(String.format("#rightcolumn > table > tbody > tr:nth-child(%d) > td:nth-child(6)", x)).first().html().replaceAll("[^0-9.]", "").trim())));
			}
			return colors;
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
	
	public Radiation[] getRadiation() {
		return cache.<Radiation[]>request("https://politicsandwar.com/world/radiation/", doc -> {
			Radiation[] arr = new Radiation[8];
			Elements e = doc.getElementById("rightcolumn").getElementsByClass("col-xs-12");
			int index = 0;
			arr[index] = parseRad(e, Continents.GLOBAL, index++, 0);
			arr[index] = parseRad(e, Continents.NORTH_AMERICA, index++, arr[0].value);
			arr[index] = parseRad(e, Continents.SOUTH_AMERICA, index++, arr[0].value);
			arr[index] = parseRad(e, Continents.EUROPE, index++, arr[0].value);
			arr[index] = parseRad(e, Continents.ASIA, index++, arr[0].value);
			arr[index] = parseRad(e, Continents.AFRICA, index++, arr[0].value);
			arr[index] = parseRad(e, Continents.AUSTRALIA, index++, arr[0].value);
			arr[index] = parseRad(e, Continents.ANTARCTICA, index++, arr[0].value);
			return arr;
		});
	}
	
	public Map<Continents, Radiation> getMappedRadiation() {
		return cache.<Map<Continents,Radiation>>request("https://politicsandwar.com/world/radiation/", doc -> {
			Map<Continents,Radiation> map = new EnumMap<>(Continents.class);
			Elements e = doc.getElementById("rightcolumn").getElementsByClass("col-xs-12");
			int index = 0;
			map.put(Continents.GLOBAL, parseRad(e, Continents.GLOBAL, index++, 0));
			map.put(Continents.NORTH_AMERICA, parseRad(e, Continents.NORTH_AMERICA, index++, map.get(Continents.GLOBAL).value));
			map.put(Continents.SOUTH_AMERICA, parseRad(e, Continents.SOUTH_AMERICA, index++, map.get(Continents.GLOBAL).value));
			map.put(Continents.EUROPE, parseRad(e, Continents.EUROPE, index++, map.get(Continents.GLOBAL).value));
			map.put(Continents.ASIA, parseRad(e, Continents.ASIA, index++, map.get(Continents.GLOBAL).value));
			map.put(Continents.AFRICA, parseRad(e, Continents.AFRICA, index++, map.get(Continents.GLOBAL).value));
			map.put(Continents.AUSTRALIA, parseRad(e, Continents.AUSTRALIA, index++, map.get(Continents.GLOBAL).value));
			map.put(Continents.ANTARCTICA, parseRad(e, Continents.ANTARCTICA, index++, map.get(Continents.GLOBAL).value));
			return map;
		});
	}
	
	private static Radiation parseRad(Elements e, Continents cont, int index, float global) {
		return new Radiation(cont, Float.parseFloat(e.get(index).child(1).text()), global);
	}
}
