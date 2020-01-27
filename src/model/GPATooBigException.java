package model;

public class GPATooBigException extends Exception {
	
	public GPATooBigException() {
		super("GPA is too big.");
	}
	
	public GPATooBigException(String message) {
		super(message);
	}
	
}
