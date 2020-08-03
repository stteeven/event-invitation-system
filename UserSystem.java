package itp265_FinalProject_stevengo;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Description
 * @author Steven Gong
 * Assignment Details
 * Email: stevengo@usc.edu
 */
public class UserSystem implements Serializable{
 
	//INSTANCE VARIABLES
	private static final String HOST_MENU = ""
			+ "\n1: Create an event"
			+ "\n2: Send invites" 
			+ "\n3: View guest list"
			+ "\n4: View events"
			+ "\n5: Exit";
	private IO helper;
	private Map<String, User> users; // map of unique email address to user objects
	private static final String USER_FILE = "src/users.txt";
	private static final String EVENTS_FILE = "src/events.txt";

	//CONSTRUCTOR
	public UserSystem() {
		this.helper = new IO();
		this.users = new HashMap<>();
	}
	
	// Displays and runs the program features for guests
	public void runGuestMenu(Guest guest) {
		System.out.println("Welcome to the Guest Menu!");
		int choice = helper.inputIntInRange(GuestMenu.displayGuestMenu(), 1, GuestMenu.values().length);
		GuestMenu menuChoice = GuestMenu.values()[choice-1];
		while( menuChoice != GuestMenu.QUIT) {
			switch(menuChoice) {
			case LOAD_FAKE_DATA: 
				loadFakeData(guest);
				break;
			case VIEW_INVITES:
				System.out.println("Events you're invited to: ");
				displayInvites(guest);
				break;
			case RSVP: 
				System.out.println("Choose an event to RSVP to: ");
				displayInvites(guest);
				int eventSelection = helper.inputIntInRange("Please select the event you want to RSVP to: ", 0, guest.getEventInvitations().size()-1);
				Event e = guest.getEventInvitations().get(eventSelection); // select the event chosen by user
				e.getGuestsGoing().add(guest);
				System.out.println("You've successfully RSVP'd! You are now on the \"going\" list.");
				break;
			case REGISTER_PLUSES:
				// TODO: Have users input another user and add them to the event guestList
				System.out.println("Will implement in V2!");
				break;
			}
			choice = helper.inputIntInRange(GuestMenu.displayGuestMenu(), 1, GuestMenu.values().length);
			menuChoice = GuestMenu.values()[choice-1];	
		}
		System.out.println("Goodbye!");
	}
	
