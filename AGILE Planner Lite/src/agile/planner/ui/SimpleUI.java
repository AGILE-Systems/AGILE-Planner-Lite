/**
 * 
 */
package agile.planner.ui;

import agile.planner.manager.ScheduleManager;

/**
 * @author Andrew Roe
 *
 */
public class SimpleUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduleManager sm = ScheduleManager.getSingleton();
		sm.outputSchedule();
	}

}
