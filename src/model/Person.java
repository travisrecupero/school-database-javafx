package model;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {

	private String id;
	private Name name;
	private String phone;
	private Address address;

	private transient Scanner kb = new Scanner(System.in);


	private static int idCounter = 1;

	public Person(String id, Name name, String phone, Address address) {
		super();
		id = String.valueOf(idCounter++);
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		address = new Address(address);
	}


//	public Person(Name name) {
//		super();
//		id = String.valueOf(idCounter++);
//		this.name = name;
//	}

	public Person() {
		id = String.valueOf(idCounter++);
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Person.idCounter = idCounter;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", phone=" + phone + ", address=" + address + "]";
	}

}
