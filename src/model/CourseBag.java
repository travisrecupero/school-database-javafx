package model;

import java.io.*;
import java.util.Arrays;

public class CourseBag {

	private Course[] courses;
	private int nElems;

	public CourseBag(int maxSize) {
		courses = new Course[maxSize];
		nElems = 0;
	}

	public void add(Course course) {
		courses[nElems++] = course;
	}

	public Course findByIsbn(Course course) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i].getTextbookISBN().equals(course.getTextbookISBN())) {
				return courses[i];
			}
		}
		return null;
	}

	public Course findByTitle(Course course) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i].getCourseNumber().equals(course.getCourseNumber())) {
				return courses[i];
			}
		}
		return null;
	}

	public Course removeById(Course course) {
		int indexFound;
		for (indexFound = 0; indexFound < courses.length; indexFound++) {
			if (courses[indexFound].getCourseNumber().equals(course.getCourseNumber())) {
				break;
			}
		}

		if (indexFound == nElems) {
			return null;
		} else {
			Course temp = courses[indexFound];
			for (int j = indexFound; j < nElems; j++) {
				courses[j] = courses[j + 1];
			}
			nElems--;
			return temp;
		}

	}

	public Course[] getCourseArray() {
		return Arrays.copyOf(courses, nElems);
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/CourseBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(courses);
			oos.writeObject(nElems);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			// Util.failureAlert("Failure saving CourseBag.dat file");
		}

	}

	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/CourseBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			courses = (Course[]) (ois.readObject());
			nElems = (int) (ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
			// Util.failureAlert("Failure saving CourseBag.dat file");
		} catch (ClassNotFoundException e) {
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(courses[i]);
		}
		System.out.println();
	}

}
