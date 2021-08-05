package agile.planner.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import agile.planner.exceptions.InvalidUserException;

/**
 * Client of the AGILE Systems Planner. Holds key credential information
 * 
 * @author Andrew Roe
 */
public class Client {
	
	/** Name of the Client */
	private String name;
	/** Email of the Client */
	private String email;
	/** Local password of the Client */
	private String pw;
	/** String record of the last login by Client */
	private String lastLoginTime;
	
	/**
	 * Primary constructor for Client
	 * 
	 * @param name name of Client
	 * @param email email of Client
	 * @param pw local password of Client
	 * @throws InvalidUserException thrown if name, email, or local password are invalid
	 */
	public Client(String name, String email, String pw) throws InvalidUserException {
		setName(name);
		setEmail(email);
		setLocalPassword(pw);
		this.lastLoginTime = new SimpleDateFormat("[dd-MM-yyyy|HH:mm:ss]").format(Calendar.getInstance().getTime());
	}

	/**
	 * Sets the name of the Client
	 * 
	 * @param name name to be set
	 * @throws InvalidUserException thrown if name is empty or null
	 */
	public void setName(String name) throws InvalidUserException {
		if(name == null || "".equals(name)) {
			throw new InvalidUserException("Name cannot be null or empty");
		}
		this.name = name;
	}

	/**
	 * Gets the name of the Client
	 * 
	 * @return name of Client
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the email of the Client
	 * 
	 * @param email email to be set
	 * @throws InvalidUserException thrown if email is empty or null
	 */
	public void setEmail(String email) throws InvalidUserException {
		if(email == null || "".equals(email)) {
			throw new InvalidUserException("Email cannot be null or empty");
		}
		this.email = email;
	}

	/**
	 * Gets the mail of the Client
	 * 
	 * @return email of Client
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the local password of the Client
	 * 
	 * @param pw local password to be set
	 * @throws InvalidUserException thrown if local password is empty or null
	 */
	public void setLocalPassword(String pw) throws InvalidUserException {
		if(pw == null || "".equals(pw)) {
			throw new InvalidUserException("Password cannot be null or empty");
		}
		this.pw = pw;
	}

	/**
	 * Gets the local password of the Client
	 * 
	 * @return local password of Client
	 */
	public String getLocalPassword() {
		return pw;
	}

	/**
	 * Gets the last login date and time of the Client
	 * 
	 * @return last login date and time of the Client
	 */
	public String getLasLoginTime() {
		return lastLoginTime;
	}

}
