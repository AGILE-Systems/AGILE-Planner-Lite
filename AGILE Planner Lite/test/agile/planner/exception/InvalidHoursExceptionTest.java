package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

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
		assertEquals("agilesystems.planner.exceptions.InvalidHoursException: Hours used under invalid situation", e.toString());
		
		e = new InvalidHoursException("Test");
		assertEquals("agilesystems.planner.exceptions.InvalidHoursException: Test", e.toString());
	}

}