package model;

public class GPATooSmallException extends Exception {

	public GPATooSmallException() {
		super("GPA is less than 0.0.");
	}

	public GPATooSmallException(String message) {
		super(message);
	}
}
