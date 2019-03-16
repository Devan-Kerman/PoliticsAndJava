package ai.play.devtech.core.api.interfaces;

import java.util.Map;
import java.util.function.Function;

public interface APICache {
	public <T> T get(String url, Class<T> type, Function<Map<String, Object>, Map<String, Object>> processor);
}
