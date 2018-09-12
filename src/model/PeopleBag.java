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

public class PeopleBag implements Serializable{
	private Person[] people;
	private int counter;

	public PeopleBag(int maxSize) {
		people = new Person[maxSize];
		counter = 0;
	}

	public void addPerson(Person person) {
		people[counter++] = person;

	}
	public void importStudents(String fileName) {
		System.out.println("IT IS IMPORTING UP TO HERE!");
		File file = new File(fileName);
		Scanner inp =null;
		try {
		inp= new Scanner(file);
			while(inp.hasNextLine()) {
				String data =inp.nextLine();
				String[] tokens= data.split("[:;]");
				Student student = new Student(tokens[0],tokens[1],tokens[2],tokens[3]);
				addPerson(student);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			inp.close();
			
		}
	}
	public void exportStudent(String fileName) {
		PrintWriter file =null;
	
		try {
			file = new PrintWriter(fileName);
			for(int i =0; i< counter;i++) {
				if(people[i] instanceof Student) {
					file.println(people[i].toString());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			file.close();
		}
		
	}
	public void exportFaculty(String fileName) {
	
		PrintWriter file =null;
		try {
			file = new PrintWriter(fileName);
			for(int i=0; i < counter; i++) {
				if(people[i] instanceof Faculty) {
					file.println(people[i].toString());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			file.close();
		}
		
		
		
		
	}


	public void importFaculty(String fileName) {
		File file = new File(fileName);
		Scanner inp =null;
		try {
			inp = new Scanner(file);
			while(inp.hasNextLine()) {
				String data = inp.nextLine();
				String[] tokens = data.split("[:;]");
				Faculty faculty = new Faculty(tokens[0],tokens[1],tokens[2],tokens[3],Double.parseDouble(tokens[4]));
				addPerson(faculty);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			inp.close();
		}
		
	}
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("PersonArray.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(people);
			oos.writeInt(counter);
			oos.writeInt(Person.getID());

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
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PersonArray.dat"))){
			people= (Person[]) ois.readObject();
			counter = ois.readInt();
			Person.setID(ois.readInt());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void display() {
		System.out.println("The people in the bag are: ");
		for (int i = 0; i < counter; i++) {
			System.out.println(people[i]);
		}
		System.out.println();
	}

	public Person findById(String id) {

		for (int i = 0; i < counter; i++) {
			if (people[i].getId().equals(id)) {
				return people[i];
			}
		}
		return null;
	}

	public Person deleteById(String id) {
		int i;
		for (i = 0; i < counter; i++) {
			if (people[i].getId().equals(id)) {
				break;
			}
		}
		if (i == counter) {
			return null;
		} else {
			Person temp = people[i];
			for (int j = i; j < counter - 1; j++) {
				people[j] = people[j + 1];
			}
			counter--;
			return temp;
		}
	}

	public Person[] getPeople() {
		List<Person> list = new ArrayList<>();

		for (Person s : people) {
			if (s != null ) {
				list.add(s);
			}
		}
		return list.toArray(new Person[list.size()]);
	}

	public void setPeople(Person[] people) {
		this.people = people;
	}
	

}

