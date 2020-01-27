package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Student extends Person implements Serializable {

	private Name name;
	private String major;
	private double gpa;
	private Grade[] coursesTook;
	private Grade[] coursesTaking;
	private Grade[] coursesToTake;

	private transient Scanner kb = new Scanner(System.in);

	private final double MAX_GPA = 4.0;
	private final double MIN_GPA = 0.0;


	

	public Student(String id, String phone, Address address, Name name, String major, double gpa, Grade[] coursesTook,
			Grade[] coursesTaking) {
		super(id, name, phone, address);
		this.name = name;
		this.major = major;
		checkGPA(gpa);
		this.coursesTook = coursesTook;
		this.coursesTaking = coursesTaking;
	}



	public Student() {

	}


	public Name getName() {
		return name;
	}
	 
	public void setName(Name name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Grade[] getCoursesTook() {
		return coursesTook;
	}

	public void setCoursesTook(Grade[] coursesTook) {
		this.coursesTook = coursesTook;
	}

	public Grade[] getCoursesTaking() {
		return coursesTaking;
	}

	public void setCoursesTaking(Grade[] coursesTaking) {
		this.coursesTaking = coursesTaking;
	}


	public Grade[] getCoursesToTake() {
		return coursesToTake;
	}

	public void setCoursesToTake(Grade[] coursesToTake) {
		this.coursesToTake = coursesToTake;
	}

	public void setGpa(double gpa){
		checkGPA(gpa);
	}

	private void checkGPA(double gpa) {
		if(gpa < MIN_GPA) {
			try {
				throw new InvalidGPAException("The GPA entered is too small!");
			} catch (InvalidGPAException e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
				getNewGPA();
			}
		} else if(gpa > MAX_GPA) {
			try {
				throw new InvalidGPAException("The GPA entered is too big!");
			} catch (InvalidGPAException e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
				getNewGPA();
			}
		} else {
			this.gpa = gpa;
		}
	}

	private void getNewGPA() {
		double tempGPA = -10.0;
		do {
			System.out.println("Re-Enter a valid GPA: ");
			tempGPA = kb.nextDouble();
		} while (tempGPA< 0.0 || tempGPA > 4.0);
		this.gpa = tempGPA;
	}

	@Override
	public String toString() {
		return "Student | ID: " + getId() + ", Phone: " + getPhone() + ", Address: " + getAddress() + ", " + name
				+ ", Major: " + major + ", Courses-Took: " + Arrays.toString(coursesTook) + ", Courses-Taking: "
				+ Arrays.toString(coursesTaking);
	}

}
