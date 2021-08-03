package agile.planner.manager.day;

import java.util.Calendar;
import java.util.TreeSet;

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
	 * Adds a SubTask to the Day
	 * 
	 * @param subtask SubTask to be added
	 */
	public void addSubTask(SubTask subtask) {
		subTasks.add(subtask);
		this.size += subtask.getSubTaskHours();
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
