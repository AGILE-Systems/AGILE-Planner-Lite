package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests InvalidUserException functionality
 * 
 * @author Andrew Roe
 */
public class InvalidUserExceptionTest {

	/**
	 * Tests InvalidUserException constructors
	 */
	@Test
	public void testInvalidUserException() {
		Exception e = new InvalidUserException();
		assertEquals("agilesystems.planner.exceptions.InvalidUserException: Illegal User attributes applied", e.toString());
		
		e = new InvalidUserException("Test");
		assertEquals("agilesystems.planner.exceptions.InvalidUserException: Test", e.toString());
	}

}
