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
public class VirtualEvent extends Event implements Serializable{
	
	// INSTANCE VARIABLES
	private String link;
	private String platform;

	// CONSTRUCTOR
	public VirtualEvent(String eventName, int year, int month, int day, int hour, int minute, Host host, int numGuests,
			String link, String platform, EventType type) {
		super(eventName, year, month, day, hour, minute, host, numGuests, type);
		this.link = link;
		this.platform = platform;
	}
	// Called when creating an event from file data
	public VirtualEvent(String eventName, LocalDateTime time, Host host, EventType type, String link, String platform) {
		super(eventName, time, host, type);
		this.link = link;
		this.platform = platform;
	}
	
	// GETTERS AND SETTERS
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	@Override
	public String toString() {
		return "VirtualEvent [link=" + link + ", platform=" + platform + "]";
	}
	
	@Override
	public String toFileString() {
		String fileLine = super.getType() + "/" + super.getEventName() + "/" + super.getTime() + "/"
				+ super.getHost().getName() + "/" + super.getHost().getEmail() + "/" + getLink()
				+ "/" + getPlatform();
		return fileLine;
	}
	

}
