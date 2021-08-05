package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import agile.planner.exceptions.InvalidDayException;

/**
 * Tests InvalidDayException
 * 
 * @author Andrew Roe
 */
public class InvalidDayExceptionTest {

	/**
	 * Tests InvalidDayException constructors
	 */
	@Test
	public void testInvalidDayException() {
		Exception e = new InvalidDayException();
		assertEquals("agile.planner.exceptions.InvalidDayException: Day used under invalid situation", e.toString());
		
		e = new InvalidDayException("Test");
		assertEquals("agile.planner.exceptions.InvalidDayException: Test", e.toString());
	}

}