package ai.play.devtech.core.errors;

/**
 * Bad returned json
 *
 * @author devan
 */
public class UnsuccessfullAPIException extends RuntimeException {
	private static final long serialVersionUID = -3090438118161270927L;

	public UnsuccessfullAPIException(String strn) {
		super(strn);
	}

}
