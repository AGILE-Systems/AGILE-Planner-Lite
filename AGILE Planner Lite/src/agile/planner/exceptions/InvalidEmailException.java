package agile.planner.exceptions;

/**
 * Thrown in cases where the Google email or its password are invalid
 * 
 * @author Andrew Roe
 */
public class InvalidEmailException extends Exception {

	/** Serial UID for the exception */
	private static final long serialVersionUID = 6495768181770551611L;
	
	/**
	 * Default InvalidEmailException
	 */
	public InvalidEmailException() {
		this("Invalid email or password used");
	}
	
	/**
	 * InvalidEmailException with custom message
	 * 
	 * @param message custom message
	 */
	public InvalidEmailException(String message) {
		super(message);
	}

}