	// Displays and runs the program features for hosts
	public void runHostMenu(Host host) throws IOException, ClassNotFoundException {
		System.out.println("Welcome to the Host Menu!");
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.print(HOST_MENU); // print host menu
			int menuChoice = helper.inputIntInRange(">", 1, 5); // get user's menu choice
			if (menuChoice == 1) { // Create a new event
				System.out.println("Create a new event through helper");
				createNewEvent(host);
				writeEventsToFile(host);
			}
			else if (menuChoice == 2) { // Send invites by adding the event to guests' invite list
				if (host.getEventList().isEmpty()) {
					readExistingEventsFromFile(host);
				}
//				
				displayEventList(host); // print the host's event list
				int eventSelection = helper.inputIntInRange("Please select the event you want to invite guests to: ", 0, host.getEventList().size());
				Event e = host.getEventList().get(eventSelection); // select the event chosen by user
				boolean cont = true;
				while (cont) {
					System.out.println("Please input the guest you would like to invite: ");
					Guest invitedGuest = helper.inputGuest(); // Get guest from input
					e.getGuestMap().put(invitedGuest.getEmail(), invitedGuest); // Add invited guest to guestMap
					invitedGuest.getEventInvitations().add(e); // add event to guest's invite list
					cont = helper.inputYesNoAsBoolean("Would you like to invite another guest? ");
				}
			}
			else if (menuChoice == 3) { // Print guest list
				if (host.getEventList().isEmpty()) { // read in events from file if it's empty
					readExistingEventsFromFile(host);
				}
				displayEventList(host);
				int eventSelection = helper.inputIntInRange("Which event would you like to see the guest list for? ", 0, host.getEventList().size());
				Event e = host.getEventList().get(eventSelection); // select the event chosen by user
				// loop through the guestMap and display each guest
				String s = "Map of All Guests:\n";
				if (e.getGuestMap().isEmpty()) {
					System.out.println("Guest list is empty.");
				}
				else {
					for(String key: e.getGuestMap().keySet()) { // for each key in the guest map of keys...
						Guest value = e.getGuestMap().get(key); // get the object associated with the key
						s += "\t" + key + ": "+ value.getName() + "\n";
					}
					System.out.println(s); // Print out a string of all the users
				}
				
			}
			else if (menuChoice == 4) { // 
				if (host.getEventList().isEmpty()) { // read in events from file if it's empty
					readExistingEventsFromFile(host);
				}
				displayEventList(host);
			}
			else if (menuChoice == 5) {
				System.out.println("Goodbye!");
				keepGoing = false;
				break;
			}
		}
	}
	
	// Loads fake events that the guest is invited to
	public void loadFakeData(Guest guest) {
		readExistingEventsFromFile(guest);
	}
	
	// Prints out each event in the host's event list
	public void displayEventList(Host host) {
		for (Event e: host.getEventList()) { // Have host select an event to invite guests to
			// print the index number and event details of each event
			System.out.println(host.getEventList().indexOf(e) + ": " + e.toFileString());
		}
	}
	
	// Displays all the events that the guest is invited to from Event Invitations list
	public void displayInvites(Guest guest) {
		for (Event e: guest.getEventInvitations()) {
			// print the index number and event details of each event
			System.out.println(guest.getEventInvitations().indexOf(e) + ": " + e.toFileString());
		}
	}
	
	// Logs in the user by getting their information and matching it to the file w/ user info
	// returns the user
	public User login() {
		helper.printPretty("LOGIN"); // display a nice heading
		User u = null; // initialize user variable
		
		boolean keepGoing = true;
		while (keepGoing) {
			String loginEmail = helper.inputWord("Enter your login email: ");
			String loginPass = helper.inputWord("Enter your password: ");
			
			// return user if the login is successful
			if (users.containsKey(loginEmail) && 
				users.get(loginEmail).getPassword().contentEquals(loginPass)) {
				
				// print welcome statement
				System.out.println("Welcome, " + users.get(loginEmail).getName() + "!");
				keepGoing = false;
				u = users.get(loginEmail); // return user
			}
			
			else {
				System.out.println("User email or password was incorrect. Please try again: \n");
				keepGoing = true;
			}
		}
		return u;
	}
	
	// Creates a new user
	public void createNewUser() {
		helper.printPretty("CREATE NEW ACCOUNT"); // display a nice heading
		//GET THE DATA NEEDED TO MAKE THE USER
		User newUser = helper.inputUser();
		// if the user already exists, don't want to create one
		if(users.containsKey(newUser.getEmail())) {
			System.err.println("This user already exist in the system.");
		}
		else {
			users.put(newUser.getEmail(), newUser);// add the user to the map
		}
	}
	
	// Creates a new event and adds it to the host's event list
	public void createNewEvent(Host host) {
		helper.printPretty("CREATE NEW EVENT"); // display a nice heading
		Event e = helper.inputEvent(host); // create an event from user input
		ArrayList<Event> eventList = host.getEventList(); // get the eventList
		
		// don't create a new one if it already exists
		if(eventList.contains(e)) {
			System.err.println("This event has already been created.");
		}
		else {
			eventList.add(e); // add new event to the list
		}
	}

	// Writes events from host's event list to a file
	private void writeEventsToFile(Host host) {
		
		System.out.println("Account info has been added to: " + EVENTS_FILE);
		try (FileWriter fw = new FileWriter(EVENTS_FILE, true);
			PrintWriter pw = new PrintWriter(fw, true)) { // set second parameter to "true" in order to append
			ArrayList<Event> events = host.getEventList();
			// take each user in the host's ArrayList and write it to the file.
			for (Event e: events) {
				pw.println(e.toFileString()); // implement this function
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // automatically close resources at end
	}
	
	// Takes in a string and reads it as DateTime and returns this object
	public LocalDateTime parseTime(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime time = LocalDateTime.parse(s, formatter);
		return time;
	}
    
	// Parse string into location and returns a location
	public Location parseLocation(String s) {
		Scanner locReader = new Scanner(s);
		locReader.useDelimiter(",");
		String street = locReader.next();
		String city = locReader.next();
		String state = locReader.next();
//		String zipStr = locReader.next();
		int zip = locReader.nextInt();
		Location loc = new Location(street, city, state, zip); // construct a location
		locReader.close(); // close the scanner
		return loc;
	}
	
	// Takes a line from our file and turns it into a user object
	// Returns an event object
	private Event parseLineToEvent(String line) {
		// line needs to be broken apart into tokens. (Use Scanner)
		Scanner lineReader = new Scanner(line);
		lineReader.useDelimiter("/"); // instead of white space, use the / as the thing that breaks the line apart
		// good lines will either have 3 tokens or 5 tokens.
		String typeStr = lineReader.next(); // email is always first in the line from the file
		EventType type = EventType.valueOf(typeStr); // convert String to EventType
		String eName = lineReader.next(); // name is always second in the line from the file
		String timeStr = lineReader.next(); // Time is always third in the line from the file
		LocalDateTime time = parseTime(timeStr); // parse time string into a DateTime object
		String hostName = lineReader.next(); // Host name is fourth
		String hostEmail = lineReader.next(); // Host email is fifth
		Host host = new Host(hostEmail, hostName);
		if (lineReader.hasNext(",")) { // if the next line contains a location
			String locationStr = lineReader.next(); // parse this individually
			Location loc = parseLocation(locationStr);  // parse location string into Location
			String attire = lineReader.next();
			InPersonEvent ipEvent = new InPersonEvent(eName, time, host, type, loc, attire);
			lineReader.close(); // close file
			return ipEvent;
		}
		else {
			String link = lineReader.next();
			String platform = lineReader.next();
			VirtualEvent vEvent = new VirtualEvent(eName, time, host, type, link, platform);
			lineReader.close();
			return vEvent;
		}
	}
	
	// Takes in a line from the file and turns it into an event, then adds it to the host's event list
	private void readExistingEventsFromFile(Host host) {
		try(FileInputStream fis = new FileInputStream(EVENTS_FILE);
				Scanner scan = new Scanner(fis))	{  
			while(scan.hasNextLine()) {
				String line = scan.nextLine(); // each line is a user in the system
				Event e = parseLineToEvent(line);
				//once we have an, put it a host's eventList
				host.getEventList().add(e);
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found exception in readExistingEventsFromFile");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException in readExistingEventsFromFile");
			e.printStackTrace();
		}
	}
	
	// Reads in each line from the file as an event and adds it to guest's invitation list
	private void readExistingEventsFromFile(Guest guest) {
		try(FileInputStream fis = new FileInputStream(EVENTS_FILE);
				Scanner scan = new Scanner(fis))	{  
			while(scan.hasNextLine()) {
				String line = scan.nextLine(); // each line is a user in the system
				Event e = parseLineToEvent(line);
				//once we have an, put it a host's eventList
				guest.getEventInvitations().add(e);
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found exception in readExistingEventsFromFile");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException in readExistingEventsFromFile");
			e.printStackTrace();
		}
	}
	
	// Adds user information from usermap to a file
	private void writeUsersToFile() {
		System.out.println("Account info has been added to: " + USER_FILE);
		try (FileWriter fw = new FileWriter(USER_FILE, true);
			PrintWriter pw = new PrintWriter(fw, true)) { // set second parameter to "true" in order to append
			// take each user in the map and write it to the file.
			for(String key: users.keySet()) {
				User u = users.get(key);
				// print users email/name/password
				pw.println(u.toFileString());
			}
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // automatically close resources at end
		
	}
	
	/**
	 * Takes a line from our file and turns it into a user object
	 * @param line (where everything is split by the "/" symbol)
	 * @return a User object
	 */
	private User parseLineToUser(String line) {
		User u;
		// line needs to be broken apart into tokens. (Use Scanner)
		Scanner lineReader = new Scanner(line);
		lineReader.useDelimiter("/"); // instead of white space, use the / as the thing that breaks the line apart
		// good lines will either have 3 tokens or 5 tokens.
		String email = lineReader.next(); // email is always first in the line from the file
		String name = lineReader.next(); // name is always second in the line from the file
		String password = lineReader.next(); // Password is always third in the line from the file
		u = new User(email, name, password);
		lineReader.close();
		return u;
	}
	
	// Prints out each user from the user map in a user friendly format
	// Returns the string of users.
	public String usersToString() {
		// just a way to visualize the map of users....
		// go through the map, get all the keys, and print all the User objects
		String s = "Map of All Users --> Email: User Object\n";
		for(String key: users.keySet()) { // for each key in the user map of keys....
			User value = users.get(key); // get the object associated with the key
			s += "\t" + key + ": "+ value.toFileString() + "\n";
		}
		System.out.println(s);
		return s;
	}
	
	// Reads each line of the file as a user and adds it to the userMap
	private void readExistingUsersFromFile() {
		try(FileInputStream fis = new FileInputStream(USER_FILE);
				Scanner scan = new Scanner(fis))	{  
			while(scan.hasNextLine()) {
				String line = scan.nextLine(); // each line is a user in the system
				User user = parseLineToUser(line);
				//once we have a user, put it in map
				users.put(user.getEmail(), user); //unique email maps to ONE user in the system
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found exception in readExistingUsersFromFile");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException in readExistingUsersFromFile");
			e.printStackTrace();
		}

	}
	
	// Runs the entire program
	public void run() throws IOException, ClassNotFoundException {
		// Print welcome statement
		helper.printPretty("Welcome to the Evite System!");
		boolean cont = true;
		while (cont) {
			String oldOrNew = helper.inputWord("Are you a new or returning user? Press \"n\" for new or \"r\" for returning: ", "n", "r");
			if (oldOrNew.contentEquals("n")) {
				createNewUser();
				writeUsersToFile();
			}
			readExistingUsersFromFile(); // add the users in the file to the map of users
			User u = login();
			String menuOption = helper.inputWord("Are you a guest or host? Press \"g\" for guest or \"h\" for host: ", "g", "h");
			if (menuOption.contentEquals("g")) {
				Guest guest = new Guest(u.getEmail(), u.getName());
				runGuestMenu(guest);
			}
			else {
				ArrayList<Event> eventList = null;
				boolean isPremium = helper.inputYesNoAsBoolean("Would you like to make your account premium? (y/n) ");
				if (isPremium) {
					System.out.println("Premium features will be added in V2!");
				}
				Host host = new Host(u, isPremium, eventList);
				runHostMenu(host);
			}
			cont = helper.inputYesNoAsBoolean("Would you like to continue using the Evite system? (y/n) ");
		}
	}
	
	// main method
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		UserSystem us = new UserSystem();
		us.run();
	}
	
	
}
