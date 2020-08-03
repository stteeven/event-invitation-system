package itp265_FinalProject_stevengo;

import java.io.Serializable;

/** 
 * Class data type that combines city name with state or country name. 
 * @author Steven Gong
 * Assignment Final Project
 * Email: stevengo@usc.edu
 */
public class Location implements Serializable{
	// Create instance variable
	private String country;
	private String state;
	private String city;
	private int zipCode;
	private String streetAddress;

	// CONSTRUCTORS
	
	public Location(String streetAddress, String city, String state, int zipCode) {
		super();
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.streetAddress = streetAddress;
	}
	
	public Location(String country, String state, String city, int zipCode, String streetAddress) {
		this(streetAddress, city, state, zipCode);
		this.country = country;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	// equals method that compares locations
	public boolean equals(Location other) {
		boolean same = this.city.equalsIgnoreCase(other.city)
				&& this.state.equalsIgnoreCase(other.state)
				&& this.streetAddress.equalsIgnoreCase(other.streetAddress);
		return same;
	}

	@Override
	public String toString() {
		return streetAddress + ", " + city + ", " + state + ", " + zipCode;
	}
	

	
	
	
}