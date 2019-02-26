package ai.play.devtech.util.logic;

import java.util.function.Predicate;

public class If {

	private If() {
		/*No*/
	}

	public static void ifT(Predicate<Void> pred, Runnable tru, Runnable wron) {
		if(pred.test(null))
			tru.run();
		else
			wron.run();
	}
}
