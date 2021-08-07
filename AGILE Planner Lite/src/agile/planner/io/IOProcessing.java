package agile.planner.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
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
	
	/**
	 * Outputs the schedule in text format
	 * 
	 * @param list a list of Days from the Schedule
	 */
	public static void writeSchedule(LinkedList<Day> list) {
		for(Day day : list) {
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
		fileScanner.useDelimiter(",|\\r\\n|\\n");
		while(fileScanner.hasNextLine()) {
			String name = fileScanner.next();
			int hours = fileScanner.nextInt();
			int date = fileScanner.nextInt();
			pq.add(new Task(name, hours, date));
		}
		fileScanner.close();
		return pq;
	}

}
