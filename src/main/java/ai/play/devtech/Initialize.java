package ai.play.devtech;

import java.util.Random;

import ai.play.devtech.core.hooks.ArrayHook;

public class Initialize {
	public static void main(String[] args) throws Exception {
		Integer[] intar = new Integer[100];
		ArrayHook<Integer> ints = new ArrayHook<>(() -> semiRand(intar), (a, b) -> a.equals(b), false);
		ints.addListener("gotemlool", System.out::println);
	}
	
	static final Random rand = new Random();
	public static Integer[] semiRand(Integer[] semi) {
		for(int x = 0; x < semi.length; x+=rand.nextInt((int)Math.sqrt(semi.length))) {
			System.out.print("Replaced " + semi[x]);
			semi[x] = rand.nextInt();
			System.out.println(" with " + semi[x]);
		}
		return semi;
	}

	
	private Initialize() {

	}

}