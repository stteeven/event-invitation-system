package itp265_FinalProject_stevengo;
import java.io.Serializable;
import java.time.*;
import java.util.*;



/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public abstract class Event implements Serializable {

	// INSTANCE VARIABLES
	private String eventName;
	private LocalDateTime time;
	private Map<String, Guest> guestMap; 
	private ArrayList<Guest> guestsGoing;
	private Host host;
	private int numGuests;
	private EventType type;

	// CONSTRUCTORS
	
	// Doesn't include numGuests-- used to create Event from fileToString
	public Event(String eventName, LocalDateTime time, Host host, EventType type) { // takes in LocalDateTime
		this.eventName = eventName;
		this.time = time;
		this.host = host;
		this.guestMap = new HashMap<String, Guest>();
		this.type = type;
		this.guestsGoing = new ArrayList<Guest>();
	}	
	
	// Takes in numGuests
	public Event(String eventName, LocalDateTime time, Host host, int numGuests, EventType type) {
		this(eventName, time, host, type);
		this.numGuests = numGuests;
	}
	
	// Generates time through integer inputs
	public Event(String eventName, int year, int month, int day, int hour, int minute, Host host, int numGuests, EventType type) {
		this(eventName, LocalDate.of(year, month, day).atTime(hour, minute), host, numGuests, type);
		this.guestMap = new HashMap<String, Guest>();
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", time=" + time + ", guestMap=" + guestMap + ", host=" + host
				+ ", numGuests=" + numGuests + "]";
	}
	
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the time
	 */
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/**
	 * @return the guestMap
	 */
	public Map<String, Guest> getGuestMap() {
		return guestMap;
	}

	/**
	 * @param guestMap the guestMap to set
	 */
	public void setGuestMap(Map<String, Guest> guestMap) {
		this.guestMap = guestMap;
	}

	/**
	 * @return the host
	 */
	public Host getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(Host host) {
		this.host = host;
	}

	/**
	 * @return the numGuests
	 */
	public int getNumGuests() {
		return numGuests;
	}

	/**
	 * @param numGuests the numGuests to set
	 */
	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	/**
	 * @return the type
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(EventType type) {
		this.type = type;
	}
	
	/**
	 * @return the guestsGoing
	 */
	public ArrayList<Guest> getGuestsGoing() {
		return guestsGoing;
	}

	/**
	 * @param guestsGoing the guestsGoing to set
	 */
	public void setGuestsGoing(ArrayList<Guest> guestsGoing) {
		this.guestsGoing = guestsGoing;
	}

	protected abstract String toFileString();
	
//	protected abstract int getAgeLimit();
}
