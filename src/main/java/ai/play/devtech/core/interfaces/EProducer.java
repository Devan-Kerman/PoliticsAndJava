package ai.play.devtech.core.interfaces;

/**
 * A producer that throws an exception
 *
 * @param <T>
 * @author devan
 */
@FunctionalInterface
public interface EProducer<T> {
	T run() throws Exception;
}
