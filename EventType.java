package itp265_FinalProject_stevengo;

import java.io.Serializable;

/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public enum EventType implements Serializable {
	
	POTLUCK, 
	GIFTEXCHANGE,
	BIRTHDAY,
	BABYSHOWER,
	MIXER,
	WEDDING, 
	HOLIDAY;
	
	public static String makeEventTypeMenu() {
		
		String categoryMenu = "Choose a category to view items: ";
		for(EventType t : EventType.values()){
			categoryMenu += "\n" + (t.ordinal() + 1)
					+ ": " + t.name();	
		}
		return categoryMenu;
	}
	
	
}
