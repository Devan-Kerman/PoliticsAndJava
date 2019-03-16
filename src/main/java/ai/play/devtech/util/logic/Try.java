package ai.play.devtech.util.logic;

public class Try {

	private Try() {}
	
	/**
	 * if the runnable throws an exception, it catches it and does nothing
	 * @param r
	 */
	public static void tryIgnore(Runnable r) {
		try {
			r.run();
		} catch(Exception e) {}
	}
}
