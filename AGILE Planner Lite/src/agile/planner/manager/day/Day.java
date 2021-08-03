package agile.planner.manager.day;

import java.util.Date;
import java.util.TreeSet;

import agile.planner.task.Task;
import agile.planner.task.Task.SubTask;

/**
 * Represents a single Day in the year
 * 
 * @author Andrew Roe
 */
public class Day implements Comparable<Day> {
//	TODO
//	if incrementing day leads to to month overflow, increment month and set day to 1
//	if the new month is January, increment year
//
//	use the Date object
//
//	can easily compare Dates [NOTE: We will need to use the last Date object when creating the next, time is relative to each other]
	private Date date;
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
	public Day(int capacity) {
		setHours(capacity);
	}
	
	/**
	 * Sets the capacity for the Day
	 * 
	 * @param capacity total possible hours
	 */
	private void setHours(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Adds a SubTask to the Day
	 * 
	 * @param task Task to be added in the form of a SubTask
	 */
	public void addSubTask(Task task) {
		int hours = task.getSubTotalRemaining();
		
		//TODO We will need to add the core logic for adding a subtask to a given day (don't worry about exceptions yet)
//		subTasks.add(subTask);
//		this.size += subTask.getSubTaskHours();
	}
	
	/**
	 * Determines whether there are spare hours in the Day
	 * 
	 * @return boolean value for opening in Day
	 */
	public boolean hasSpareHours() {
		return capacity - size > 0;
	}

	@Override
	public int compareTo(Day o) {
		// TODO Auto-generated method stub
		return 0;
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
