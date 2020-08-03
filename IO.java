package itp265_FinalProject_stevengo;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * IO is a utility class for ITP 265 that helps provide a friendly way to read input from
 * a user and verify that the input is correct.
 * 
 * @author Kendra Walther
 * ITP 265, 20201
 * Week #03
 * Email: kwalther@usc.edu and stevengo@usc.edu
 *
 */

public class IO {

	private Scanner sc;
	
	
	/**
	 * Constructor sets up a Scanner to be used by the class in order to read input from the standard console window (System.in)
	 */
	public IO() {
		sc = new Scanner(System.in);
	}
	
	/**
	 * Short-cut helper method that prints a String with a series of stars around it.
	 * @param output: The String to be printed
	 */
	public void printPretty(String output) {
		System.out.println("***********************************************************************************************");
		System.out.println(output);
		System.out.println("***********************************************************************************************");
	}
	/**
	 * Prompt the user and read one line of text as a String
	 * @param prompt: the question to ask the user
	 * @return: a line of user input (including spaces, until they hit enter)
	 */
	public String inputLine(String prompt) {
		System.out.println(prompt);
		return sc.nextLine();
	}
	
	/**
	 * Prompt the user and read one word of text as a String
	 * @param prompt: the question to ask the user
	 * @return: a one word String - if the user enters multiple words, all other input until the return will be discarded.
	 */
	public String inputWord(String prompt) {
		System.out.println(prompt);
		String word = sc.next();
		sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
		return word;
	}
	
	/**
	 * Prompt the user and read one word - which must match either option1 or option2 parameters.
	 * @param prompt: the question to ask the user (should include the two valid options the user should choose from)
	 * @param option1 : One string option for the user to choose.
	 * @param option2: the other string option for the user to choose.
	 * @return: A string matching either option1 or option2
	 */
	public String inputWord(String prompt, String option1, String option2) {
		// Prompt user to choose an option
		System.out.println(prompt);
		String word = sc.next().toLowerCase();
		sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
		// If the user inputs an invalid answer, loop until user inputs valid answer
		while (!(word.equals(option1) || word.equals(option2))) {
			System.out.println("Please enter one of the two valid options.");
			System.out.println(prompt);
			word = sc.next().toLowerCase();
			sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
		}
		return word;
	}
	/**
	 * Prompt the user and read an int, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: an int 
	 */
	public int inputInt(String prompt) {
		System.out.println(prompt);
		// if scanner does not see an int, get rid of garbage and ask again.
		while (!sc.hasNextInt()) {
			String garbage = sc.nextLine();
			System.out.println("Didn't recognize " + garbage + " as an integer...");
			System.out.println(prompt);
		}
		int num = sc.nextInt();
		sc.nextLine(); // clear the buffer
		return num;
	}
	
	/** Prompt the user and read positive int, clearing whitespace or the enter after {@link #clone()}
	 * @param promtpt: ask user a q
	 * @return: an int >= 0
	 */
	public int inputPositiveInt(String prompt) {
		int num = inputInt(prompt); //off load the work to the method we already wrote
		while (num<0) { // while bad 
			System.out.println("Need a positive number: " + num + " does not qualify");
			num = inputInt(prompt);
		}
		return num;
	}
	
	/**
	 * Prompt the user and read an int between (inclusive) of minValue and maxValue, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: an int between minValue and maxValue
	 */
	public int inputIntInRange(String prompt, int minValue, int maxValue) {
		int num = inputInt(prompt);
		while (num < minValue || num > maxValue) {
			System.out.println("Please enter a number between " + minValue + " and " + maxValue + "(inclusive).");
			num = inputInt(prompt);
		}
		return num;
	}
	
	/**
	 * Prompt the user and read a floating point number, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: a double value 
	 */
	public double inputDouble(String prompt) {
		System.out.println(prompt);
		System.out.println("not yet implemented, returning 0");
		return 0.0;
	}
	/**
	 * Prompt the user and read a boolean value, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: a boolean value 
	 */
	public boolean inputBoolean(String prompt) {
		System.out.println(prompt);
		System.out.println("not yet implemented, returning false");
		return false;
	}
	
