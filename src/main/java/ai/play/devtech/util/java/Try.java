package ai.play.devtech.util.java;

public class Try {

	private Try() {}
	
	public static void tryIgnore(Runnable r) {
		try {
			r.run();
		} catch(Exception e) {
			
		}
	}

}
