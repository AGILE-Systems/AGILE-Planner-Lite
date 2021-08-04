package agile.planner.manager;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;

import agile.planner.io.IOProcessing;
import agile.planner.manager.day.Day;
import agile.planner.task.Task;

/**
 * Handles the generation and management of the overall schedule
 * 
 * @author Andrew Roe
 */
public class ScheduleManager {
	
	/** LinkedList of Days representing a single schedule */
	private LinkedList<Day> schedule;
	/** PriorityQueue of all Tasks in sorted order */
	private PriorityQueue<Task> totalTasks;
	/** Single instance of a ScheduleManager */
	private static ScheduleManager manager;
	
	/**
	 * Private constructor of ScheduleManager
	 * 
	 * Initially performs task processing as well as schedule generation
	 */
	private ScheduleManager() {
		processTasks();
		generateSchedule();
	}
	
	/**
	 * Gets a singleton of ScheduleManager
	 * 
	 * @return singleton of ScheduleManager
	 */
	public static ScheduleManager getSingleton() {
		if(manager == null) {
			manager = new ScheduleManager();
		}
		return manager;
	}
	
	/**
	 * Processes the Tasks from the given file
	 */
	private void processTasks() {
		try {
			this.totalTasks = IOProcessing.readSchedule("data/data1.txt");	//TODO will need to change this
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//TODO will need to go back to the diagram for a cleaner design framework
	private void generateSchedule() {
		//TODO will need to add a task to each day until that day is full. Will need to start up at the last point
		//TODO might need to store all the contents into a new PQ object and store the reference back into totalTasks variable
		this.schedule = new LinkedList<>();
		PriorityQueue<Task> processed = new PriorityQueue<>();
		int count = 0;
		while(totalTasks.size() > 0) {
			Day day = new Day(8, count++);
			while(day.hasSpareHours() && totalTasks.size() > 0) {
				Task task = totalTasks.remove();
				day.addSubTask(task);
				if(task.getSubTotalRemaining() > 0) {
					processed.add(task);
				}
			}
			while(processed.size() > 0) {
				totalTasks.add(processed.remove());
			}
			schedule.addLast(day);
		}
	}
	
	/**
	 * Outputs the current schedule
	 */
	public void outputSchedule() {
		IOProcessing.writeSchedule(schedule);
	}

}
