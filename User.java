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
public class User implements Serializable{
	
	// INSTANCE VARIABLES
	private String name;
	private LocalDate birthday;
	private String email;
	private String password;
	
	// CONSTRUCTORS
	
	public User(String email, String name) {
		this.email = email;
		this.name = name;
	}
	
	public User(String email, String name, String password) {
		this(email, name);
		this.password = password;
	}
	
	public User(String name, LocalDate birthday, String email, String password) { 
		this(email, name, password);
		this.birthday = birthday; // uses LocalDate directly for birthday

	}
	
	public User(String name, int year, int month, int day, String email, String password) { 
		this(name, LocalDate.of(year, month, day), email, password); // Uses integers to make up birthday
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	// GETTERS AND SETTERS 
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", birthday=" + birthday + ", email=" + email + "]";
	}
	
	public String toFileString() {
		String fileLine = getEmail() + "/" + getName() + "/" + getPassword();
		return fileLine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	

}
