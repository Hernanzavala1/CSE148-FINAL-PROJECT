package model;

public class Student extends Person {
	private double gpa;
	private String major;
	private CourseBag courses;

	public Student(String firstName, String lastName, String phoneNumber, String major) {
		super(firstName, lastName, phoneNumber);
	
		this.major = major;

	}
	
	public Student(String firstName, String lastName) {
		super(firstName,lastName);
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public CourseBag getCourses() {
		return courses;
	}

	public void setCourses(CourseBag courses) {
		this.courses = courses;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(MasterCourseBag mBag) {
		int sumOfCreds = 0;
		double gradePoints = 0;
		double[] valueGrades = courses.convertLetterGrade();
		String[] courseNumbers = courses.getCourseNumberArray();
		int[] arrayCreds = new int[courseNumbers.length];
		
			for (int i = 0; i < courseNumbers.length; i++) {
				arrayCreds[i] = mBag.returnCredits(courseNumbers[i]);
				sumOfCreds += arrayCreds[i];
			}
			for (int i = 0; i < courseNumbers.length; i++) {
				gradePoints += valueGrades[i] * arrayCreds[i];
			}
			double gpa = gradePoints / sumOfCreds;

			if (gpa > 4.0 ) {
				try {
				throw new GpaTooBigException();
			} catch(GpaTooBigException e) {
				System.out.println(e.getMessage());
				this.gpa = 4.0;
			}
			}
				else if(gpa < 0.0) {
					try {
						throw new GpaTooSmallException();
					}
					catch(GpaTooSmallException e) {
						System.out.println(e.getMessage());
						this.gpa=0.0;
					}
				}
				else {
					this.gpa=gpa;
				}

		

	}

	@Override
	public String toString() {
		return "Student: " + super.toString()  + " major: " + major;
	}

}
