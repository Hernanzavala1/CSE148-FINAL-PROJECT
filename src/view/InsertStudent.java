package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.CourseBag;
import model.PeopleBag;
import model.Person;
import model.Student;


public class InsertStudent {


	private BorderPane mainPane;

	private CommonFields common;
	private TextField gpaField;
	private TextField majorField;


	

	private Button saveButton;
	private Button resetButton;


	
	public InsertStudent(PeopleBag bag) {
		
		
		mainPane = new BorderPane();
		
		mainPane.setStyle("-fx-background:#E6E6FA;");
		
		
		
		Label welcomeLabel = new Label();
		welcomeLabel.setText("Welcome please enter the student's information:");
		welcomeLabel.setAlignment(Pos.TOP_CENTER);
		welcomeLabel.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 20));
		welcomeLabel.setStyle("-fx-Background-color: white");
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
		
		
		




		majorField = new TextField();
		majorField.setPromptText("Major");
		majorField.setAlignment(Pos.CENTER);


		fieldPane.getChildren().addAll(common.getFirstNameField(),common.getLastNameField(),
				common.getPhoneNumberField(),
				majorField);
		

		
		mainPane.setCenter(fieldPane);

		saveButton = new Button("Save");
		saveButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		
		resetButton = new Button("Reset");
		resetButton.setFont(Font.font("Times", FontWeight.BOLD, 14));


		saveButton.setOnAction(e -> {
			 String firstName = common.getFirstNameField().getText();
			 String lastName = common.getLastNameField().getText();
			 String phoneNumber = common.getPhoneNumberField().getText();
			 String Major = majorField.getText();
			 Student student = new Student(firstName,lastName,phoneNumber,Major);
			
			 	bag.addPerson(student);
			 	CourseBag studentCourseBag = new CourseBag(10,10,10);
			 	student.setCourses(studentCourseBag);
//				Util.comfirmAlert();
			
			 	common.clearAllFields();
			 	majorField.clear();
			 
			 	bag.display();

		});
		
		resetButton.setOnAction(e -> {
			common.clearAllFields();
			majorField.clear();
		});



		
		
		FlowPane buttonPane = new FlowPane();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setHgap(10);
		buttonPane.setVgap(10);
		buttonPane.setOrientation(Orientation.HORIZONTAL);
		buttonPane.setPrefWrapLength(400);
		buttonPane.setMaxWidth(450);
		buttonPane.setAlignment(Pos.BOTTOM_RIGHT);
		buttonPane.getChildren().addAll(resetButton,saveButton);
		mainPane.setBottom(buttonPane);




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

	public TextField getGpaField() {
		return gpaField;
	}

	public void setGpaField(TextField gpaField) {
		this.gpaField = gpaField;
	}

	public TextField getMajorField() {
		return majorField;
	}

	public void setMajorField(TextField majorField) {
		this.majorField = majorField;
	}



	

}
