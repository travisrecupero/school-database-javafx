package model;

import java.io.*;
import java.util.Arrays;

public class PersonBag {

	private Person[] persons;
	private int nElems;

	public PersonBag(int maxSize) {
		persons = new Person[maxSize];
		nElems = 0;
	}

	public void add(Person person) {
		persons[nElems++] = person;
	}

//	public Person findById(Person person) {
//		for (int i = 0; i < persons.length; i++) {
//			if (persons[i].getId().equals(person.getId())) {
//				return persons[i];
//			}
//		}
//		return null;
//	}

	public Person findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (persons[i].getId().equals(id)) {
				return persons[i];
			}
		}
		return null;
	}


	public Person removeById(String id) {
		int indexFound;
		for (indexFound = 0; indexFound < nElems; indexFound++) {
			if (persons[indexFound].getId().equals(id)) {
				break;
			}
			if (indexFound == nElems) {
				return null;
			}
		}
			Person temp = persons[indexFound];
			for (int j = indexFound; j < nElems; j++) {
				persons[j] = persons[j + 1];
			}
			nElems--;
			return temp;

	}

	public Person[] getPersonArray() {
		return Arrays.copyOf(persons, nElems);
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/PersonBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(persons);
			oos.writeInt(nElems);
			oos.writeInt(Person.getIdCounter());
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			// Util.failureAlert("Failure saving PersonBag.dat file");
		}

	}

	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/PersonBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			persons = (Person[]) (ois.readObject());
			nElems = (ois.readInt());
			Person.setIdCounter(ois.readInt());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
			// Util.failureAlert("Failure loading PersonBag.dat file");
		} catch (ClassNotFoundException e) {
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(persons[i]);
		}
		System.out.println();
	}

}
