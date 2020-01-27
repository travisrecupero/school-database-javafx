package model;

public class CreditCalculator {

	public static int getCredits(String[] courses, Course[] masterCourses) {															
		int credits = 0;

		for (int i = 0; i < courses.length; i++) {
			for (int j = 0; j < masterCourses.length; j++) {
				if (courses[i].equals(masterCourses[j].getCourseNumber())) {
					credits += masterCourses[j].getNumberOfCredits();
				}

			}
		}
		return credits;
	}

	public static int getCredits(Grade[] courses, Course[] masterCourses) {
		int credits = 0;

		for (int i = 0; i < courses.length; i++) {
			for (int j = 0; j < masterCourses.length; j++) {
				if (courses[i].getCourseNumber().equals(masterCourses[j].getCourseNumber())) {
					credits += masterCourses[j].getNumberOfCredits();
				}

			}
		}
		return credits;
	}

	public static double getGPA(Grade[] coursesTook, Course[] masterCourses) {
		double gpa = 0;

		for (int i = 0; i < coursesTook.length; i++) {
			for (int j = 0; j < masterCourses.length; j++) {
				if (coursesTook[i].getCourseNumber().equals(masterCourses[j].getCourseNumber())) {
					gpa += coursesTook[i].getCourseNumberGrade(coursesTook[i].getCourseLetterGrade())
							* masterCourses[j].getNumberOfCredits();
				}

			}
		}

		return gpa / getCredits(coursesTook, masterCourses);
	}
	
	

}
