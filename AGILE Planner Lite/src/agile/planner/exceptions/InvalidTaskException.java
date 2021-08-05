package agile.planner.exceptions;

/**
 * Thrown in cases where Task attributes are invalid
 * 
 * @author Andrew Roe
 */
public class InvalidTaskException extends Exception {

	/** Serial UID for the exception */
	private static final long serialVersionUID = -6575776646443017156L;
	
	
	/**
	 * Default InvalidTaskException
	 */
	public InvalidTaskException() {
		this("Illegal Task attributes applied");
	}
	
	/**
	 * InvalidTaskException with custom message
	 * 
	 * @param message custom message
	 */
	public InvalidTaskException(String message) {
		super(message);
	}

}
