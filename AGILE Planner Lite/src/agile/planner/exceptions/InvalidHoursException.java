package agile.planner.exceptions;

/**
 * Thrown in cases where hours are improperly used/called
 * 
 * @author Andrew Roe
 */
public class InvalidHoursException extends Exception {

	/** Serial UID for the exception */
	private static final long serialVersionUID = 4036007531094574666L;
	
	/**
	 * Default InvalidHoursException
	 */
	public InvalidHoursException() {
		this("Hours used under invalid situation");
	}
	
	/**
	 * InvalidHoursException with custom message
	 * 
	 * @param message custom message
	 */
	public InvalidHoursException(String message) {
		super(message);
	}

}
