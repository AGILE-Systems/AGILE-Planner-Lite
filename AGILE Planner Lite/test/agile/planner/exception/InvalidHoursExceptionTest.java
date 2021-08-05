package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import agile.planner.exceptions.InvalidHoursException;

/**
 * Tests InvalidHoursException
 * 
 * @author Andrew Roe
 */
public class InvalidHoursExceptionTest {

	/**
	 * Tests InvalidHoursException constructors
	 */
	@Test
	public void testInvalidHoursException() {
		Exception e = new InvalidHoursException();
		assertEquals("agile.planner.exceptions.InvalidHoursException: Hours used under invalid situation", e.toString());
		
		e = new InvalidHoursException("Test");
		assertEquals("agile.planner.exceptions.InvalidHoursException: Test", e.toString());
	}

}