Steven Gong
stevengo@usc.edu
ITP 265

Overview of Final Project - Evite System

Journal Entries

	Thursday 4/23: Peer review of UML Class Diagrams.
		Came up with the following suggestions: implementing email address 
		as an instance variable for User/Person, including a "gift list"
		or "wish list" as the file to read. Also, added the instance variable
		isThemed: boolean under the InPersonEvent class and isAgeRestricted: boolean
		to the Event abstract class.
	
	Thursday 4/30 (2-3 hour session): 
		Implemented changes to UML Class Diagram.
		Coded the inheritance hierarchies for User and Event.
		Added eventList: ArrayList as a new instance variable for EventPlanner
		Changed acctType: String to isPremium: boolean.
		Created Location class.
			TODO: change order of toString to reflect a typical street address
		Implemented interface: AgeRestricted.
		Added isThemed: boolean to the InPersonEvent class.
		Implemented EventType Enum.
		TODO: customize toString() for the appropriate classes.
		Changed the function under interface AgeRestricted to getAgeLimit()
		
	Saturday 5/2 (1.5 hour session)
		Implemented password: String as new instance variable in User
		Set up UserMenu class
			Implemented helper.inputUser, which creates and returns a new user from input. 
		Created the person class as the new parent class above user. 
			Then removed this class after deeming it unnecessary.
		TODO: create login, write to file, create equals method to check users,
			add these functions under createAccount method
	 
	 Monday 5/4 (3.5 hour session)
	 	TODO: Register new users (add them to the back-end file), create login method
	 	Implemented necessary methods to do the following actions: 
	 		create a new user and add user to map, write user data to a back-end file, 
	 		parse file data, read data from user file
	 	Created new constructors for host and guest that use User as a field, 
	 	created host and guest menu.
	 	Troubleshooted errors with the writeUserToFile method and determined the error
	 	in the toFileString method in User.
	 		
	 Tuesday 5/5 (3 hour session)
	 	Created a method in helper that creates a new event from input, replaced "capacity" 
	 	instance variable with "platform"
	 	Created new constructors for Event, InPersonEvent and VirtualEvent.
	 	Implemented run feature to execute code for both new and returning users.
	 	Troubleshooted errors, updated constructors and toString methods for user login purposes
	 	(only uses name, password, and email).
	 	Implemented error checking for the user menus.
	 	Added stylistic details (like io.printPretty()) and tweaked wording for better UI/UX
	 	TODO: find out how to append to file instead of overwriting file when new users are added.
	 	
	 Thursday 5/7 (4 hour session)
	 	TODO: Create a file for events and implement the methods to read from and write to it,
	 	implement eventType and corresponding methods.
	 	Implemented createNewEvent() method that adds new events to the list.
	 	Added the ability to append to a file instead of overwrite.
	 	Fixed error that prevented users from logging into a different account after creating
	 	a new one.
	 	Added error checking to login function.
	 	Created the chooseEventType() method in IO.
	 	Created a new constructor for Host that takes in User as a parameter.
	 	Created methods to read events from a file and write events to a file.
	 	Implemented Serializable in all the necessary classes.
	 	Lots of troubleshooting and editing these methods^^
	 		Looked up how to read objects from a file, then found out I can
	 		only read one object at a time. Made a lot of Google searches to try to 
	 		fix this but couldn't find a conclusive solution... might have to
	 		abandon the Object reader?? Unsure how to efficiently parse Events
	 		from file though.
	 	TODO: fix readEventsFromFile(), implement interface into program
	 	
	 Friday 5/8 
	 	TODO: (2 hour session) 
	 		Make a parser for Location- DONE
	 		Make a parser for LocalDateTime - DONE
	 	Added appropriate constructors to create objects from file data.
	 	Updated toFileString() in the two event classes.
	 	Turned guestMenu into an Enum.
	 	
	 	TODO:USER MENUS (3 hour session)
	 		Implement host invite function - DONE
	 			Adds the designated events to a users' invitation list - DONE
	 			Create a helper method to input guests - DONE
	 		Implement guest RSVP function - DONE
	 			Adds the guest to guestMap in Event - DONE
	 	
	 	Added another constructor for guest that takes in email and name.
	 	Created loadFakeData() method for guestMenu to add events that the guest
	 	has been invited to. 
	 		
	 Saturday 5/9 (1.5 hour session)
	 	Implemented AgeRestricted interface to InPersonEvent.
		Commented code.
		Cleaned up UI/UX.
			
 Final Report: Reflection
 
	 The role of MVC:
	 
	 The framework of MVC helped me to allocate tasks to their appropriate classes
	 in a more organized fashion. For instance, I knew to keep the basic pieces of 
	 each class-- including the instance variables, constructors, getters, and setters--
	 limited to the class itself while leaving the UI components up functional View 
	 classes such as IO and UserSystem. There was some overlap in category between 
	 these classes in particular, as they also acted as Control classes that manipulate
	 the model and present the information in a friendly way to the user. For this 
	 project in particular, I relied a lot more on IO than previous projects as I got 
	 a better sense of how it can be used to atomize the code more nicely rather than 
	 having the UserSystem do all the displaying and manipulation. In addition, I
	 had a better grasp on which class I needed to work with in order to achieve the
	 outcomes I wanted, and spent less time figuring out which class I needed to work 
	 with than I did on previous projects.
	 
	 Remaining functionality not yet implemented:
	 
	 In UserSystem, the Guest Menu is not yet fully implemented. The remaining method
	 to implement is the addPluses() function, which enables to user to invite additional
	 guests to the original host's event. Only original guests would have this capability.
	 
	 The Premium User feature is also pending implementation in V2. This feature allows
	 for the creation of unlimited events and guests. These features are exclusive to 
	 premium users, which means that non-premium users will not have the capability to
	 add unlimited users and guests. In this version, all users are on a "free trial" for 
	 Evite Premium.
	 
	 Strengths, areas for improvement, lessons learned: 
	 
	 Over the course of this project, I believe that I did a good job at scheduling and 
	 organizing the work that I had to do. The journal was immensely helpful with this,
	 as it helped me to keep track of my progress and narrow down the remaining tasks
	 that I had to do for this project. After setting up the framework and design of 
	 the project, I was able to divide up my work sessions by the features and functionality
	 that I wanted to implement and the errors that I wanted to figure out/fix.
	 
	 This leads me to the "areas for improvement" part of my reflection. I felt that I often
	 spent too much time trying to figure out errors through trial and error, and not enough
	 planning ahead and systematically thinking about how to solve them. There were times 
	 that I definitely did do this, especially when I was first designing the UML diagram, 
	 but there were also times when I panicked over errors and tried to find alternative
	 solutions instead of looking at the big picture and thinking about restructuring certain
	 designs.
	 
	 But restructuring designs is hard. It's much more difficult than fixing specific syntactical
	 errors, but I also think that it's one of the most valuable takeaways from object-oriented
	 programming. From the comprehensive nature of this assignment, I learned to think about
	 design-paradigms and the crucial role they play in the development of a successful project.
	 This was especially prevalent to me when we first created a UML diagram from scratch, and 
	 updated it to reflect the changes and developments made to the project. All things considered,
	 this project was a valuable experience, and I'm glad we got the flexibility and challenge
	 (although it did take a lot of time all together) to create the project design ourselves
	 and journal our progress throughout the journey.
	 
	 
 	
 	
 	
