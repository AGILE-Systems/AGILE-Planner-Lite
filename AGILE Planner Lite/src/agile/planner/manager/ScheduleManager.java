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
	/** Total count for the number of errors that occurred in schedule generation */
	private int errorCount;
	
	/**
	 * Private constructor of ScheduleManager
	 * 
	 * Initially performs task processing as well as schedule generation
	 */
	private ScheduleManager() {
		processTasks();
		generateDistributiveSchedule();
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
			this.totalTasks = IOProcessing.readSchedule("data/break.txt");	//TODO will need to change this
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a task to the schedule assuming no conflict
	 * 
	 * @param task Task to be added to schedule
	 */
	public void addTask(Task task) {
		resetSchedule();
		totalTasks.add(task);
		generateDistributiveSchedule();
	}
	
	/**
	 * Removes a task from the schedule given the day and the task name TODO will need to handle duplicates
	 * 
	 * @param dayIndex day that the task exists (e.g. 0=today, 1=tomorrow, ...)
	 * @param taskIndex index of the task to be removed (0=first, 1=second, ...)
	 * @return Task removed from Day
	 */
	public Task removeTask(int dayIndex, int taskIndex) {
		if(dayIndex < 0 || dayIndex >= schedule.size()) {
			return null;
		}
		Day day = schedule.get(dayIndex);
		if(taskIndex < 0 || taskIndex >= day.getNumSubTasks()) {
			return null;
		}
		Task task = day.getTask(taskIndex);
		totalTasks.remove(task);
		resetSchedule();
		generateDistributiveSchedule();
		return task;
	}
	
	/**
	 * Edits a task from the schedule given the day and the task name TODO will need to handle duplicates
	 * 
	 * @param day day that the task exists (e.g. 0=today, 1=tomorrow, ...)
	 * @param name name of the task
	 */
	public void editTask(int day, String name) {
		
	}
	
	/**
	 * Generates an entire schedule following a cram approach
	 */
	private void generateCramSchedule() {
		//TODO will be implemented in v0.9.0
	}
	
	private void resetSchedule() {
		schedule = new LinkedList<>();
		PriorityQueue<Task> copy = new PriorityQueue<>();
		while(totalTasks.size() > 0) {
			Task task = totalTasks.remove();
			task.reset();
			copy.add(task);
		}
		totalTasks = copy;
		errorCount = 0;
	}
	
	/**
	 * Generates an entire schedule following a distributive approach
	 */
	private void generateDistributiveSchedule() {
		resetSchedule();
		PriorityQueue<Task> copy = new PriorityQueue<>();
		PriorityQueue<Task> processed = new PriorityQueue<>();
		int count = 0;
		while(totalTasks.size() > 0) {
			Day day = new Day(8, count++);
			while(day.hasSpareHours() && totalTasks.size() > 0) {
				Task task = totalTasks.remove();
				boolean validTask = day.addSubTask(task);
				if(task.getSubTotalRemaining() > 0) {
					processed.add(task);
				} else {
					copy.add(task);
					errorCount += validTask ? 0 : 1;
					if(!validTask || !day.hasSpareHours()) {
						while(totalTasks.size() > 0 && totalTasks.peek().getDueDate().equals(day.getDate())) {
							copy.add(totalTasks.peek());
							day.addSubTask(totalTasks.remove());
							errorCount++;
						}
					}
				}
			}
			while(processed.size() > 0) {
				totalTasks.add(processed.remove());
			}
			schedule.addLast(day);
		}
		this.totalTasks = copy;
	}
	
	/**
	 * Outputs the current day's schedule
	 */
	public void outputDay() {
		IOProcessing.writeDay(schedule.getFirst(), errorCount);
	}
	
	/**
	 * Outputs the current schedule
	 */
	public void outputSchedule() {
		IOProcessing.writeSchedule(schedule, errorCount);
	}
	
	/**
	 * Determines whether the schedule is empty
	 * 
	 * @return boolean value for whether schedule is empty
	 */
	public boolean scheduleIsEmpty() {
		return schedule.isEmpty();
	}

}
