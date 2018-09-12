package view;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CommonFields {

	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	
	private GridPane pane;
	
	public CommonFields() {
		pane = new GridPane();
		
		firstNameField = new TextField();
		firstNameField.setPromptText("first name");
		
		lastNameField = new TextField();
		lastNameField.setPromptText("last name");
		
		phoneNumberField = new TextField();
		phoneNumberField.setPromptText("phone number");
		
		pane.addRow(1, firstNameField,lastNameField);
		pane.addRow(2, phoneNumberField);
	}

	public TextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(TextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public TextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(TextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public TextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(TextField phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	
	public void clearAllFields() {
		firstNameField.clear();
		lastNameField.clear();
		phoneNumberField.clear();
	}
	
	
	
}
