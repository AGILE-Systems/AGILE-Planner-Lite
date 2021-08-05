package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

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
		assertEquals("agilesystems.planner.exceptions.InvalidDayException: Day used under invalid situation", e.toString());
		
		e = new InvalidDayException("Test");
		assertEquals("agilesystems.planner.exceptions.InvalidDayException: Test", e.toString());
	}

}