package ai.play.devtech.api.hooks;

import ai.play.devtech.APIObject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * When run, it will call all of it's suppliers simultatiously to retrieve new
 * data using a cached thread pool
 *
 * @param <T>
 * @author devan
 */
public class VarietyHook<T extends APIObject> extends TimerTask implements Runnable {

	protected List<Supplier<T>> suppliers;
	protected Map<String, Consumer<T>> listeners;
	protected Executor exec = Executors.newCachedThreadPool();

	@SafeVarargs
	public VarietyHook(Supplier<T>... suppliers) {
		this.suppliers = Arrays.asList(suppliers);
	}

	public void addListener(String id, Consumer<T> joined) {
		listeners.put(id, joined);
	}

	public Consumer<T> removeListener(String id) {
		return listeners.remove(id);
	}

	@Override
	public void run() {
		suppliers.forEach(sup -> exec.execute(() -> listeners.forEach((k, v) -> v.accept(sup.get()))));
	}

}
