package model;


public class Faculty extends Person {

private String title;
private double salary;
	public Faculty(String firstName, String lastName, String phonenNumber, String title, double salary) {
		super(firstName, lastName, phonenNumber);
		this.title = title;
		this.salary= salary;

	}
	public Faculty(String firstName, String lastName, String phoneNumber) {
		super(firstName,lastName,phoneNumber);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Faculty: "+ super.toString() +" title: " + title  ;
	}

}
