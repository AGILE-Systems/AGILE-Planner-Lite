package agile.planner.exceptions;

/**
 * Thrown in cases where the User attributes are invalid
 * 
 * @author Andrew Roe
 */
public class InvalidUserException extends Exception {

	/** Serial UID for the exception */
	private static final long serialVersionUID = 3573947033961139879L;
	
	/**
	 * Default InvalidUserException
	 */
	public InvalidUserException() {
		this("Illegal User attributes applied");
	}
	
	/**
	 * InvalidUserException with custom message
	 * 
	 * @param message custom message
	 */
	public InvalidUserException(String message) {
		super(message);
	}

}
