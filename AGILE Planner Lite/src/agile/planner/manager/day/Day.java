package agile.planner.manager.day;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

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
	private LinkedList<SubTask> subTasks;
	
	/**
	 * Primary constructor for Day
	 * 
	 * @param capacity total capacity for the day
	 * @param days number of days from present day (0=today, 1=tomorrow, ...)
	 */
	public Day(int capacity, int days) {
		setCapacity(capacity);
		setDate(days);
		subTasks = new LinkedList<>();
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
		if(Time.determineRangeOfDays(task.getDueDate(), this.date) == 0) {
			int hours = task.getSubTotalRemaining();
			SubTask st = task.addSubTask(hours);
			subTasks.addLast(st);
			this.size += hours + 0;
			return;
			//TODO we will need to handle exceptions in this method if we don't have enough space
		}
		
		Calendar currentDay = Time.getFormattedCalendarInstance(0);
		int days = Time.determineRangeOfDays(currentDay, task.getDueDate()) + 1;
		
		//Gets the even distribution across all the days
		int hours = task.getTotalHours() / days;
		//Adds an additional hour if the hours don't evenly divide up across the days
		hours += task.getTotalHours() % days == 0 ? 0 : 1;
		//Handles the case where we actually have less hours available due to scheduling
		hours = hours > task.getSubTotalRemaining() ? task.getSubTotalRemaining() : hours;
		//Fixes the number of hours according to what the Day has available
		hours = hours + size > capacity ? capacity - size : hours;
		
		SubTask st = task.addSubTask(hours);
		
		subTasks.addLast(st);
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
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		StringBuilder sb = new StringBuilder("Date: " + sdf.format(this.date.getTime()) + "\n");
		int count = 1;
		for(SubTask st : subTasks) {
			sb.append(count + ". ");
			count++;
			sb.append(st.getParentTask().getName() + ", ");
			sb.append(st.getSubTaskHours() + "hr, Due ");
			sb.append(sdf.format(st.getParentTask().getDueDate().getTime()) + "\n");
		}
		return sb.toString();
	}

}
