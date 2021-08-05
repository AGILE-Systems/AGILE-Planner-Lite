package agile.planner.user.config;

import agile.planner.user.Client;

/**
 * Stores all Client information as to AGILE Planner systems configurations
 * 
 * @author Andrew Roe
 */
public class ProfileConfig {
	
	/** Key client information as to name, email, etc. */
	private Client client;
	/** Key week configuration information such as number of hours for a given day */
//	private WeekManager weekManager;
	
	/**
	 * Primary constructor for ProfileConfig
	 * 
	 * @param client Client of the system
	 * @param weekManager configuration details for the week days
	 */
//	public ProfileConfig(Client client, WeekManager weekManager) {
//		setClient(client);
//		this.weekManager = weekManager;
//	}
	
	/**
	 * Gets the Client from the profile configuration
	 * 
	 * @return Client
	 */
	public Client getClient() {
		return client;
	}
	
	/**
	 * Sets the Client for the profile configuration
	 * 
	 * @param client Client to be set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * Gets the WeekManager from the profile configuration
	 * 
	 * @return WeekManager
	 */
//	public WeekManager getWeekManager() {
//		return weekManager;
//	}
	
	/**
	 * Sets the WeekManager for the profile configuration
	 * 
	 * @param weekManager WeekManager to be set
	 */
//	public void setWeekManager(WeekManager weekManager) {
//		this.weekManager = weekManager;
//	}

}