package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Course;
import model.MasterCourseBag;
import model.Textbook;
import model.TextbookBag;

public class InsertCourse {
	private BorderPane insertPane;
	
	private TextField courseTitleField;
	private TextField courseNumberField;
	private TextField creditsField;
	private TextField textbookField;

	private Button saveButton;
	private Button resetButton;
	
	private MasterCourseBag bag;
	private TextbookBag bookBag;
	public InsertCourse(MasterCourseBag bag,TextbookBag bookBag) {
		this.bag = bag;
		this.bookBag = bookBag;
		
		insertPane = new BorderPane();
		insertPane.setPadding(new Insets(10));
		
		// create label for insert scene
		Label insertLabel = new Label();
		insertLabel.setText("Please enter the course's information:");
		insertLabel.setMinWidth(200);
		insertLabel.setStyle("-fx-background-color:White");
		insertLabel.setAlignment(Pos.TOP_CENTER);
		insertLabel.setFont(Font.font("Times", FontWeight.BOLD, 20));
		
		// container for the above label
		HBox topBox = new HBox();
		topBox.setPadding(new Insets(10));
		topBox.setMinWidth(insertLabel.getMinWidth());
		topBox.setAlignment(Pos.TOP_CENTER);
		topBox.getChildren().add(insertLabel);
		
		insertPane.setTop(topBox);
		
		//create all of the textFields to gather info
		courseTitleField = new TextField();
		courseTitleField.setPromptText("Course Title");
		courseTitleField.setMinWidth(200);
		
		courseNumberField = new TextField();
		courseNumberField.setPromptText("Course Number");
		courseNumberField.setMinWidth(200);
		
		creditsField = new TextField();
		creditsField.setPromptText("credits");
		creditsField.setMinWidth(200);
		
		textbookField = new TextField();
		textbookField.setPromptText("Textbook ISBN");
		textbookField.setMinWidth(200);
		
		
		FlowPane fieldPane = new FlowPane();
		fieldPane.setPadding(new Insets(10));
		fieldPane.setOrientation(Orientation.HORIZONTAL);
		fieldPane.setPrefWrapLength(300);
		fieldPane.setMinWidth(200);
		fieldPane.setMaxWidth(450);
		fieldPane.setVgap(10);
		fieldPane.setHgap(8);
		fieldPane.setAlignment(Pos.CENTER);
		
		fieldPane.getChildren().addAll(courseTitleField,courseNumberField,creditsField,textbookField);
		
		insertPane.setCenter(fieldPane);
		
		saveButton = new Button("save");
		resetButton = new Button("reset");
		
		
		HBox buttonBox = new HBox();
		buttonBox.setPadding(new Insets(10));
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		buttonBox.setSpacing(10);
		buttonBox.setMinWidth(280);
		buttonBox.getChildren().addAll(resetButton,saveButton);
		
		insertPane.setBottom(buttonBox);
		
		setActionSaveButton();
		setActionResetButton();
		
		
		
		
		
	}

	public void clearFields() {
		courseTitleField.clear();
		courseNumberField.clear();
		creditsField.clear();
	}

	


	private void setActionResetButton() {
		resetButton.setOnAction(e ->{
		clearFields();
		});
		
	}


	private void setActionSaveButton() {
	saveButton.setOnAction(e ->{
		
		String courseTitle = courseTitleField.getText();
		String courseNumber = courseNumberField.getText();
		String credit = creditsField.getText();
		String textbookNumber = textbookField.getText();
		int credits = Integer.parseInt(credit);
		Course addCourse = new Course(courseTitle,courseNumber,credits);
		
		if(Util.inputCheck(textbookField, "textbook number cant be EMPTY!")) {
			bag.addCourse(addCourse);
			try {
				Textbook book = bookBag.findTextbook(textbookNumber);
				addCourse.setBook(book);
			}catch(NullPointerException tt) {
				Util.BookNotFound();
			}
		}
		else{
			Util.ExecutionFailed();
		}
		
		
		
		bag.display();
		clearFields();
	});
			}


	public BorderPane getInsertPane() {
		return insertPane;
	}


	public void setInsertPane(BorderPane insertPane) {
		this.insertPane = insertPane;
	}


	public TextField getCourseTitleField() {
		return courseTitleField;
	}


	public void setCourseTitleField(TextField courseTitleField) {
		this.courseTitleField = courseTitleField;
	}


	public TextField getCourseNumberField() {
		return courseNumberField;
	}


	public void setCourseNumberField(TextField courseNumberField) {
		this.courseNumberField = courseNumberField;
	}


	public TextField getCreditsField() {
		return creditsField;
	}


	public void setCreditsField(TextField creditsField) {
		this.creditsField = creditsField;
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
