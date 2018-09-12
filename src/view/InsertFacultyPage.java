package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Faculty;
import model.PeopleBag;
import model.Student;

public class InsertFacultyPage {
	

	private BorderPane mainPane; 
	private CommonFields common;
	private TextField salaryField;
	private TextField titleField;
	
	private Button saveButton;
	
	private Button resetButton;
	
	
	public InsertFacultyPage(PeopleBag bag) {
		
		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background:#E6E6FA;");
		mainPane.setPadding(new Insets(12));
		
		Label welcomeLabel = new Label();
		welcomeLabel.setText("Welcome please enter the Faculty's information:");
		welcomeLabel.setStyle("-fx-Background-color:white");
		
		welcomeLabel.setAlignment(Pos.TOP_CENTER);
		welcomeLabel.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 20));
		HBox topLabel = new HBox();
		topLabel.getChildren().add(welcomeLabel);
		topLabel.setPadding(new Insets(10));
		topLabel.setAlignment(Pos.TOP_CENTER);
		mainPane.setTop(topLabel);
		
	
		common = new CommonFields();
		
		FlowPane fieldPane = new FlowPane();
		fieldPane.setOrientation(Orientation.HORIZONTAL);
		fieldPane.setPadding(new Insets(10));
		fieldPane.setHgap(8);
		fieldPane.setVgap(10);
		fieldPane.setPrefWrapLength(400);
		fieldPane.setMaxWidth(450);
		fieldPane.setAlignment(Pos.CENTER);
		
		salaryField = new TextField();
		salaryField.setPromptText("Salary");
		salaryField.setAlignment(Pos.CENTER);	
		
		titleField = new TextField();
		titleField.setPromptText("title");
		titleField.setAlignment(Pos.CENTER);

		fieldPane.getChildren().addAll(common.getFirstNameField(),common.getLastNameField(),common.getPhoneNumberField(),
				salaryField,titleField);
	
		mainPane.setCenter(fieldPane);
		
		
		
		resetButton = new Button("reset");
		resetButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		saveButton= new Button("save");
		saveButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		
		
		
		resetButton.setOnAction(e ->{
			common.clearAllFields();
			salaryField.clear();
			titleField.clear();
		});
		
		saveButton.setOnAction(e ->{
			String firstName = common.getFirstNameField().getText();
			 String lastName = common.getLastNameField().getText();
			 String phoneNumber = common.getPhoneNumberField().getText();
			 String title = titleField.getText();
			 double salary = Double.parseDouble(salaryField.getText());
			 Faculty faculty = new Faculty(firstName,lastName,phoneNumber,title,salary);
			
			 	bag.addPerson(faculty);
			 	bag.display();
			 	common.clearAllFields();
				salaryField.clear();
				titleField.clear();
		});
		
		HBox buttonBox = new HBox();
		buttonBox.setPadding(new Insets(12));
		buttonBox.setMinWidth(200);
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		buttonBox.getChildren().addAll(resetButton,saveButton);
		
		mainPane.setBottom(buttonBox);
	}



	public BorderPane getMainPane() {
		return mainPane;
	}



	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}



	public CommonFields getCommon() {
		return common;
	}

	public void setCommon(CommonFields common) {
		this.common = common;
	}

	public TextField getSalaryField() {
		return salaryField;
	}

	public void setSalaryField(TextField salaryField) {
		this.salaryField = salaryField;
	}

	public TextField getTitleField() {
		return titleField;
	}

	public void setTitleField(TextField titleField) {
		this.titleField = titleField;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
	}



	public Button getResetButton() {
		return resetButton;
	}

	public void setResetButton(Button resetButton) {
		this.resetButton = resetButton;
	}
	
	
}
