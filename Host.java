package itp265_FinalProject_stevengo;
import java.util.*;
import java.io.Serializable;
import java.time.*;


/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public class Host extends User implements Serializable{

	// INSTANCE VARIABLES
	private boolean isPremium; 
	private ArrayList<Event> eventList;
	
	// CONSTRUCTORS
	public Host(String email, String name) {
		super(email, name);
		this.eventList = new ArrayList<Event>();
	}
	
	public Host(String name, LocalDate birthday, String email, String password, boolean isPremium, ArrayList<Event> eventList) {
		super(name, birthday, email, password);
		this.isPremium = isPremium;
		this.eventList = new ArrayList<Event>();
	}
	
	public Host(User user, boolean isPremium, ArrayList<Event> eventList) {
		super(user.getName(), user.getBirthday(), user.getEmail(), user.getEmail());
		this.isPremium = isPremium;
		this.eventList = new ArrayList<Event>();
		
	}

	@Override
	public String toString() {
		return "Host [isPremium=" + isPremium + ", eventList=" + eventList + "]";
	}

	/**
	 * @return the isPremium
	 */
	public boolean isPremium() {
		return isPremium;
	}

	/**
	 * @param isPremium the isPremium to set
	 */
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	/**
	 * @return the eventList
	 */
	public ArrayList<Event> getEventList() {
		return eventList;
	}

	/**
	 * @param eventList the eventList to set
	 */
	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}
	
	
}
