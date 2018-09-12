package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import view.Util;

public class CourseBag implements Serializable {
	private String[] coursesTaken;
	private String[] coursesTaking;
	private String[] coursesNeeded;
	private int counter1 = 0;
	private int counter2 = 0;
	private int counter3 = 0;
	private String[] courseNumbers;
	private double[] grades;

	public CourseBag(int coursesTaken, int coursesTaking, int coursesNeeded) {
		this.coursesTaken = new String[coursesTaken];
		courseNumbers = new String[coursesTaken];
		grades = new double[coursesTaken ];
		this.coursesTaking = new String[coursesTaking];
		this.coursesNeeded = new String[coursesNeeded];

	}

	public CourseBag deepCopy(CourseBag bag) {
		return new CourseBag(bag.coursesTaken.length, bag.coursesTaking.length, bag.coursesNeeded.length);
	}

	public void addCoursesTaken(String courseNumber) {
		try {
			if (counter1 != coursesTaken.length && notRepeatedTakenCourse(courseNumber)) {
				coursesTaken[counter1++] = courseNumber;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			Util.ExecutionFailed();
			System.out.println("the bag cant add no more courses! or course is repeated!");
		}
	}

	public boolean notRepeatedTakenCourse(String courseNumber) {
		for (int i = 0; i < counter1; i++) {
			if (coursesTaken[i].contains(courseNumber)) {
				return false;
			}
		}
		return true;
	}

	public void addCoursesTaking(String courseNumber) {
		try {
			if (counter2 == coursesTaking.length) {
				throw new Exception();
			} else {
				coursesTaking[counter2++] = courseNumber;
			}
		} catch (Exception e) {
			System.out.println("Bag cant hold anymore taking courses! please create a bigger bag!");
		}
	}

	public void addCoursesNeeded(String courseNumber) {
		try {
			if (counter3 == coursesNeeded.length) {
				throw new Exception();
			} else {
				coursesNeeded[counter3++] = courseNumber;
			}
		} catch (Exception e) {
			System.out.println("Bag cant hold anymore taken courses! please create a bigger bag!");
		}
	}

	public void displayCourseNumbers() {
		for (int i = 0; i < courseNumbers.length; i++) {
			System.out.println(courseNumbers[i]);
		}
	}

	public void findTakenCourse(String courseNumber) {
		for (int i = 0; i < counter1; i++) {
			if (coursesTaken[i].contains(courseNumber)) {
				System.out.println("The course your looking for is: " + coursesTaken[i]);
			}
		}
	}

	public void findTakingCourse(String courseNumber) {
		for (int i = 0; i < counter1; i++) {
			if (coursesTaking[i].contains(courseNumber)) {
				System.out.println("The course your looking for is: " + coursesTaking[i]);
			}
		}
	}

	// use the split function to retrieve a string array instead of string

	public double[] convertLetterGrade() {

		for (int i = 0; i < counter1; i++) {

			String course = coursesTaken[i];
			String[] courseInfo = course.split(":");
//			courseNumbers[i] = courseInfo[0];
			grades[i] = getGrade(courseInfo[1]);
		}

		return grades;

	}

	public String[] getCourseNumberArray() {

		for (int i = 0; i < counter1; i++) {

			String course = coursesTaken[i];
			String[] Grades = course.split(":");
			courseNumbers[i] = Grades[0];
			grades[i] = getGrade(Grades[1].toUpperCase());

		}
		List<String> list = new ArrayList<String>();

		for (String s : courseNumbers) {
			if (s != null && s.length() > 0) {
				list.add(s);
			}
		}

		//courseNumbers = list.toArray(new String[list.size()]);
		return list.toArray(new String[list.size()]);

	}

	public double getGrade(String letterGrade) {
		double letterEquivalence = 0.0;
		switch (letterGrade) {
		case "A":
			letterEquivalence = 4.0;
			break;
		case "A-":
			letterEquivalence = 3.7;
			break;
		case "B+":
			letterEquivalence = 3.3;
			break;
		case "B":
			letterEquivalence = 3.0;
			break;
		case "B-":
			letterEquivalence = 2.7;
			break;
		case "C+":
			letterEquivalence = 2.3;
			break;
		case "C":
			letterEquivalence = 2.0;
			break;
		case "C-":
			letterEquivalence = 1.7;
			break;
		case "D+":
			letterEquivalence = 1.3;
			break;
		case "D":
			letterEquivalence = 1.0;
			break;
		default:
			letterEquivalence = 0;
			break;
		}
		return letterEquivalence;
	}

	public void findNeededCourse(String courseNumber) {
		for (int i = 0; i < counter1; i++) {
			if (coursesNeeded[i].contains(courseNumber)) {
				System.out.println("The course your looking for is: " + coursesNeeded[i]);
			}
		}
	}

	public String removeTakingCourse(String courseNumber) {
		int i;
		for (i = 0; i < counter2; i++) {
			if (coursesTaking[i].contains(courseNumber)) {
				break;
			}
		}
		if (i == counter2) {
			return null;
		} else {
			String temp = coursesTaking[i];

			for (int j = i; j < counter2 - 1; j++) {
				coursesTaking[j] = coursesTaking[j + 1];

			}
			counter2--;
			addCoursesTaken(temp);


			return temp;
		}
	}


	public String removeNeededCourse(String courseNumber) {
		int i;
		for (i = 0; i < counter3; i++) {
			if (coursesNeeded[i].contains(courseNumber)) {
				break;
			}
		}
		if (i == counter3) {
			return null;
		} else {
			String temp = coursesNeeded[i];

			for (int j = i; j < counter3 - 1; j++) {
				coursesNeeded[j] = coursesNeeded[j + 1];

			}
			counter3--;
			addCoursesTaking(temp);

			return temp;
		}
	}

	public void setGrade(String courseNumber, String Grade) {
	
		for (int i = 0; i < coursesTaken.length; i++) {
			if (courseNumber.equals(coursesTaken[i])) {
				coursesTaken[i] += ":" + Grade;
			}
		}
	}

	public String removeTakenCourse(String courseNumber) {
		int i;
		for (i = 0; i < counter1; i++) {
			if (coursesTaken[i].contains(courseNumber)) {
				break;
			}
		}
		if (i == counter1) {
			return null;
		} else {
			String temp = coursesTaken[i];

			for (int j = i; j < counter1 - 1; j++) {
				coursesTaken[j] = coursesTaken[j + 1];

			}
			counter1--;
			return temp;
		}
	}

	public void display() {
		System.out.println("Courses taken:");

		for (int i = 0; i < counter1; i++) {
			System.out.println(coursesTaken[i]);
		}
		System.out.println("Courses taking: ");
		for (int i = 0; i < counter2; i++) {
			System.out.println(coursesTaking[i]);
		}
		System.out.println("Courses needed: ");
		for (int i = 0; i < counter3; i++) {
			System.out.println(coursesNeeded[i]);
		}

	}

	public void importTakenCouse(String fileName) {
		File file = new File(fileName);
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				String data = in.nextLine();

				addCoursesTaken(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void importTakingCouse(String fileName) {
		File file = new File(fileName);
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				String data = in.nextLine();

				addCoursesTaking(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void importNeededCouse(String fileName) {
		File file = new File(fileName);
		Scanner in = null;
		try {
			in = new Scanner(file);
			while (in.hasNextLine()) {
				String data = in.nextLine();

				addCoursesNeeded(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	public void save() {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("ArrayOfCourses.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(coursesTaken);
			oos.writeObject(counter1);
			oos.writeObject(coursesTaking);
			oos.writeObject(counter2);
			oos.writeObject(coursesNeeded);
			oos.writeObject(counter3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void load() {
		FileInputStream fis;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("ArrayOfCourses.dat");
			ois = new ObjectInputStream(fis);
			coursesTaken = (String[]) ois.readObject();
			counter1 = (Integer) ois.readObject();
			coursesTaking = (String[]) ois.readObject();
			counter2 = (Integer) ois.readObject();
			coursesNeeded = (String[]) ois.readObject();
			counter3 = (Integer) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void exportTakenCourses(String fileName) {
		PrintWriter file = null;
		try {
			file = new PrintWriter(fileName);
			for (int i = 0; i < counter1; i++) {
				file.println(coursesTaken[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			file.close();
		}

	}

	public void exportTakingCourses(String fileName) {
		PrintWriter file = null;
		try {
			file = new PrintWriter(fileName);
			for (int i = 0; i < counter2; i++) {
				file.println(coursesTaking[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			file.close();
		}

	}

	public void exportNeededCourses(String fileName) {
		PrintWriter file = null;
		try {
			file = new PrintWriter(fileName);
			for (int i = 0; i < counter3; i++) {
				file.println(coursesNeeded[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			file.close();
		}

	}
	public String[] getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(String[] coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public String[] getCoursesTaking() {
		return coursesTaking;
	}

	public void setCoursesTaking(String[] coursesTaking) {
		this.coursesTaking = coursesTaking;
	}

	public String[] getCoursesNeeded() {
		return coursesNeeded;
	}

	public void setCoursesNeeded(String[] coursesNeeded) {
		this.coursesNeeded = coursesNeeded;
	}

}