package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Person implements Serializable{

	
	private String firstName;
	private String lastName;
	private static int ID;
	private String id;
	private String phonenNumber;
	
	static int getID() {
		return ID;
	}

	static void setID(int iD) {
		ID = iD;
	}

	public Person(String firstName,String lastName) {
		this.firstName =firstName;
		this.lastName =lastName;
		
		//loadNElems();
		ID++;
		this.id = String.valueOf(ID);
		//saveNElems(ID);
	}

	private void saveNElems(int id) {
		// TODO Auto-generated method stub
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("NumberOfPeople.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeInt(id);
	
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

	private static void loadNElems() {
		// TODO Auto-generated method stub
		//FileInputStream fis;
		//ObjectInputStream ois = null;
		try (FileInputStream fis = new FileInputStream("NumberOfPeople.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			ID = ois.readInt();
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	
	}

	public Person(String firstName, String lastName, String phoneNumber) {
		this(firstName, lastName);
	     try {
			if (phoneNumber.length() < 11 & isAllNumbers(phoneNumber)) {
				this.phonenNumber = phoneNumber;
			} 
			else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("This is not a correct phone number!");
		}
//		ID++;
//	this.id = String.valueOf(ID);
	}
	

	public boolean isAllNumbers(String phoneNumber) {
		
		for(int i=0 ; i < phoneNumber.length(); i++) {
			if(!Character.isDigit(phoneNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return this.id;
	}



	public String getPhonenNumber() {
		return phonenNumber;
	}

	public void setPhonenNumber(String phonenNumber) {
		this.phonenNumber = phonenNumber;
	}

	@Override
	public String toString() {
		return  firstName+ " " + lastName + " id: " + id  ;
	}

}
