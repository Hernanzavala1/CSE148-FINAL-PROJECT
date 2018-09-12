package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.CourseBag;
import model.MasterCourseBag;
import model.PeopleBag;
import model.Person;
import model.Student;

public class StudentPage {

	private Scene primaryScene;

	private BorderPane pane;

	private Button insertButton;
	private Button searchButton;
	private Button removeButton;
	private Button updateButton;
	private Button addCourses;
	private Button goBackButton;
	private InsertStudent insert;
	private Button viewCourses;
	
	private PeopleBag bag;
	private MasterCourseBag coursesTotal;
	private CourseBag studentsCourses;
	



	public StudentPage(EventHandler<ActionEvent> onAction) {
		pane = new BorderPane();
		
		pane.setStyle("-fx-background:#D3D3D3;");
		pane.setStyle("-fx-background-image: url(/view/nature2.jpg)");

		Label studentPageLabel = new Label();
		studentPageLabel.setText("Welcome Students!\n" + " Please choose from options below!");

		studentPageLabel.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 20));
		studentPageLabel.setStyle("-fx-background-color:white");
		studentPageLabel.setTextFill(Color.BLACK);
		FlowPane topPane = new FlowPane();
		topPane.setPadding(new Insets(6));
		topPane.setOrientation(Orientation.HORIZONTAL);
		topPane.setAlignment(Pos.TOP_CENTER);
		topPane.getChildren().add(studentPageLabel);
		pane.setTop(topPane);

		insertButton = new Button("insert Student");
		insertButton.minWidth(200);
		insertButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		searchButton = new Button("search Student");
		searchButton.minWidth(200);
		searchButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		removeButton = new Button("remove Student");
		removeButton.minWidth(200);
		removeButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		addCourses = new Button("Add courses");
		addCourses.minWidth(200);
		addCourses.setFont(Font.font("Times", FontWeight.BOLD, 14));
		updateButton = new Button("update Student");
		updateButton.minWidth(200);
		updateButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		goBackButton = new Button("Go Back");
		goBackButton.minWidth(200);
		goBackButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		goBackButton.setOnAction(onAction);
		viewCourses = new Button("View student course");
		viewCourses.setFont(Font.font("Times", FontWeight.BOLD, 14));

		VBox buttonPane = new VBox();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setMaxWidth(300);
		buttonPane.setSpacing(10);

		buttonPane.getChildren().addAll(insertButton, searchButton, removeButton, addCourses, updateButton,viewCourses,
				goBackButton);

		pane.setLeft(buttonPane);
		
		updateButton.setOnAction(e ->{
			String id = String.valueOf(Util.getId());
			try {
				Student studentFound = (Student)bag.findById(id);
				UpdateStudent update = new UpdateStudent(studentFound,bag);
				pane.setCenter(update.getMainPane());
			}catch(NullPointerException tt) {
				Util.personNotFound();
			}
			
		});
		addCourses.setOnAction(e ->{
		String id = String.valueOf(Util.getId());
		try {
				Student studentFound = (Student)bag.findById(id);
				AddCourses addcourses = new AddCourses(studentFound);
				pane.setCenter(addcourses.getAddCoursePane());
		}catch(NullPointerException rr) {
			Util.personNotFound();
		}
			
			
		});
		
		viewCourses.setOnAction(e ->{
			String id = String.valueOf(Util.getId()); 
			try {
				Student studentFound = (Student)bag.findById(id);
				StudentCoursesView studentCourses = new StudentCoursesView(studentFound);
				pane.setCenter(studentCourses.getPane());
				
			}catch(NullPointerException rr) {
				Util.personNotFound();
			}
		});
		

		insertButton.setOnAction(e -> {
			insert = new InsertStudent(bag);
			pane.setCenter(insert.getMainPane());
			

		});

		searchButton.setOnAction(e -> {
			String idString = String.valueOf(Util.getId());
			try {
			Student personFound = (Student) bag.findById(idString);
			pane.setCenter(displayPerson(personFound));
			}catch (NullPointerException ex) {
				Util.personNotFound();
			}

		});

		removeButton.setOnAction(e -> {
			String idString ="" + Util.getId();
			try {
			Student deletedPerson = (Student) bag.deleteById(idString);
			pane.setCenter(displayPerson(deletedPerson));
			bag.display();
			}catch(NullPointerException exs) {
				Util.personNotFound();
			}

		});

		primaryScene = new Scene(pane, 800, 500);

	}


	public BorderPane getPane() {
		return pane;
	}

	public void setPane(BorderPane pane) {
		this.pane = pane;
	}

	// generic method that will display a person either bafter search method or
	// remove method done
	private BorderPane displayPerson(Student person) {
		BorderPane mainPane = new BorderPane();

		InsertStudent page = new InsertStudent(bag);
		TextField firstName = page.getCommon().getFirstNameField();
		firstName.setText(person.getFirstName());
		TextField lastName = page.getCommon().getLastNameField();
		lastName.setText(person.getLastName());
		TextField phoneNumber = page.getCommon().getPhoneNumberField();
		phoneNumber.setText(person.getPhonenNumber());
		TextField id = new TextField(person.getId());
		id.setEditable(false);
		person.setGpa(coursesTotal);
		double gpa = person.getGpa();
		TextField gpaField = new TextField();
		gpaField.setEditable(false);
		DecimalFormat df = new DecimalFormat("#.##");
		gpaField.setText(String.valueOf(df.format(gpa)));
		

		Label firstName1 = new Label("First Name:");
		firstName1.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 14));
		firstName1.setStyle("-fx-background-color:white");
		firstName1.setTextFill(Color.BLACK);
		
		Label lastName1 = new Label("Last Name");
		lastName1.setStyle("-fx-background-color:white");
		lastName1.setTextFill(Color.BLACK);
		lastName1.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 14));
		
		Label phoneNumber1 = new Label("phone Number");
		phoneNumber1.setStyle("-fx-background-color:white");
		phoneNumber1.setTextFill(Color.BLACK);
		phoneNumber1.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 14));
		
		Label gpaLabel = new Label("GPA:");
		gpaLabel.setStyle("-fx-background-color:white");
		gpaLabel.setTextFill(Color.BLACK);
		gpaLabel.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 14));
		
		Label id3 = new Label("id");
		id3.setStyle("-fx-background-color:white");
		id3.setTextFill(Color.BLACK);
		id3.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 14));
		
		FlowPane labelPane = new FlowPane();
		labelPane.setOrientation(Orientation.VERTICAL);
		labelPane.setAlignment(Pos.CENTER);
		labelPane.setPadding(new Insets(10));
		labelPane.setHgap(8);
		labelPane.setVgap(10);
		labelPane.setPrefWrapLength(400);
		labelPane.setMaxHeight(450);
		labelPane.getChildren().addAll(firstName1, lastName1, phoneNumber1,gpaLabel, id3);
		mainPane.setLeft(labelPane);

		FlowPane fieldPane = new FlowPane();
		fieldPane.setOrientation(Orientation.VERTICAL);
		fieldPane.setPadding(new Insets(10));
		fieldPane.setHgap(8);
		fieldPane.setVgap(10);
		fieldPane.setPrefWrapLength(400);
		fieldPane.setMaxHeight(450);
		fieldPane.setAlignment(Pos.CENTER);

		fieldPane.getChildren().addAll(firstName, lastName, phoneNumber,gpaField, id);
		mainPane.setCenter(fieldPane);

		return mainPane;

	}

	public Scene getPrimaryScene() {
		return primaryScene;
	}

	public void setPrimaryScene(Scene primaryScene) {
		this.primaryScene = primaryScene;
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

	public Button getAddCourses() {
		return addCourses;
	}

	public void setAddCourses(Button addCourses) {
		this.addCourses = addCourses;
	}

	public InsertStudent getInsert() {
		return insert;
	}

	public void setInsert(InsertStudent insert) {
		this.insert = insert;
	}

	public PeopleBag getBag() {
		return bag;
	}

	public void setBag(PeopleBag bag) {
		this.bag = bag;
	}

	public StudentPage(PeopleBag bag) {
		this.bag = bag;

	}
	public Button getGoBackButton() {
		return goBackButton;
	}


	public void setGoBackButton(Button goBackButton) {
		this.goBackButton = goBackButton;
	}
//
//
	public CourseBag getStudentsCourses() {
		return studentsCourses;
	}


	public void setStudentsCourses(CourseBag studentsCourses) {
		this.studentsCourses = studentsCourses;
	}


	public MasterCourseBag getCoursesTotal() {
		return coursesTotal;
	}


	public void setCoursesTotal(MasterCourseBag coursesTotal) {
		this.coursesTotal = coursesTotal;
	}


}
