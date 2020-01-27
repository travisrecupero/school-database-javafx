package model;

import java.io.Serializable;
import java.util.Scanner;

public class Address implements Serializable{

	private String streetNumber;
	private String streetName;
	private String city;
	private String state;
	private String zip;

	private Scanner kb = new Scanner(System.in);
	
	public Address(String streetNumber, String streetName, String city, String state, String zip) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		checkZip(zip);
	}

	public Address(Address address){
		this(address.getStreetNumberDeep(), address.getStreetNameDeep(), 
			 address.getCityDeep(), address.getStateDeep(), address.getZipDeep());
	}
	
	
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public String getStreetNumberDeep() {
		return new String(streetNumber);
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}
	
	public String getStreetNameDeep() {
		return new String(streetName);
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}
	
	public String getCityDeep() {
		return new String(city);
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateDeep() {
		return new String(state);
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public String getZipDeep() {
		return new String(zip);
	}
	
	public void setZip(String zip) {
		checkZip(zip);
	}
	
	private void checkZip(String zip){
		String tempZip = zip.replaceAll("\\D+","");
		if(zip.length() == 5){
			this.zip = tempZip;
		} else{
			try{
				throw new InvalidZipException("The zip was not valid");
			} catch (InvalidZipException e) {
				System.out.println(e.getMessage());
				getNewZip();
			}
		}
		
	}
	
	private void getNewZip() {
		String tempZip = "0";
		do {
			System.out.println("Re-Enter a valid zip: ");
			tempZip = kb.nextLine();
		} while (tempZip.length() != 5);
		this.zip = tempZip;
	}

	@Override
	public String toString() {
		return "Street-Number: " + streetNumber + ", Street-Name: " + streetName + ", City: " + city + ", State: "
				+ state + ", Zip: " + zip + " ";
	}

}
