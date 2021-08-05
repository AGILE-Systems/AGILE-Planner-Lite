package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import agile.planner.exceptions.InvalidEmailException;

/**
 * Tests InvalidEmailException
 * 
 * @author Andrew Roe
 */
public class InvalidEmailExceptionTest {

	/**
	 * Tests InvalidEmailException constructors
	 */
	@Test
	public void testInvalidEmailException() {
		Exception e = new InvalidEmailException();
		assertEquals("agile.planner.exceptions.InvalidEmailException: Invalid email or password used", e.toString());
		
		e = new InvalidEmailException("Test");
		assertEquals("agile.planner.exceptions.InvalidEmailException: Test", e.toString());
	}

}