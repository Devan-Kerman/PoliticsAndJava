package ai.play.devtech.api;

import java.time.Duration;
import java.util.concurrent.Executor;

import ai.play.devtech.api.caches.ModularAPICache;

public class APICacheBuilder {
	private Executor exec;
	private Duration dur;
	private boolean safe;
	
	/**
	 * The executor used to delete data ahead of time
	 * @param exec
	 * @return
	 */
	public APICacheBuilder evictorExecutor(Executor exec) {
		this.exec = exec;
		return this;
	}
	
	/**
	 * specify the amount of time until the cache will no longer consider an entry valid
	 * @param dur the time after which data in the cache is deemed outdated
	 * @return current builer
	 */
	public APICacheBuilder evictionTime(Duration dur) {
		this.dur = dur;
		return this;
	}
	
	/**
	 * Whether or not the cache will be optimized for simultaious requests, if you aren't using multiple threads, disable this
	 * it has an impact on performance
	 * @param safe if the cache should take multiple requests at once
	 * @return current instance
	 */
	public APICacheBuilder threadSafe(boolean safe) {
		this.safe = safe;
		return this;
	}
	
	public ModularAPICache build() {
		return new ModularAPICache(safe, exec, dur);
	}
}
