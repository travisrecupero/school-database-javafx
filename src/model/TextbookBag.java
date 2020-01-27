package model;

import java.io.*;

import java.util.*;

public class TextbookBag {

	
	private Textbook[] textbooks;
	private int nElems;

	public TextbookBag(int maxSize) {
		textbooks = new Textbook[maxSize];
		nElems = 0;
	}

	public void add(Textbook textbook) {
		textbooks[nElems++] = textbook;
	}

	public Textbook findByIsbn(Textbook textbook) {
		for (int i = 0; i < textbooks.length; i++) {
			if (textbooks[i].getIsbn().equals(textbook.getIsbn())) {
				return textbooks[i];
			}
		}
		return null;
	}

	public Textbook removeById(Textbook textbook) {
		int indexFound;
		for (indexFound = 0; indexFound < textbooks.length; indexFound++) {
			if (textbooks[indexFound].getIsbn().equals(textbook.getIsbn())) {
				break;
			}
		}

		if (indexFound == nElems) {
			return null;
		} else {
			Textbook temp = textbooks[indexFound];
			for (int j = indexFound; j < nElems; j++) {
				textbooks[j] = textbooks[j + 1];
			}
			nElems--;
			return temp;
		}

	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/TextbookBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(textbooks);
			oos.writeObject(nElems);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			//Util.failureAlert("Failure saving TextbookBag.dat file");
		}

	}

	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/TextbookBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			textbooks = (Textbook[]) (ois.readObject());
			nElems = (int) (ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
			//Util.failureAlert("Failure loading TextbookBag.dat file");
		} catch (ClassNotFoundException e) {
		}

	}
	
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(textbooks[i]);
		}
		System.out.println();
	}
	
	
	
	
}
