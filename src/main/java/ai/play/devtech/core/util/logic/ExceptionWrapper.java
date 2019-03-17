package ai.play.devtech.core.util.logic;

import ai.play.devtech.api.interfaces.EProducer;
import ai.play.devtech.api.interfaces.ERunnable;

/**
 * Wraps any exceptions that will be thrown by the runnable into a runtime exception instead.
 *
 * @param <A> the return type (put Void if none)
 * @author devan
 */
public class ExceptionWrapper<A> {
	private EProducer<A> fi;
	private ERunnable r;

	public ExceptionWrapper(ERunnable r) {
		this.r = r;
	}

	public ExceptionWrapper(EProducer<A> fi) {
		this.fi = fi;
	}

	/**
	 * If this was initalized with a runnable, it will return null.
	 *
	 * @return
	 */
	public A run() {
		try {
			if (fi != null) return fi.run();
			if (r != null) r.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
