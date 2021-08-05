package agile.planner.exception;

/**
 * Thrown in cases where Days are improperly used/called
 * 
 * @author Andrew Roe
 */
public class InvalidDayException extends Exception {

	/** Serial UID for the exception */
	private static final long serialVersionUID = -1232502294866387768L;
	
	/**
	 * Default InvalidDayException
	 */
	public InvalidDayException() {
		this("Day used under invalid situation");
	}
	
	/**
	 * InvalidDayException with custom message
	 * 
	 * @param message custom message
	 */
	public InvalidDayException(String message) {
		super(message);
	}

}