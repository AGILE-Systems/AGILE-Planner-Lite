package agile.planner.ui;

import agile.planner.manager.ScheduleManager;

/**
 * Basic Command Line UI
 * 
 * @author Andrew Roe
 */
public class SimpleUI {

	/**
	 * Starting point of the application from a terminal perspective
	 * 
	 * @param args command line arguments (none used)
	 */
	public static void main(String[] args) {
		ScheduleManager sm = ScheduleManager.getSingleton();
		sm.outputSchedule();
	}

}
