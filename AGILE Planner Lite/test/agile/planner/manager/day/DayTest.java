package agile.planner.manager.day;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import agile.planner.task.Task;

/**
 * Tests Day functionality
 * 
 * @author Andrew Roe
 */
public class DayTest {

	/**
	 * Tests getDate() functionality
	 */
	@Test
	public void testGetDate() {
		Day d1 = new Day(8, 2);
		Calendar future = Calendar.getInstance();
		future.add(Calendar.DAY_OF_MONTH, 2);
		future.set(Calendar.HOUR_OF_DAY, 0);
		future.set(Calendar.MINUTE, 0);
		future.set(Calendar.SECOND, 0);
		future.set(Calendar.MILLISECOND, 0);
		
		assertEquals(future, d1.getDate());
	}

	/**
	 * Tests addSubTask() and getSpareHours() and hasSpareHours() functionality
	 */
	@Test
	public void testAddSubTask() {
		Day d1 = new Day(8, 0);
		
		d1.addSubTask(new Task("CSC316", 6, 1));
		assertEquals(5, d1.getSpareHours());
		
		assertTrue(d1.hasSpareHours());
		
		d1.addSubTask(new Task("CSC230", 8, 2));
		assertEquals(2, d1.getSpareHours());
		
		d1.addSubTask(new Task("CSC342", 2, 0));
		assertFalse(d1.hasSpareHours());
	}

	/**
	 * Tests toString() functionality
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
