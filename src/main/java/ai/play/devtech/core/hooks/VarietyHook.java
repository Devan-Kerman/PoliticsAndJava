package main.java.ai.play.devtech.core.hooks;

import java.util.Map;
import java.util.TimerTask;
import java.util.function.Supplier;
import java.util.function.Consumer;

import main.java.ai.play.devtech.APIObject;

public class VarietyHook<T extends APIObject> extends TimerTask implements Runnable {
	
	Supplier<T>[] suppliers;
	Map<String, Consumer<T>> listeners;
	
	@SafeVarargs
	public VarietyHook(Supplier<T>...suppliers) {
		this.suppliers = suppliers;
	}

	public void addListener(String id, Consumer<T> joined) {
		listeners.put(id, joined);
	}

	public Consumer<T> removeListener(String id) {
		return listeners.remove(id);
	}
	
	@Override
	public void run() {
		for(Supplier<T> sup : suppliers) {
			T obj = sup.get();
			listeners.forEach((k, v) -> v.accept(obj));
		}
	}
	
	

}
