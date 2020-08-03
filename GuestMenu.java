package itp265_FinalProject_stevengo;

/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public enum GuestMenu {
	
	LOAD_FAKE_DATA("Load Fake Data"),
	VIEW_INVITES("View Invitations"),
	RSVP("RSVP For An Event"),
	REGISTER_PLUSES("Register Plus Ones and More"),
	QUIT("Exit Passenger menu");
	
	private String displayString;
	
	private GuestMenu(String display){
		this.displayString = display;
	}
	
	public String getDisplayString(){
		return this.displayString;
	}
	
	public static String displayGuestMenu() {
		String prompt = "";

		for(GuestMenu m : GuestMenu.values()){ //array from the enum
			prompt += "\n" + (m.ordinal() + 1) + ": " + m.getDisplayString();
		}
		return prompt;
	}
}
