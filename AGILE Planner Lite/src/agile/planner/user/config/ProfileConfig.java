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
	private int[] weekConfigHours;
	/** Determines whether to utilize the distributive mode or not */
	private boolean distributiveMode;
	
	private ProfileConfig(Client client, boolean distributiveMode) {
		//TODO we need to read in the data from the config file
		setClient(client);
		setWeekConfig();
		setDistributiveMode(distributiveMode);
	}
	
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
	 * @return TODO
	 */
	public int[] getWeekManager() {
		return null;
	}
	
	public void setWeekConfig() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sets the WeekManager for the profile configuration
	 */
	public void setWeekManager() {
		
	}
	
	public boolean getDistributiveMode() {
		return distributiveMode;
	}
	
	public void setDistributiveMode(boolean distributiveMode) {
		this.distributiveMode = distributiveMode;
	}

}