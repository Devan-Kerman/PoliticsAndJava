package ai.play.devtech.util.strings;

import java.util.Random;

public class Rand {

	public static final char[] VALID = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static final Random RANDOM = new Random();

	/**
	 * Returns a random string using only the english
	 * A-Z letters
	 *
	 * @return a random string
	 */
	public static String randEng(int len) {
		char[] rand = new char[len];
		for (int x = 0; x < rand.length; x++)
			rand[x] = VALID[RANDOM.nextInt(VALID.length)];
		return new String(rand);
	}

	private Rand() {
		/* Utility object */
	}

}
