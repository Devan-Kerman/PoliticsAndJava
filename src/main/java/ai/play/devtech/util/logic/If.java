package ai.play.devtech.util.logic;

import java.util.function.Predicate;

public class If {

	private If() {
		/*No*/
	}

	/**
	 * Tests and runs the appropriate runnable
	 *
	 * @param pred test/expression
	 * @param tru runs if evaluated to true
	 * @param wron runs if evaluated to false
	 */
	public static void ifT(Predicate<Void> pred, Runnable tru, Runnable wron) {
		if (pred.test(null)) tru.run();
		else wron.run();
	}
}
