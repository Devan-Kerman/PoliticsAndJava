package ai.play.devtech.core.errors;

/**
 * When no key is found
 *
 * @author devan
 */
public class NoKeyException extends SecurityException {
	private static final long serialVersionUID = 1236340747501086427L;

	public NoKeyException(String name) {

		super(name);
	}

}
