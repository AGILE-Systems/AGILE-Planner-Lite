package agile.planner.task;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import agile.planner.task.Task.SubTask;

/**
 * Tests Task core functionality
 * 
 * @author Andrew Roe
 */
public class TaskTest {

	/**
	 * Tests AddSubTask() functionality
	 */
	@Test
	public void testAddSubTask() {
		Task t1 = new Task("CSC116", 4, 2);
		assertNull(t1.addSubTask(0));
		SubTask st1 = t1.addSubTask(2);
		assertEquals(2, st1.getSubTaskHours());
	}

	/**
	 * Tests getSubTotalRemaining() functionality
	 */
	@Test
	public void testGetSubTotalRemaining() {
		Task t1 = new Task("CSC116", 5, 2);
		SubTask st1 = t1.addSubTask(2);
		assertEquals(2, st1.getSubTaskHours());
		assertEquals(3, t1.getSubTotalRemaining());
	}

	/**
	 * Tests compareTo() functionality
	 */
	@Test
	public void testCompareTo() {
		Task t1 = new Task("CSC116", 5, 2);
		Task t2 = new Task("CSC216", 1, 1);
		Task t3 = new Task("CSC316", 6, 2);
		Task t4 = new Task("Test", 1, 1);
		assertEquals(-1, t3.compareTo(t1));
		assertEquals(0, t1.compareTo(t1));
		assertEquals(1, t1.compareTo(t3));
		assertEquals(-1, t2.compareTo(t3));
		assertEquals(0, t2.compareTo(t4));
	}

	/**
	 * Tests toString() functionality
	 */
	@Test
	public void testToString() {
		Task t1 = new Task("A", 2, 0);
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		assertEquals("Task [name=A, total=2, date=" + currentDay + "]", t1.toString());
		
//		Simple test to see if it would work (it did!)
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		cal.add(Calendar.DAY_OF_MONTH, 5);
//	    System.out.println(sdf.format(cal.getTime()));
	}
	
	@Test
	public void testSubTask() {
		Task t1 = new Task("CSC116", 5, 2);
		SubTask st1 = t1.addSubTask(2);
		assertEquals(t1, st1.getParentTask());
		assertEquals(2, st1.getSubTaskHours());
	}

}
