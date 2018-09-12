package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Course;
import model.MasterCourseBag;
import model.Student;
import model.TextbookBag;

public class CoursePage {
	private Scene CoursePageScene;
	private BorderPane mainPane;

	private Button insertButton;
	private Button searchButton;
	private Button removeButton;
	private Button updateButton;
	private Button goBackButton;

	private MasterCourseBag courseBag;
	private TextbookBag bookBag;

	public CoursePage(EventHandler<ActionEvent> onAction) {
		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background:#E6E6FA;");
		mainPane.setStyle("-fx-Background-image: url(/view/trees.jpg)");
		
		Label pageLabel = new Label();
		pageLabel.setText("Welcome to Course page");
		pageLabel.setMinWidth(250);
		pageLabel.setStyle("-fx-Background-color: White");
		pageLabel.setAlignment(Pos.TOP_CENTER);
		pageLabel.setFont(Font.font("Times", FontWeight.BOLD, 20));
		HBox topPane = new HBox();
		topPane.setPadding(new Insets(10));
		topPane.setAlignment(Pos.TOP_CENTER);
		topPane.setMinWidth(pageLabel.getMinWidth());
		topPane.getChildren().add(pageLabel);
		mainPane.setTop(topPane);

		insertButton = new Button("insert Course");
		insertButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		insertButton.minWidth(100);
		searchButton = new Button("search Course");
		searchButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		searchButton.minWidth(100);
		removeButton = new Button("remove Course");
		removeButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		removeButton.minWidth(100);
		updateButton = new Button("update Course");
		updateButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		updateButton.maxWidth(100);
		goBackButton = new Button("Go Back");
		goBackButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		goBackButton.setOnAction(onAction);
		

		VBox buttonBox = new VBox();

		buttonBox.setPadding(new Insets(12));
		buttonBox.setMaxWidth(300);
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton, searchButton, removeButton, updateButton,goBackButton);

		mainPane.setLeft(buttonBox);

		insertButton.setOnAction(e -> {
			InsertCourse course = new InsertCourse(courseBag,bookBag);
			mainPane.setCenter(course.getInsertPane());
		});

		// set action event for the rest of buttons;

		setSearchButtonAction();
		setRemoveButtonAction();
		setUpdateButtonAction();

		CoursePageScene = new Scene(mainPane, 600, 400);
		
	}





	public TextbookBag getBookBag() {
		return bookBag;
	}





	public void setBookBag(TextbookBag bookBag) {
		this.bookBag = bookBag;
	}





	private void setUpdateButtonAction() {
       updateButton.setOnAction(e ->{
    		String courseNumber = String.valueOf(Util.getCourseNumber());
			try {
				Course courseFound = courseBag.findCourse(courseNumber);
				UpdateCourse updateCourse = new UpdateCourse(courseBag,bookBag,courseFound);
			mainPane.setCenter(updateCourse.getUpdatePane());
			}catch(NullPointerException tt) {
				Util.personNotFound();
			}
       });
	}

	private void setRemoveButtonAction() {
		// TODO Auto-generated method stub
		removeButton.setOnAction(e -> {
			
			Course courseFound = courseBag.removeCourse(Util.getCourseNumber());
			mainPane.setCenter(displayCourse(courseFound));
			courseBag.display();
			
		});

	}

	private void setSearchButtonAction() {
		searchButton.setOnAction(e -> {
			try{
				Course courseFound = courseBag.findCourse(Util.getCourseNumber());
				mainPane.setCenter(displayCourse(courseFound));
				courseBag.display();
			}catch(NullPointerException er) {
				Util.ExecutionFailed();
			}
	
			
		});

	}

	public BorderPane displayCourse(Course course) {
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));

		TextField courseTitleField = new TextField();
		courseTitleField.setText(course.getCourseTitle());
		courseTitleField.setMinWidth(200);

		TextField courseNumberField = new TextField();
		courseNumberField.setText(course.getCourseNumber());
		courseNumberField.setMinWidth(200);

		TextField creditsField = new TextField();
		creditsField.setText(String.valueOf(course.getNumberCreds()));
		creditsField.setMinWidth(200);
		
		TextField textbookField = new TextField();
		textbookField.setText(course.getBook().getBookTitle());
		textbookField.setMinWidth(200);

		FlowPane fieldPane = new FlowPane();
		fieldPane.setPadding(new Insets(10));
		fieldPane.setOrientation(Orientation.VERTICAL);
		fieldPane.setPrefWrapLength(500);
		fieldPane.setMinHeight(300);
		fieldPane.setMaxHeight(500);
		fieldPane.setVgap(10);
		fieldPane.setHgap(8);
		fieldPane.setAlignment(Pos.CENTER);

		fieldPane.getChildren().addAll(courseTitleField, courseNumberField, creditsField,textbookField);

		pane.setCenter(fieldPane);

		Label courseTitle = new Label("Course Title:");
		courseTitle.setAlignment(Pos.CENTER_LEFT);
		courseTitle.setStyle("-fx-background-color:White");
		courseTitle.setFont(Font.font("Times", FontWeight.BOLD, 14));
		
		Label courseNumber = new Label("Course Number:");
		courseNumber.setStyle("-fx-background-color:White");
		courseNumber.setAlignment(Pos.CENTER_LEFT);
		courseNumber.setFont(Font.font("Times", FontWeight.BOLD, 14));

		
		Label credits = new Label("Credits:");
		credits.setStyle("-fx-background-color:White");
		credits.setAlignment(Pos.CENTER_LEFT);
		credits.setFont(Font.font("Times", FontWeight.BOLD, 14));
		
		Label book = new Label("Book:");
		book.setStyle("-fx-background-color:White");
		book.setAlignment(Pos.CENTER_LEFT);
		book.setFont(Font.font("Times", FontWeight.BOLD, 14));

		FlowPane labelPane = new FlowPane();
		labelPane.setPadding(new Insets(10));
		labelPane.setOrientation(Orientation.VERTICAL);
		labelPane.setPrefWrapLength(500);
		labelPane.setMinHeight(300);
		labelPane.setMaxHeight(500);
		labelPane.setVgap(10);
		labelPane.setHgap(8);
		labelPane.setAlignment(Pos.CENTER_LEFT);
		labelPane.getChildren().addAll(courseTitle, courseNumber, credits,book);

		pane.setLeft(labelPane);

		return pane;
	}

	public Scene getCoursePageScene() {
		return CoursePageScene;
	}

	public void setCoursePageScene(Scene pageScene) {
		CoursePageScene = pageScene;
	}

	public BorderPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}

	public Button getInsertButton() {
		return insertButton;
	}

	public void setInsertButton(Button insertButton) {
		this.insertButton = insertButton;
	}

	public Button getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(Button searchButton) {
		this.searchButton = searchButton;
	}

	public Button getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(Button removeButton) {
		this.removeButton = removeButton;
	}

	public Button getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(Button updateButton) {
		this.updateButton = updateButton;
	}

	public MasterCourseBag getCourseBag() {
		return courseBag;
	}

	public void setCourseBag(MasterCourseBag courseBag) {
		this.courseBag = courseBag;
	}

}
