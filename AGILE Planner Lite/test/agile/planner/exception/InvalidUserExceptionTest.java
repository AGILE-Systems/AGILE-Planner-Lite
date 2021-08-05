package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import agile.planner.exceptions.InvalidUserException;

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
		assertEquals("agile.planner.exceptions.InvalidUserException: Illegal User attributes applied", e.toString());
		
		e = new InvalidUserException("Test");
		assertEquals("agile.planner.exceptions.InvalidUserException: Test", e.toString());
	}

}
