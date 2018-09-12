package view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import model.Faculty;
import model.PeopleBag;

public class UpdateFaculty {
private BorderPane mainPane;
private Button saveUpdates;
private Button reset;
	
	public UpdateFaculty(Faculty faculty,PeopleBag bag) {
		mainPane = new BorderPane();
		InsertFacultyPage fieldPage = new InsertFacultyPage(bag);
		saveUpdates =fieldPage.getSaveButton();
		reset = fieldPage.getResetButton();
		reset.setOnAction(
			fieldPage.getResetButton().getOnAction()
		);
		// this works maybe look into other situations where it would be beneficial
//		saveUpdates.setOnAction(e -> System.out.println("its littttt"));
		saveUpdates.setOnAction( e ->{
			String firstName = fieldPage.getCommon().getFirstNameField().getText();
			String lastName = fieldPage.getCommon().getLastNameField().getText();
			String phoneNumber = fieldPage.getCommon().getPhoneNumberField().getText();
			String title = fieldPage.getTitleField().getText();
			String salary = fieldPage.getSalaryField().getText();
			try {
			if(!firstName.isEmpty()) {
				faculty.setFirstName(firstName);
			}
			if(!lastName.isEmpty()) {
				faculty.setLastName(lastName);
			}
			if(!phoneNumber.isEmpty()) {
				faculty.setPhonenNumber(phoneNumber);
			}
			if(!title.isEmpty()) {
				faculty.setTitle(title);
			}
			
			if(!salary.isEmpty()) {
				faculty.setSalary(Double.parseDouble(salary));
			}
			}catch(NumberFormatException er) {
				Util.NotANumberAlert();
			}
			fieldPage.getCommon().clearAllFields();
			fieldPage.getTitleField().clear();
			fieldPage.getSalaryField().clear();
		});
		mainPane.setCenter(fieldPage.getMainPane());
	}


	


	public BorderPane getMainPane() {
		return mainPane;
	}


	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}
	
}
