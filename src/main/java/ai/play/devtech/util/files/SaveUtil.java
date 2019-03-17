package ai.play.devtech.util.files;

import ai.play.devtech.util.logic.ExceptionWrapper;
import ai.play.devtech.util.strings.Rand;
import java.awt.Desktop;
import java.io.*;

public class SaveUtil {

	/**
	 * Uses a writer to append to a temporary file and open it on the desktop
	 *
	 * @throws IOException
	 */
	public static void open(BufferedReader r, String type) throws IOException {
		File f = File.createTempFile(Rand.randEng(10), type);
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		new ExceptionWrapper<Void>(() -> r.lines().forEach(s -> new ExceptionWrapper<Void>(() -> writer.append(s)).run())).run();
		writer.close();
		Desktop.getDesktop().open(f);
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
