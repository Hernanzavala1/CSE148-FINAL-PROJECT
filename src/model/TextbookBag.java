package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextbookBag  {
	private Textbook[] books;
	private int counter;

	public TextbookBag(int numberOfBooks) {
		books = new Textbook[numberOfBooks];
		counter = 0;
	}

	public void addBook(Textbook book) {
		try {
			if(counter != books.length) {
				books[counter++] = book;
			}
			else {
				throw new IllegalArgumentException();
			}
		}catch(IllegalArgumentException e) {
			System.out.println("the book bag cannot hold any more books!");
		}
	}

	public Textbook deleteByISBN(String ISBN) {
		int i;
		for (i = 0; i < counter; i++) {
			if (books[i].getISBN().equals(ISBN)) {
				break;
			}
		}
		if (i == counter) {
			return null;
		} else {

			Textbook temp = books[i];
			for (int j = i; j < counter - 1; j++) {
				books[j] = books[j + 1];

			}
			counter--;
			return temp;

		}

	}

	public Textbook findTextbook(String ISBN) {
		for (int i = 0; i < counter; i++) {
			if (books[i].getISBN().equals(ISBN)) {
				System.out.println("The book your looking is: ");
				return books[i];
			}
		}
		return null;
	}
	public void load() {
		FileInputStream fis =null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("TextbookArray.dat");
			ois = new ObjectInputStream(fis);
			books = (Textbook[])ois.readObject();
			counter = (Integer)ois.readObject();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


	public void save() {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("TextbookArray.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
			oos.writeObject(counter);
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
	public void display() {
		for (int i = 0; i < counter; i++) {
			System.out.println(books[i]);
		}
	}
	//String bookTitle, String author, String publisher, double price, String iSBN
	public void importData(String fileName) {
		File file = new File(fileName);
		Scanner inp =null;
		try {
			inp = new Scanner(file);
			while(inp.hasNextLine()) {
				String data = inp.nextLine();
				String[] tokens = data.split(";");
				String bookTitle = tokens[0];
				String author = tokens[1];
				String publisher = tokens[2];
				double price = Double.parseDouble(tokens[3]);
				String ISBN = tokens[4];
				Textbook book = new Textbook(bookTitle,author, publisher, price, ISBN);
				addBook(book);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	public void exportTextbook(String fileName) {
		PrintWriter file =null;
		try {
			file =new PrintWriter(fileName);
			for(int i=0; i < counter; i++) {
				file.println(books[i].toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			file.close();
		}
	}

}
