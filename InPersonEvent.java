package itp265_FinalProject_stevengo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public class InPersonEvent extends Event implements Serializable, AgeRestricted{
	
	// INSTANCE VARIABLES
	private Location location;
	private String attire;
	private int numPluses;
	private int MIN_DRINKING_AGE = 21;

	// CONSTRUCTORS
	
	// Called when creating an event from file data
	public InPersonEvent(String eventName, LocalDateTime time, Host host, EventType type, Location location, String attire) {
		super(eventName, time, host, type);
		this.location = location;
		this.attire = attire;
	}
	
	public InPersonEvent(String eventName, int year, int month, int day, int hour, int minute, Host host, int numGuests,
			Location location, String attire, int numPluses, EventType type) {
		super(eventName, year, month, day, hour, minute, host, numGuests, type);		
		this.location = location;
		this.attire = attire;
		this.numPluses = numPluses;
	}

	// GETTERS AND SETTERS
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the attire
	 */
	public String getAttire() {
		return attire;
	}

	/**
	 * @param attire the attire to set
	 */
	public void setAttire(String attire) {
		this.attire = attire;
	}

	/**
	 * @return the numPluses
	 */
	public int getNumPluses() {
		return numPluses;
	}

	/**
	 * @param numPluses the numPluses to set
	 */
	public void setNumPluses(int numPluses) {
		this.numPluses = numPluses;
	}

	@Override
	public String toString() {
		return "InPersonEvent [location=" + location + ", attire=" + attire + ", numPluses=" + numPluses + "]";
	}
	
	@Override
	public String toFileString() {
		String fileLine = super.getType() + "/" + super.getEventName() + "/" + super.getTime() + "/"
				+ super.getHost().getName() + "/" + super.getHost().getEmail() + "/" + getLocation() 
				+ "/" + getAttire();
		return fileLine;
	}
	
	@Override
	public int getAgeLimit() {
		return MIN_DRINKING_AGE;
	}
}
