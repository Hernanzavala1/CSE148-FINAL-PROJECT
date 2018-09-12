package model;

import java.io.Serializable;

public class Course implements Serializable {
	private String courseTitle;
	private String courseNumber;	
	private int numberCreds;
	private Textbook book;

	public Course(String courseTitle, String courseNumber, int numberCreds) {
		super();
		this.courseTitle = courseTitle;
		this.courseNumber = courseNumber;
		this.numberCreds = numberCreds;
	}
	

	public Course(String courseTitle, String courseNumber, Object object, int credits) {
	this.courseTitle = courseTitle;
	this.courseNumber = courseNumber;
	this.numberCreds = credits;
	}


	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public Textbook getBook() {
		return book;
	}

	public void setBook(Textbook book) {
		this.book = book;
	}

	public int getNumberCreds() {
		return numberCreds;
	}

	public void setNumberCreds(int numberCreds) {
		this.numberCreds = numberCreds;
	}
	@Override
	public String toString() {
		return  courseTitle+ " "  + courseNumber  + " Credits: "
				+ numberCreds + "\n";
	}
}