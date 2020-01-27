package model;

public class Textbook {

	private String title;
	private Name author;
	private String isbn;
	private double price;

	public Textbook(String title, Name author, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}

	public Textbook() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Name getAuthor() {
		return author;
	}

	public void setAuthor(Name author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", author=" + author + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

}
