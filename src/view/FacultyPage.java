package view;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Faculty;
import model.PeopleBag;
import model.Person;
import model.Student;


public class FacultyPage {

	private BorderPane mainPane;
	

	private InsertFacultyPage insertPage;

	private Button insertFaculty;
	private Button findButton;
	private Button deleteButton;
	private Button updateButton;
	private Button goBackButton;

	private Scene FacultyPageScene;

	private PeopleBag bag;

	

	public FacultyPage(EventHandler<ActionEvent> onAction) {

		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background:#E6E6FA;");
		mainPane.setStyle("-fx-background-image: url(/view/nature3.jpg)");

		Label facultyPageLabel = new Label("Welcome to Faculty Page!\n Please choose an option:");
		facultyPageLabel.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 20));
		facultyPageLabel.setStyle("-fx-Background-color: white");
		HBox top = new HBox();
		top.setPadding(new Insets(10));
		top.setAlignment(Pos.TOP_CENTER);
		top.setMinWidth(facultyPageLabel.getMinWidth());

		top.getChildren().add(facultyPageLabel);
		mainPane.setTop(top);

		insertFaculty = new Button("Insert Faculty");
		insertFaculty.setFont(Font.font("Times", FontWeight.BOLD, 14));
		findButton = new Button("Find Faculty");
		findButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		deleteButton = new Button("Remove Faculty");
		deleteButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		updateButton = new Button("Update Faculty");
		updateButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		goBackButton = new Button("Go Back");
		goBackButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		goBackButton.setOnAction(onAction);

		FlowPane buttonPane = new FlowPane();
		buttonPane.setOrientation(Orientation.VERTICAL);
		buttonPane.setPadding(new Insets(10));
		buttonPane.setHgap(10);
		buttonPane.setVgap(10);
		buttonPane.setPrefWrapLength(300);
		buttonPane.setMaxHeight(450);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(insertFaculty, findButton, deleteButton, updateButton, goBackButton);

		mainPane.setLeft(buttonPane);

		setInsertButtonAction();
		setFindButtonAction();
		setDeleteButtonAction();
	
		 setUpdateButtonAction();

		FacultyPageScene = new Scene(mainPane, 700, 500);
	
	}

	public void setUpdateButtonAction() {
		updateButton.setOnAction(e -> {
			
			String idString = String.valueOf(Util.getId());
			try {
			Faculty personFound = (Faculty) bag.findById(idString);
			UpdateFaculty update = new UpdateFaculty(personFound,bag);
			mainPane.setCenter(update.getMainPane());
			}catch (NullPointerException ex) {
				Util.personNotFound();
			}

			
		});
	}





	public FacultyPage() {
		// TODO Auto-generated constructor stub
	}



	public void setDeleteButtonAction() {
		deleteButton.setOnAction(e -> {
			String idString = String.valueOf(Util.getId());
			try {
				Person personFound = bag.deleteById(idString);
				if(personFound instanceof Faculty) {
					mainPane.setCenter(displayPerson((Faculty) personFound));
				}
				else {
					throw new Exception();
				}
				

			}catch (Exception x) {
				// TODO Auto-generated catch block
				x.printStackTrace();
				Util.WrongId();
			}
			
			
		});
	}

	public void setFindButtonAction() {
		findButton.setOnAction(e -> {
		 String idString = String.valueOf(Util.getId()) ;
			try {
				Person personFound = bag.findById(idString);
				if(personFound instanceof Faculty) {
					mainPane.setCenter(displayPerson((Faculty) personFound));
				}
				else {
					throw new Exception();
				}
				

			}catch (Exception x) {
				// TODO Auto-generated catch block
				x.printStackTrace();
				Util.WrongId();
			}
		});
	}

	private void setInsertButtonAction() {

		insertFaculty.setOnAction(e -> {
			insertPage = new InsertFacultyPage(bag);
			mainPane.setCenter(insertPage.getMainPane());

		});

	}


	public Pane getMainPane() {
		return this.mainPane;
	}

	private BorderPane displayPerson(Faculty person) {
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
		TextField title = new TextField(person.getTitle());
		TextField salary = new TextField(String.valueOf(person.getSalary()));

		Label firstName1 = new Label("First Name:");
		firstName1.setFont(Font.font("Times", FontWeight.BOLD, 14));
		firstName1.setStyle("-fx-background-color:White");
		
		Label lastName1 = new Label("Last Name:");
		lastName1.setFont(Font.font("Times", FontWeight.BOLD, 14));
		lastName1.setStyle("-fx-background-color:White");
		
		Label phoneNumber1 = new Label("phone Number:");
		phoneNumber1.setFont(Font.font("Times", FontWeight.BOLD, 14));
		phoneNumber1.setStyle("-fx-background-color:White");
		
		Label id3 = new Label("id:");
		id3.setFont(Font.font("Times", FontWeight.BOLD, 14));
		id3.setStyle("-fx-background-color:White");
		
		Label titleLabel = new Label("title:");
		titleLabel.setFont(Font.font("Times", FontWeight.BOLD, 14));
		titleLabel.setStyle("-fx-background-color:White");
		
		Label salaryLabel = new Label("Salary:");
		salaryLabel.setFont(Font.font("Times", FontWeight.BOLD, 14));
		salaryLabel.setStyle("-fx-background-color:White");
		
		FlowPane labelPane = new FlowPane();
		labelPane.setOrientation(Orientation.VERTICAL);
		labelPane.setAlignment(Pos.CENTER);
		labelPane.setPadding(new Insets(10));
		labelPane.setHgap(8);
		labelPane.setVgap(15);
		labelPane.setPrefWrapLength(400);
		labelPane.setMaxHeight(450);
		labelPane.getChildren().addAll(firstName1, lastName1, phoneNumber1, id3, titleLabel, salaryLabel);
		mainPane.setLeft(labelPane);

		FlowPane fieldPane = new FlowPane();
		fieldPane.setOrientation(Orientation.VERTICAL);
		fieldPane.setPadding(new Insets(10));
		fieldPane.setHgap(8);
		fieldPane.setVgap(10);
		fieldPane.setPrefWrapLength(400);
		fieldPane.setMaxHeight(450);
		fieldPane.setAlignment(Pos.CENTER);

		fieldPane.getChildren().addAll(firstName, lastName, phoneNumber, id, title, salary);
		mainPane.setCenter(fieldPane);

		return mainPane;

	}


	public Button getInsertFaculty() {
		return insertFaculty;
	}

	public void setInsertFaculty(Button insertFaculty) {
		this.insertFaculty = insertFaculty;
	}

	public Button getFindButton() {
		return findButton;
	}

	public void setFindButton(Button findButton) {
		this.findButton = findButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(Button deleteButton) {
		this.deleteButton = deleteButton;
	}

	public Button getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(Button updateButton) {
		this.updateButton = updateButton;
	}

	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}

	public PeopleBag getBag() {
		return bag;
	}

	public void setBag(PeopleBag bag) {
		this.bag = bag;
	}

	public Scene getFacultyPageScene() {
		return FacultyPageScene;
	}

	public void setFacultyPageScene(Scene insertFacultyScene) {
		this.FacultyPageScene = insertFacultyScene;
	}

}
