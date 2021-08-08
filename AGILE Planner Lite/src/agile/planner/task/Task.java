package agile.planner.task;

import java.util.Calendar;

import agile.planner.util.Time;

/**
 * The core element of the underlying schedule. Possesses a name, a due date,
 * along with a total number of hours. It is responsible for the construction of
 * SubTasks.
 * 
 * @author Andrew Roe
 */
public class Task implements Comparable<Task> {
	
	/** Name of the Task */
	private String name;
	/** Due date of the Task */
	private Calendar date;
	/** Total number of hours for the Task */
	private int total;
	/** Number of SubTask hours */
	private int subTotal;
	/** # of hours / (DueDate - StartingDay) */
	private int averageNumHours;
	
	/**
	 * Primary constructor for Task
	 * 
	 * @param name name of Task
	 * @param total number of hours for Task
	 * @param days number of days till due date for Task
	 */
	public Task(String name, int total, int days) {
		setName(name);
		setTotalHours(total);
		setDueDate(days);
	}
	
	/**
	 * Adds a SubTask for a given Task
	 * 
	 * @param hours number of hours
	 * @param overflow overflow status of the SubTask
	 * @return SubTask
	 */
	public SubTask addSubTask(int hours, boolean overflow) {
		SubTask st = null;
		if(hours > 0 && subTotal + hours <= total) {
			st = new SubTask(this, hours, overflow);
			subTotal += hours;
		}
		return st;
	}
	
	/**
	 * Resets the Task in all of its properties
	 */
	public void reset() {
		subTotal = 0;
		setAverageNumberofHours(0);
	}
	
	/**
	 * Gets the number of SubTask hour slots currently unfilled
	 * 
	 * @return number of unfilled hours for SubTasks
	 */
	public int getSubTotalRemaining() {
		return total - subTotal;
	}
	
	@Override
	public int compareTo(Task o) {
		long timeDiff = this.date.compareTo(o.date);
		if(timeDiff < 0 || timeDiff == 0 && this.getSubTotalRemaining() > o.getSubTotalRemaining()) {	//TODO need to switch this to getTotalHours() [Test it first]
			return -1;
		} else if(timeDiff > 0 || timeDiff == 0 && this.getSubTotalRemaining() < o.getSubTotalRemaining()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets the name of the Task
	 * 
	 * @return name of Task
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Task
	 * 
	 * @param name name of Task
	 */
	private void setName(String name) {	//TODO will need to include exceptions for the setters
		this.name = name;
	}

	/**
	 * Gets the due date of the Task
	 * 
	 * @return due date of Task
	 */
	public Calendar getDueDate() {
		return date;
	}

	/**
	 * Sets the due date of the Task
	 * 
	 * @param date due date of Task
	 */
	private void setDueDate(int days) { //TODO will need to include exceptions for the setters
		this.date = Time.getFormattedCalendarInstance(days);
	}

	/**
	 * Gets the total number of hours for the Task
	 * 
	 * @return number of hours for the Task
	 */
	public int getTotalHours() {
		return total;
	}

	/**
	 * Sets the total number of hours for the Task
	 * 
	 * @param total number of hours for the Task
	 */
	private void setTotalHours(int total) { //TODO will need to include exceptions for the setters
		this.total = total;
	}
	
	/**
	 * Sets the average number of hours for the Task
	 * 
	 * @param averageNumHours average number of hours for the Task
	 */
	public void setAverageNumberofHours(int averageNumHours) {
		this.averageNumHours = averageNumHours;
	}
	
	/**
	 * Gets the average number of hours for the Task
	 * 
	 * @return average number of hours for the Task
	 */
	public int getAverageNumHours() {
		return averageNumHours;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", total=" + total + "]";
	}
	
	
	/**
	 * The individual component of a parent Task in the form of a SubTask
	 * 
	 * TODO will need to include a markComplete() method
	 * 
	 * @author Andrew Roe
	 */
	public class SubTask implements Comparable<SubTask> {
		
		/** Parent Task of the SubTask */
		private Task parentTask;
		/** Number of hours for the SubTask */
		private int hours;
		/** Number of overflow hours due to scheduling */
		private boolean overflow;
		
		/**
		 * Primary constructor for SubTask
		 * 
		 * @param parentTask parent of the SubTask
		 * @param hours number of hours for the SubTask
		 */
		private SubTask(Task parentTask, int hours, boolean overflow) {
			this.parentTask = parentTask;
			this.hours = hours;
			this.overflow = overflow;
		}
		
		/**
		 * Gets the parent of the SubTask
		 * 
		 * @return Task parent of SubTask
		 */
		public Task getParentTask() {
			return parentTask;
		}
		
		/**
		 * Gets the number of SubTask hours
		 * 
		 * @return number of SubTask hours
		 */
		public int getSubTaskHours() {
			return hours;
		}
		
		/**
		 * Determines whether SubTask overflowed
		 * 
		 * @return overflow status
		 */
		public boolean getOverflow() {
			return overflow;
		}
		
		@Override
		public String toString() {
			return "SubTask [name=" + name + ", hours=" + hours + "]";
		}

		@Override
		public int compareTo(SubTask o) {
			return this.parentTask.compareTo(o.parentTask);
		}
	}
}
