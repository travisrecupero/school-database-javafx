package model;

import java.io.Serializable;

public class Faculty extends Person implements Serializable{

	private Name name;
	private String officeAddress;
	private double salary;
	private String title;

	public Faculty(String id, String phone, Address address, Name name, double salary, String title) {
		super(id, name, phone, address);
		this.name = name;
		this.salary = salary;
		this.title = title;
	}

	public Faculty() {

	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Faculty | ID: " + getId() + ", Phone Number: " + getPhone() + ", Address: " + getAddress()
				+ ", name: " + name + ", salary: " + salary + ", title: " + title;
	}


}