	/**
	 * Prompt the user enter yes or no (will match y/yes and n/no any case) and return true for yes and false for no.
	 * @param prompt: the question to ask the user 
	 * @return: a boolean value 
	 */
	public boolean inputYesNoAsBoolean(String prompt) {
		System.out.println(prompt);
		// if scanner is seeing BAD input... loop to get good input
		String answer = sc.nextLine().toLowerCase();
		while ( ! (answer.equals("y") || answer.equals("yes") 
					|| answer.equals("n") || answer.equals("no") )) {
		
			System.out.println("Didn't recognize " + answer + " as yes or no...");
			System.out.println(prompt);
			answer = sc.nextLine().toLowerCase();
		}
		//end of loop = good input
		
	
		if(answer.equals("y") || answer.equals("yes")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Prompt the user to input the information necessary to construct a User and returns this user.
	 * @return: a User object
	 */
	public User inputUser() {
		String name = this.inputLine("Please enter your name:");
		int year = this.inputIntInRange("Please enter year of birth:", 1900, LocalDate.now().getYear());
		int month = this.inputIntInRange("Please enter month of birth:", 1, 12);
		int day = this.inputIntInRange("Please enter date of birth:", 1, Month.of(month).maxLength());
		String email = this.inputWord("Please enter your email:");
		String password = this.inputWord("Please enter your password:");
		User user = new User(name, year, month, day, email, password);
		return user;
	}
	
	/**
	 * Prompt the user to input the information necessary to construct a Guest and returns this guest.
	 * @return: a Guest object
	 */
	public Guest inputGuest() {
		String name = this.inputLine("Please enter your name:");
		String email = this.inputWord("Please enter your email:");
		Guest guest = new Guest(email, name);
		return guest;
	}
	
	/**
	 * Prompt the user to input an integer that corresponds with an event type and returns the type
	 * @return: an EventType enum
	 */
	public EventType chooseEventType() {
		EventType type = null;
		System.out.println(EventType.makeEventTypeMenu()); // display a numbered menu of event type
		int typeNum = this.inputIntInRange("What kind of event do you want to create?", 1, EventType.values().length); // get user choice
		type = EventType.values()[typeNum-1]; // get the type based on the user's input
		return type;
	}
		
	/**
	 * Prompt the user to input the info needed to construct an event and returns the event
	 * @param a Host object
	 * @return: an EventType enum
	 */
	public Event inputEvent(Host host) {
		EventType type = this.chooseEventType();
		String eName = this.inputLine("What would you like to name your event? ");
		int year = this.inputIntInRange("When will it be? Enter the year:", LocalDate.now().getYear(), LocalDate.now().getYear() + 30);
		int month = this.inputIntInRange("When will it be? Enter the month:", 1, 12);
		int day = this.inputIntInRange("When will it be? Enter the date:", 1, Month.of(month).maxLength());
		int hour = this.inputIntInRange("What time will the event be? Enter the hour (military time): ", 0, 23);
		int minute = this.inputIntInRange("What time will the event be? Enter the minute:", 0, 59);
		int numGuests = this.inputPositiveInt("How many guests would you like to invite? ");
		boolean isVirtual = this.inputYesNoAsBoolean("Will your event be virtual? (y/n) ");
		
		// if yes, follow the steps to create a virtual event
		if (isVirtual) {
			this.printPretty("Create a Virtual Event"); // print a nice heading
			String platform = this.inputWord("On what platform will you event take place? (Zoom, FaceTime, Hangouts, etc.): ");
			String link = this.inputWord("Attach the event link here: ");
			
			VirtualEvent vEvent = new VirtualEvent(eName, year, month, day, hour, minute, 
					host, numGuests, link, platform, type);
			return vEvent;
		}
		// otherwise, create an in-person event
		else {
			this.printPretty("Create an In-person Event: Location"); // print a nice heading
			String strAddress = this.inputLine("What's the street address of your event? ");
			String city = this.inputLine("What's the city? ");
			String state = this.inputLine("What's the state? ");
			String country = this.inputLine("What's the country? ");
			int zip = this.inputPositiveInt("What's the zip code? ");
			
			Location loc = new Location(country, state, city, zip, strAddress); // create event location
			
			this.printPretty("Create an In-person Event: Additional Details"); // print a nice heading
			String attire = this.inputLine("What's the attire for the event? ");
			int numPluses = this.inputIntInRange("How many pluses can each guest bring? ", 0, 10);
			
			InPersonEvent ipEvent = new InPersonEvent(eName, year, month, day, hour, minute, 
					host, numGuests, loc, attire, numPluses, type);
			
			// Get drinking age
			boolean ageRestricted = this.inputYesNoAsBoolean("Will attendees have to be above the legal drinking age? ");
			if (ageRestricted ) {
				System.out.println("Minimum age limit: " + ipEvent.getAgeLimit());
			}
			return ipEvent;
		}
	}
	
}