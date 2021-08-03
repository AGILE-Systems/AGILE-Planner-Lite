package agile.planner.manager;

import java.io.FileNotFoundException;
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
	
	/** PriorityQueue of Days representing a single schedule */
	private PriorityQueue<Day> schedule;
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
			this.totalTasks = IOProcessing.readSchedule("data/file.txt");	//TODO will need to change this
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//TODO will need to go back to the diagram for a cleaner design framework
	private void generateSchedule() {
		//TODO will need to add a task to each day until that day is full. Will need to start up at the last point
		//TODO might need to store all the contents into a new PQ object and store the reference back into totalTasks variable
		PriorityQueue<Task> processed = new PriorityQueue<>();
		while(totalTasks.size() > 0) {
			Day day = new Day();
			boolean flag = false;
			while(day.getRemainingHours() > 0 && (totalTasks.size() > 0 || processed.size() > 0)) {
				if(flag) {
					Task task = processed.remove();
					day.addSubTask(task);
					totalTasks.add(task);
					flag = processed.size() != 0;
				} else {
					Task task = totalTasks.remove();
					day.addSubTask(task);
					processed.add(task);
				}
			}
			while(processed.size() > 0) {
				totalTasks.add(processed.remove());
			}
		}
	}
	
	/**
	 * Outputs the current schedule
	 */
	public void outputSchedule() {
		IOProcessing.writeSchedule(schedule);
	}

}
