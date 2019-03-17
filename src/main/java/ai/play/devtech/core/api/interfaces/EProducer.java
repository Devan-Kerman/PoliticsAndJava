package ai.play.devtech.core.api.interfaces;

/**
 * A producer that throws an exception
 *
 * @param <T>
 * @author devan
 */
public interface EProducer<T> {
	T run() throws Exception;
}
