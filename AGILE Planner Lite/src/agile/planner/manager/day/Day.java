package agile.planner.manager.day;

import java.util.Calendar;
import java.util.TreeSet;

import agile.planner.task.Task;
import agile.planner.task.Task.SubTask;
import agile.planner.util.Time;

/**
 * Represents a single Day in the year
 * 
 * @author Andrew Roe
 */
public class Day {
//	TODO
//	if incrementing day leads to to month overflow, increment month and set day to 1
//	if the new month is January, increment year
//
//	use the Date object
//
//	can easily compare Dates [NOTE: We will need to use the last Date object when creating the next, time is relative to each other]
	private Calendar date;
	/** Number of hours possible for a given Day */
	private int capacity;
	/** Number of hours filled for a given Day */
	private int size;
	/** TreeSet of all SubTasks */
	private TreeSet<SubTask> subTasks;
	
	/**
	 * Primary constructor for Day
	 * 
	 * @param capacity total capacity for the day
	 * @param days number of days from present day (0=today, 1=tomorrow, ...)
	 */
	public Day(int capacity, int days) {
		setCapacity(capacity);
		setDate(days);
		subTasks = new TreeSet<>();
	}

	/**
	 * Sets the capacity for the Day
	 * 
	 * @param capacity total possible hours
	 */
	private void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Sets the Date for the Day
	 * 
	 * @param date Date to be set
	 */
	private void setDate(int days) {
		this.date = Time.getFormattedCalendarInstance(days);
	}
	
	/**
	 * Gets the Date from the Day
	 * 
	 * @return Date from Day
	 */
	public Calendar getDate() {
		return date;
	}
	
	/**
	 * Adds a Task to the Day
	 * 
	 * @param task task to be added in the form of a SubTask
	 */
	public void addSubTask(Task task) {
		Calendar currentDay = Time.getFormattedCalendarInstance(0);
		int days = Time.determineRangeOfDays(currentDay, task.getDueDate()) + 1;
		
		if(days == 1) {
			int hours = task.getSubTotalRemaining();
			SubTask st = task.addSubTask(hours);
			subTasks.add(st);
			this.size += hours;
			return;
			//TODO we will need to handle exceptions in this method if we don't have enough space
		}
		
		//Gets the even distribution across all the days
		int hours = task.getTotalHours() / days;
		//Adds an additional hour if the hours don't evenly divide up across the days
		hours += task.getTotalHours() % days == 0 ? 0 : 1;
		//Handles the case where we actually have less hours available due to scheduling
		hours = hours > task.getSubTotalRemaining() ? task.getSubTotalRemaining() : hours;
		//Fixes the number of hours according to what the Day has available
		hours = hours + size > capacity ? capacity - size : hours;
		
		SubTask st = task.addSubTask(hours);
		
		subTasks.add(st);
		this.size += hours;
	}
	
	/**
	 * Gets spare hours from the Day
	 * 
	 * @return number of free hours available for scheduling
	 */
	public int getSpareHours() {
		return capacity - size;
	}
	
	/**
	 * Determines whether there are spare hours in the Day
	 * 
	 * @return boolean value for opening in Day
	 */
	public boolean hasSpareHours() {
		return getSpareHours() > 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Day [");
		int count = 0;
		for(SubTask st : subTasks) {
			count++;
			sb.append(st.toString());
			if(count < subTasks.size()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
