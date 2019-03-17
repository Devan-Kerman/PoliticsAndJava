package ai.play.devtech.core.errors;

/**
 * Bad API url
 *
 * @author devan
 */
public class InvalidAPIURLException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidAPIURLException(String msg) {
		super(msg);
	}

}
