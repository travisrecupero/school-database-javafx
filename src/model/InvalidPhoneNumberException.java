package model;

public class InvalidPhoneNumberException extends Exception {

	public InvalidPhoneNumberException() {
		super("Invalid phone number, doesnt have 10 digits.");
	}

	public InvalidPhoneNumberException(String message) {
		super(message);
	}
	
}
