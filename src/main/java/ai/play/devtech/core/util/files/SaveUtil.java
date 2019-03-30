package ai.play.devtech.core.util.files;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.SplittableRandom;

import ai.play.devtech.core.util.logic.ExceptionWrapper;

public class SaveUtil {

	/**
	 * Uses a writer to append to a temporary file and open it on the desktop
	 *
	 * @throws IOException
	 */
	public static void open(BufferedReader r, String type) throws IOException {
		File f = File.createTempFile(randEng(10), type);
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		new ExceptionWrapper<Void>(() -> r.lines().forEach(s -> new ExceptionWrapper<Void>(() -> writer.append(s)).run())).run();
		writer.close();
		Desktop.getDesktop().open(f);
	}
	
	public static final char[] VALID = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static final SplittableRandom RANDOM = new SplittableRandom();

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

	/**
	 * Auto buffers the reader and calls {@link SaveUtil#open(BufferedReader, String)}
	 *
	 * @param r
	 * @param type
	 * @throws IOException
	 */
	public static void open(Reader r, String type) throws IOException {
		open(new BufferedReader(r), type);
	}

	/**
	 * Same thing as {@link SaveUtil#open(Reader, String)} but first wraps it in a {@link InputStreamReader}
	 *
	 * @param i
	 * @param type
	 * @throws IOException
	 */
	public static void open(InputStream i, String type) throws IOException {
		open(new InputStreamReader(i), type);
	}


}
