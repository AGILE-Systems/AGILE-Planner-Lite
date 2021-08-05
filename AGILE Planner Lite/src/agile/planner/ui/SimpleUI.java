package agile.planner.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import agile.planner.io.Commands;
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
		
		System.out.println("Welcome to AGILE Planner 0.0.1\r\n"
				+ "\r\n"
				+ "2021-08-04 Changelog:\r\n"
				+ "-Added task balancing for schedule generation\r\n"
				+ "-Added distributive learning mode for scheduling\r\n"
				+ "-Added archive system for garbage collection\r\n"
				+ "-Added IO processing to system\r\n"
				+ "-Added Command Line UI\r\n"
				+ "-Fixed time handling of tasks and days\r\n"
				+ "\r\n"
				+ "For a complete list of commands, enter: list\r\n"
				+ "\r\n"
				+ "To view the manual for a command, enter: man <command>\n\n");
		ScheduleManager sm = ScheduleManager.getSingleton();
		
		HashMap<String, String> commandSheet = Commands.getSingleton().getCommandsSheet();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		
		
		Scanner strScanner = new Scanner(System.in);
		while(true) {
			System.out.print("> ");
			String input = strScanner.nextLine();
			
			if("time".equals(input)) {
				System.out.println(sdf.format(Calendar.getInstance().getTime()));
			} else if("schedule".equals(input)) {
				sm.outputSchedule();
			} else if("add".equals(input)) {
				
			} else if("remove".equals(input)) {
				
			} else if("edit".equals(input)) {
				
			} else if("view".equals(input)) {
				
			} else if("log".equals(input)) {
				
			} else if("print".equals(input)) {
				
			} else if("read".equals(input)) {
				
			} else if("quit".equals(input)) {
				break;
			} else if(commandSheet.containsKey(input)) {
				System.out.println(commandSheet.get(input));
			}
		}
		strScanner.close();
	}

}
