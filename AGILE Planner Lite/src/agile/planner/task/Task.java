package agile.planner.task;

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
	private int date;
	/** Total number of hours for the Task */
	private int total;
	/** Number of SubTask hours */
	private int subTotal;
	
	/**
	 * Primary constructor for Task
	 * 
	 * @param name name of Task
	 * @param total number of hours for Task
	 * @param date due date for Task
	 */
	public Task(String name, int total, int date) {
		setName(name);
		setTotalHours(total);
		setDueDate(date);
	}
	
	/**
	 * Adds a SubTask for a given Task
	 * 
	 * @param hours number of hours
	 * @return SubTask
	 */
	public SubTask addSubTask(int hours) {
		SubTask st = null;
		if(hours > 0 && subTotal + hours <= total) {
			st = new SubTask(this, hours);
			subTotal += hours;
		}
		return st;
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
		if(this.date < o.date || this.date == o.date && this.getSubTotalRemaining() > o.getSubTotalRemaining()) {
			return -1;
		} else if(this.date > o.date || this.date == o.date && this.getSubTotalRemaining() < o.getSubTotalRemaining()) {
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
	public int getDueDate() {
		return date;
	}

	/**
	 * Sets the due date of the Task
	 * 
	 * @param date due date of Task
	 */
	private void setDueDate(int date) { //TODO will need to include exceptions for the setters
		this.date = date;
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

	@Override
	public String toString() {
		return "Task [name=" + name + ", total=" + total + ", date=" + date + "]";
	}
	
	
	/**
	 * The individual component of a parent Task in the form of a SubTask
	 * 
	 * TODO will need to include a markComplete() method
	 * 
	 * @author Andrew Roe
	 */
	public class SubTask {
		
		/** Parent Task of the SubTask */
		private Task parentTask;
		/** Number of hours for the SubTask */
		private int hours;
		
		/**
		 * Primary constructor for SubTask
		 * 
		 * @param parentTask parent of the SubTask
		 * @param hours number of hours for the SubTask
		 */
		private SubTask(Task parentTask, int hours) {
			this.parentTask = parentTask;
			this.hours = hours;
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
		
		@Override
		public String toString() {
			return "SubTask [name=" + name + ", hours=" + hours + ", date=" + date + "]";
		}
	}
}