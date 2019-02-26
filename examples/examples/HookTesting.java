package examples;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

import ai.play.devtech.core.api.APIAggregator;
import ai.play.devtech.core.hooks.newj.GameJoinHook;

public class HookTesting {
	public static void main(String[] args) {
		APIAggregator agg = new APIAggregator("null", ChronoUnit.SECONDS, 1);
		GameJoinHook gjh = new GameJoinHook(agg);
		gjh.addListener("new", n -> System.out.printf("New player: %d", n.nid));
		Timer timer = new Timer();
		timer.schedule(gjh, 0, 60000);
	}
	
	static Integer[] array = new Integer[100];
	static {
		Arrays.fill(array, 0);
	}
	static Random ra = new Random();
	public static Integer[] modify() {
		Integer[] ar = Arrays.copyOf(array, 100);
		int r = Math.abs(ra.nextInt(100));
		ar[r] = ra.nextInt();
		array = ar;
		return ar;
	}
}
