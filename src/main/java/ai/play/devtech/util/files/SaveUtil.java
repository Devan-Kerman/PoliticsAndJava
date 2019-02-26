package ai.play.devtech.util.files;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.Consumer;
import java.util.stream.Stream;

import ai.play.devtech.util.strings.Rand;

public class SaveUtil {

	/**
	 * Uses a writer to append to a temporary file and open it on the desktop
	 * @throws IOException 
	 */
	public static void open(BufferedReader r, String type) throws IOException {
		File f = File.createTempFile(Rand.randEng(10), type);
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		forStream(r.lines(), t -> {
			try {writer.append(t);} catch (IOException e) {e.printStackTrace();}
		});
		writer.close();
		Desktop.getDesktop().open(f);
	}
	
	public static void open(Reader r, String type) throws IOException {
		open(new BufferedReader(r), type);
	}
	
	public static void open(InputStream i, String type) throws IOException {
		open(new InputStreamReader(i), type);
	}
	
	static <T> void forStream(Stream<T> s, Consumer<T> in) {
		s.forEach(in);
	}

}
