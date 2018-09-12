package model;

public class GpaTooBigException extends Exception {
	public GpaTooBigException() {
		super("Your gpa is too big!");
	}
}
