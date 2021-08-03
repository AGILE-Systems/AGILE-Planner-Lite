package agile.planner.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import agile.planner.manager.day.Day;
import agile.planner.task.Task;

/**
 * Handles all input/output functionality for the ScheduleManager
 * 
 * @author Andrew Roe
 */
public class IOProcessing {
	
	public static void writeSchedule(PriorityQueue<Day> pq) {
		for(int i = 0; pq.size() > 0; i++) {
			Day day = pq.remove();
			System.out.println("Day " + i + ":");
			System.out.println(day.toString());
		}
	}
	
	/**
	 * Processes the specified file for the list of all specified Tasks
	 * 
	 * @param filename file to be processed
	 * @return PriorityQueue of all Tasks from the file
	 * @throws FileNotFoundException if file does not exist
	 */
	public static PriorityQueue<Task> readSchedule(String filename) throws FileNotFoundException {
		PriorityQueue<Task> pq = new PriorityQueue<>();
		Scanner fileScanner = new Scanner(new File(filename));
		fileScanner.useDelimiter(",|\\r\\n");
		while(fileScanner.hasNextLine()) {
			String name = fileScanner.next();
			int hours = fileScanner.nextInt();
			int date = fileScanner.nextInt();
			pq.add(new Task(name, hours, date));
		}
		return pq;
	}

}