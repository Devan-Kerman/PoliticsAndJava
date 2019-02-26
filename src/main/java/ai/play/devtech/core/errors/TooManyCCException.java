package ai.play.devtech.core.errors;

public class TooManyCCException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2017486497886245922L;

	public TooManyCCException() {
		
	}

	public TooManyCCException(String message) {
		super(message);
		
	}

	public TooManyCCException(Throwable cause) {
		super(cause);
		
	}

	public TooManyCCException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TooManyCCException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
