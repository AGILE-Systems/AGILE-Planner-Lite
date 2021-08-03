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
		assertNull(t1.addSubTask(3));
		t1.addSubTask(2);
		assertEquals(0, t1.getSubTotalRemaining());
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
		assertNull(t1.addSubTask(4));
		t1.addSubTask(3);
		assertEquals(0, t1.getSubTotalRemaining());
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
		assertEquals(1, t1.compareTo(t2));
	}

	/**
	 * Tests toString() functionality
	 */
	@Test
	public void testToString() {
		Task t1 = new Task("A", 2, 0);
		assertEquals("Task [name=A, total=2]", t1.toString());
	}
	
	
	/**
	 * Tests getters & setters for Task
	 */
	@Test
	public void testGettersAndSetters() {
		Task t1 = new Task("CSC316", 8, 3);
		assertEquals("CSC316", t1.getName());
		assertEquals(8, t1.getTotalHours());
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, 3);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		assertEquals(date, t1.getDueDate());
	}
	
	@Test
	public void testSubTask() {
		Task t1 = new Task("CSC116", 5, 2);
		SubTask st1 = t1.addSubTask(2);
		assertEquals(t1, st1.getParentTask());
		assertEquals(2, st1.getSubTaskHours());
		assertEquals("SubTask [name=CSC116, hours=2]", st1.toString());
		
		Task t2 = new Task("CSC216", 4, 1);
		SubTask st2 = t2.addSubTask(3);
		
		assertEquals(-1, st2.compareTo(st1));
		assertEquals(0, st1.compareTo(st1));
		assertEquals(1, st1.compareTo(st2));
	}

}
