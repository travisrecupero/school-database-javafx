package model;

import java.io.Serializable;

public class Grade implements Serializable {

	private String courseNumber;
	private String courseLetterGrade;

	public Grade(String courseNumber, String courseLetterGrade) {
		super();
		this.courseNumber = courseNumber;
		this.courseLetterGrade = courseLetterGrade;
	}

	public Grade(String courseNumber) {
		super();
		this.courseNumber = courseNumber;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseLetterGrade() {
		return courseLetterGrade;
	}
	
	public double getCourseNumberGrade(String letter) {
		double score = 0;
		
		if (letter.equals("A")){
			score = 4.0;
		} else if (letter.equals("B+")) {
			score = 3.75;
		} else if (letter.equals("B")) {
			score = 3.5;
		} else if (letter.equals("C+")) {
			score = 2.75;
		} else if (letter.equals("C")) {
			score = 2.5;
		} else if (letter.equals("D+")) {
			score = 1.75;
		} else if (letter.equals("D")) {
			score = 1.5;
		} else if (letter.equals("F")) {
			score = 0.0;
		} else  {
			System.out.println("Invalid Course Grade");
		}
		
		return score;
	}

	public void setCourseLetterGrade(String courseLetterGrade) {
		this.courseLetterGrade = courseLetterGrade;
	}

	
	
	@Override
	public String toString() {
		return "Course Number: " + courseNumber + ", Course Letter Grade: " + courseLetterGrade;
	}

}
