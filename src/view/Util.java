package view;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class Util {

	public static String getFileName() {
		TextInputDialog dialog = new TextInputDialog("File Name!");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a text input dialog");
		dialog.setContentText("Please enter the file name:");
		
		Optional<String> result = dialog.showAndWait();
		String fileName =null;
		if(result.isPresent()) {
			return fileName = result.get();
			
			
		}
		return fileName;
	}
	public static void courseReapeted() {
		
	}
	public static void BookNotFound() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error!");
		alert.setContentText("Book was not found!");
		alert.showAndWait();
	}
	public static void personNotFound() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error!");
		alert.setContentText("Person was not found!");
		alert.showAndWait();
	}
	
	public static int getId() {
		TextInputDialog dialog = new TextInputDialog("Student Id");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText(" text input dialog");
		dialog.setContentText("Please enter the student id number!");

		// if value entered is not a number will throw numberformatException;
		Optional<String> result = dialog.showAndWait();
		String input = result.get().toString();
		try {
			int id = Integer.parseInt(input);
			String idString = String.valueOf(id);
			return id;

			
		} catch (NumberFormatException ex) {
			ex.getStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error!");
			alert.setContentText("you did not enter a number!");
			alert.showAndWait();
		}
		return -1;
	}
	
	
	
	public static void NotANumberAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error!");
		alert.setContentText("you did not enter a number!");
		alert.showAndWait();
	}
	public static void WrongId() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error!");
		alert.setContentText("Wrong ID! Please try again!");
		alert.showAndWait();
	}
	public static String getCourseNumber() {
		TextInputDialog dialog = new TextInputDialog("Course Number!");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a text input dialog");
		dialog.setContentText("Please enter the course number!");
		
		Optional<String> result = dialog.showAndWait();
		String courseNumber =null;
		if(result.isPresent()) {
			return courseNumber = result.get();
			
		}
		return courseNumber;
	}
	public static void rememberGrade() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Reminder!");
		alert.setContentText("Please do not forget to enter grade received!");
		alert.showAndWait();
	}
	
	public static boolean inputCheck(TextField textField, String message) {
		
		String textFieldContent = textField.getText().trim();
		

		if (textFieldContent.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alert");
			
			alert.setContentText(message);
			alert.showAndWait();

			
			return false;
			
		} else {
			
			return true;
		}

	}
	
	public static void ExecutionFailed() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setContentText("The Process was not Completed! try again!");
		alert.showAndWait();
	}
	public static String getUserInput(String message) {
		// TODO Auto-generated method stub
		TextInputDialog dialog = new TextInputDialog("Book ISBN number!");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a text input dialog");
		dialog.setContentText(message);
		
		Optional<String> result = dialog.showAndWait();
		String isbn =null;
		if(result.isPresent()) {
			return isbn = result.get();
			
		}
		return isbn;
	}
	
	
}
