package agile.planner.user;

import static org.junit.Assert.*;

import org.junit.Test;

import agile.planner.exceptions.InvalidUserException;

/**
 * Tests Client functionality
 * 
 * @author Andrew Roe
 */
public class ClientTest {

	/**
	 * Tests getters and setters with valid cases
	 */
	@Test
	public void testGettersSetters() {
		try {
			Client paul = new Client("Paul", "paul@yahoo.com", "12345");
			assertEquals("Paul", paul.getName());
			assertEquals("paul@yahoo.com", paul.getEmail());
			assertEquals("12345", paul.getLocalPassword());
		} catch (InvalidUserException e) {
			fail();
		}
	}
	
	/**
	 * Tests getters and setters with exception cases
	 */
	@Test
	public void testExceptions() {
		try {
			new Client("", "paul@yahoo.com", "12345");
			fail();
		} catch (InvalidUserException e) {
			assertEquals("Name cannot be null or empty", e.getMessage());
		}
		
		try {
			new Client(null, "paul@yahoo.com", "12345");
			fail();
		} catch (InvalidUserException e) {
			assertEquals("Name cannot be null or empty", e.getMessage());
		}
		
		try {
			new Client("Paul", "", "12345");
			fail();
		} catch (InvalidUserException e) {
			assertEquals("Email cannot be null or empty", e.getMessage());
		}
		
		try {
			new Client("Paul", null, "12345");
			fail();
		} catch (InvalidUserException e) {
			assertEquals("Email cannot be null or empty", e.getMessage());
		}
		
		try {
			new Client("Paul", "paul@yahoo.com", "");
			fail();
		} catch (InvalidUserException e) {
			assertEquals("Password cannot be null or empty", e.getMessage());
		}
		
		try {
			new Client("Paul", "paul@yahoo.com", null);
			fail();
		} catch (InvalidUserException e) {
			assertEquals("Password cannot be null or empty", e.getMessage());
		}
		
	}

	/**
	 * Tests getLastLoginTime() functionality
	 */
	@Test
	public void testGetLasLoginTime() {
		try {
			Client paul = new Client("Paul", "paul@yahoo.com", "12345");
			assertNotNull(paul.getLasLoginTime());
		} catch (InvalidUserException e) {
			fail();
		}
		
		try {
			String time = new Client("", "paul@yahoo.com", "12345").getLasLoginTime();
			assertNull(time);
			fail();
		} catch (InvalidUserException e) {
			assertEquals("Name cannot be null or empty", e.getMessage());
		}
		
	}

}
