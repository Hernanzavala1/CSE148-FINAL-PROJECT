package model;
import java.io.Serializable;

public class Textbook implements Serializable{
	private String bookTitle;
	private String author;
	private String publisher;
	private double price;
	private String ISBN;

	public Textbook(String bookTitle, String author, String publisher, double price, String iSBN) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		ISBN = iSBN;
	}
	public Textbook(Textbook book) {
		this.bookTitle = book.bookTitle;
		this.author = book.author;
		this.publisher = book.publisher;
		this.price = book.price;
		this.ISBN = book.ISBN;
	}
		
	

	public String getBookTitle() {
		return bookTitle;
	}
	public Textbook deepCopy(Textbook book) {
		return new Textbook(book);
		
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Override
	public String toString() {
		return "Book title: " + bookTitle + " author: " + author + " publisher: " + publisher + " price: " + price
				+ " ISBN: " + ISBN;
	}

}
