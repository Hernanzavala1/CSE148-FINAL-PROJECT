package view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import model.PeopleBag;
import model.Student;

public class UpdateStudent {

	private BorderPane mainPane;
	private Button saveUpdates;
	private Button reset;
	
	
	public UpdateStudent(Student student,PeopleBag bag) {
		mainPane = new BorderPane();
		
		InsertStudent insertPane = new InsertStudent(bag);
		
		saveUpdates = insertPane.getSaveButton();
		reset = insertPane.getResetButton();
		
		saveUpdates.setOnAction(e ->{
			String firstName = insertPane.getCommon().getFirstNameField().getText();
			String lastName = insertPane.getCommon().getLastNameField().getText();
			String phoneNumber = insertPane.getCommon().getPhoneNumberField().getText();
			String major = insertPane.getMajorField().getText();
			
			if(!firstName.isEmpty()) {
				student.setFirstName(firstName);
			}
			if(!lastName.isEmpty()) {
				student.setLastName(lastName);
			}
			if(!phoneNumber.isEmpty()) {
				student.setPhonenNumber(phoneNumber);
			}
			if(!major.isEmpty()) {
				student.setMajor(major);
			}
			insertPane.getCommon().clearAllFields();
			insertPane.getMajorField().clear();
		
		});
		
		reset.setOnAction(insertPane.getResetButton().getOnAction());
		
		mainPane.setCenter(insertPane.getMainPane());
		
	}


	public BorderPane getMainPane() {
		return mainPane;
	}


	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}


	public Button getSaveUpdates() {
		return saveUpdates;
	}


	public void setSaveUpdates(Button saveUpdates) {
		this.saveUpdates = saveUpdates;
	}


	public Button getReset() {
		return reset;
	}


	public void setReset(Button reset) {
		this.reset = reset;
	}
	


}
