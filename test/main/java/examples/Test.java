package examples;

import java.time.temporal.ChronoUnit;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.hooks.GameJoinHook;

public class Test {
	public static void main(String[] args) {
		GameJoinHook gjh = new GameJoinHook(new APIAggregator("aduawidan", ChronoUnit.NANOS, 0));
		gjh.addListener("lmao goteem", n -> {
			System.out.println("New player: " + n.nationid);
		});
		while (true)
			gjh.run();
	}
}
