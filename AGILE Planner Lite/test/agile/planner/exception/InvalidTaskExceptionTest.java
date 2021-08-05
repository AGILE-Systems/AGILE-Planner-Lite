package agile.planner.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import agile.planner.exceptions.InvalidTaskException;

/**
 * Tests InvalidTaskException functionality
 * 
 * @author Andrew Roe
 */
public class InvalidTaskExceptionTest {

	/**
	 * Tests InvalidTaskException constructors
	 */
	@Test
	public void testInvalidTaskException() {
		Exception e = new InvalidTaskException();
		assertEquals("agile.planner.exceptions.InvalidTaskException: Illegal Task attributes applied", e.toString());
		
		e = new InvalidTaskException("Test");
		assertEquals("agile.planner.exceptions.InvalidTaskException: Test", e.toString());
	}

}
