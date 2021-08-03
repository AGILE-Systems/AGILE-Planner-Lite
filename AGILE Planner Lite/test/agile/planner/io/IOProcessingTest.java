/**
 * 
 */
package agile.planner.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

import org.junit.Test;

import agile.planner.task.Task;

/**
 * Tests IOProcessing functionality
 * 
 * @author Andrew Roe
 */
public class IOProcessingTest {

	/**
	 * Tests writeSchedule() functionality
	 */
	@Test
	public void testWriteSchedule() {
		fail("Not yet implemented");
	}

	/**
	 * Tests readSchedule() functionality
	 */
	@Test
	public void testReadSchedule() {
		try {
			PriorityQueue<Task> pq = IOProcessing.readSchedule("data/data1.txt");
			assertEquals("CSC216", pq.remove().getName());
			assertEquals("CSC316", pq.remove().getName());
			assertEquals("CSC116", pq.remove().getName());
			assertTrue(pq.isEmpty());
		} catch (FileNotFoundException e) {
			fail();
		}
	}

}
