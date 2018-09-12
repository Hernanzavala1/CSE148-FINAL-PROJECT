package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MasterCourseBag {
	private Course[] courses;
	private int nElems;

	public MasterCourseBag(int maxSize) {
		courses = new Course[maxSize];
		nElems = 0;
	}

	public void setTextbook(Textbook book, String courseNumber) {
		for (int i = 0; i < nElems; i++) {
			if (courses[i].getCourseNumber().contains(courseNumber)) {
				courses[i].setBook(book);
			}
		}
	}

	public void addCourse(Course course) {
		courses[nElems++] = course;
	}

	public void display() {
		System.out.println("courses in the bag are: ");
		for (int i = 0; i < nElems; i++) {
			System.out.println( courses[i].toString());
		}
	}

	public  Course removeCourse(String courseNumber) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (courses[i].getCourseNumber().contains(courseNumber)) {
				break;
			}
		}
		if (i == nElems) {
			return null;
		} else {
			Course temp = courses[i];

			for (int j = i; j < nElems - 1; j++) {
				courses[j] = courses[j + 1];

			}
			nElems--;
			return temp;
		}
	}

	public Course findCourse(String courseNumber) {
		for (int i = 0; i < nElems; i++) {
			if (courses[i].getCourseNumber().contains(courseNumber)) {
				return courses[i];
			}
		}
		return null;
	}

	public void save() {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("MasterCourseBag.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(courses);
			oos.writeObject(nElems);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("MasterCourseBag.dat");
			ois = new ObjectInputStream(fis);
			courses = (Course[]) ois.readObject();
			nElems = (Integer) ois.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void importData(String fileName) {
		File file = new File(fileName);
		Scanner inp = null;
		try {
			inp = new Scanner(file);
			while (inp.hasNextLine()) {
				String course = inp.nextLine();
				String[] tokens = course.split(";");
				addCourse(new Course(tokens[0], tokens[1], null, Integer.parseInt(tokens[2])));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exportData(String fileName) {
		PrintWriter file = null;
		try {
			file = new PrintWriter(fileName);
			file.println(Arrays.toString(courses));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			file.close();
		}
	}

	public int returnCredits(String courseNumbers) {

		for (int i = 0; i < nElems; i++) {
			if (courseNumbers.equals(courses[i].getCourseNumber()) && courseNumbers != null) {
				return courses[i].getNumberCreds();
			}
		}
		return 0;
	}

	public Course[] getCourses() {
		List<Course> list = new ArrayList<>();

		for (Course s :courses) {
			if (s != null ) {
				list.add(s);
			}
		}
		return list.toArray(new Course[list.size()]);
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	
}
