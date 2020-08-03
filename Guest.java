package itp265_FinalProject_stevengo;
import java.util.*;
import java.time.*;

/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public class Guest extends User{
	
	// INSTANCE VARIABLES
	private ArrayList<Event> eventInvitations;
	private Map<String, Guest> pluses;
	private boolean isOriginalGuest; // original guests can invite pluses

	// CONSTRUCTORS
	
	// Simplest constructor, called when host is inviting guests
	public Guest(String email, String name) {
		super(email, name);
		this.eventInvitations = new ArrayList<Event>();
		this.pluses = new HashMap<String, Guest>();
		this.isOriginalGuest = true;
	}
	
	public Guest(String name, LocalDate birthday, String email, String password, ArrayList<Event> eventInvitations,
			Map<String, Guest> pluses, boolean isOriginalGuest) {
		super(name, birthday, email, password);
		this.eventInvitations = eventInvitations;
		this.pluses = pluses;
		this.isOriginalGuest = isOriginalGuest;
	}
	
	public Guest(User user, ArrayList<Event> eventInvitations, Map<String, Guest> pluses, boolean isOriginalGuest) {
		super(user.getName(), user.getBirthday(), user.getEmail(), user.getEmail());
		this.eventInvitations = eventInvitations;
		this.pluses = pluses;
		this.isOriginalGuest = isOriginalGuest;
	}
	

	// GETTERS AND SETTERS
	/**
	 * @return the eventInvitations
	 */
	public ArrayList<Event> getEventInvitations() {
		return eventInvitations;
	}

	/**
	 * @param eventInvitations the eventInvitations to set
	 */
	public void setEventInvitations(ArrayList<Event> eventInvitations) {
		this.eventInvitations = eventInvitations;
	}

	/**
	 * @return the plusOnes
	 */
	public Map<String, Guest> getPluses() {
		return pluses;
	}

	/**
	 * @param plusOnes the plusOnes to set
	 */
	public void setPluses(Map<String, Guest> pluses) {
		this.pluses = pluses;
	}

	/**
	 * @return the isOriginalGuest
	 */
	public boolean isOriginalGuest() {
		return isOriginalGuest;
	}

	/**
	 * @param isOriginalGuest the isOriginalGuest to set
	 */
	public void setOriginalGuest(boolean isOriginalGuest) {
		this.isOriginalGuest = isOriginalGuest;
	}

	@Override
	public String toString() {
		return "Guest [eventInvitations=" + eventInvitations + ", pluses=" + pluses + ", isOriginalGuest="
				+ isOriginalGuest + "]";
	}
	
	

}
