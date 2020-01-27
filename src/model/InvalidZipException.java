package model;

public class InvalidZipException extends Exception {
	
	public InvalidZipException() {
		super("Invalid zip, doesnt have 5 digits exclusively.");
	}

	public InvalidZipException(String message) {
		super(message);
	}
}
