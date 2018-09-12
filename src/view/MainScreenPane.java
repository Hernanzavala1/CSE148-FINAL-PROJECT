package view;



import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.MasterCourseBag;
import model.PeopleBag;
import model.TextbookBag;

public class MainScreenPane {

	private Scene mainScene;
	private BorderPane mainPane;
	private Stage mainScreenStage;
  

	private Button studentButton;
	private Button facultyButton;
	private Button courseButton;
	private Button textbookButton;
	private Button importExportbutton;
	
	private Label collegeLabel;
	private Button allPeople;
	private Button allCourses;
	
	
		
	
	private MasterCourseBag courseBag;
	private PeopleBag bag;
	private TextbookBag bookBag;
	
	public MainScreenPane() {
		/*This program is all based on using a single stage that will host all of the different 
		 * scenes which correspond to each of my pages
		 * 
		 * As soon as i start my program i create all of the bags that will be used throughout and it also loads all 
		 * the bags so previous content gets back up in the system;
		 * 
		 * Overall every of my page classes will contain a single scene where i will add different Layouts 
		 * to the center as buttons are clicked.
		 * 
		 * All of the bags are only instantiated once and then are passed to different classes by using
		 * setter methods and such
		 * 
		 * Very fun to work with the css style to put in backgrounds 
		 * 
		 * Thank you for a great semester!
		 * 
		 * 
		 * 
		 */
		
		
		courseBag = new MasterCourseBag(20);
		bag = new PeopleBag(20);
		bookBag = new TextbookBag(20);
     	load();
		
		
		mainPane = new BorderPane();


		// tried to put a heading on my main page but not working
		Label welcomeLabel = new Label();
		welcomeLabel.setText("welcome to Main Page!");
		welcomeLabel.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 20));
		welcomeLabel.setTextFill(Color.BLACK);
		welcomeLabel.setStyle("-fx-background-color:white");
		welcomeLabel.setMinWidth(250);
		welcomeLabel.setAlignment(Pos.TOP_CENTER);
		HBox labelBox = new HBox();
		labelBox.setPadding(new Insets(5));
		labelBox.setMinWidth(welcomeLabel.getMinWidth());
		labelBox.setAlignment(Pos.TOP_CENTER);
		labelBox.getChildren().add(welcomeLabel);
		mainPane.setTop(labelBox);

		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setOrientation(Orientation.HORIZONTAL);
		pane.setMinWidth(200);
		pane.setMaxWidth(400);
		pane.setPrefWrapLength(400);
		pane.setAlignment(Pos.CENTER);

		studentButton = new Button("Student Page");
		studentButton.setAlignment(Pos.CENTER);
		studentButton.setTextFill(Color.WHITESMOKE);
		studentButton.setStyle("-fx-background-color: Black");
		studentButton.setFont(Font.font("Times", FontWeight.BOLD, 14));

		facultyButton = new Button("Faculty page");
		facultyButton.setAlignment(Pos.CENTER);
		facultyButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		facultyButton.setTextFill(Color.WHITESMOKE);
		facultyButton.setStyle("-fx-background-color: Black");
		
		courseButton = new Button("Course Page");
		courseButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		courseButton.setAlignment(Pos.CENTER);
		courseButton.setTextFill(Color.WHITESMOKE);
		courseButton.setStyle("-fx-background-color: Black");
		
		importExportbutton = new Button("import/export");
		importExportbutton.setAlignment(Pos.CENTER);
		importExportbutton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		importExportbutton.setTextFill(Color.WHITESMOKE);
		importExportbutton.setStyle("-fx-background-color: Black");
		
		textbookButton = new Button("Textbook Page");
		textbookButton.setAlignment(Pos.CENTER);
		textbookButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		textbookButton.setTextFill(Color.WHITESMOKE);
		textbookButton.setStyle("-fx-background-color: Black");
		
		HBox bottomBox = new HBox();
		bottomBox.setPadding(new Insets(10));
		bottomBox.setAlignment(Pos.CENTER);
		bottomBox.setSpacing(6);
		
		collegeLabel = new Label("see college's:");
		collegeLabel.setFont(Font.font("Times", FontWeight.EXTRA_BOLD, 16));
		collegeLabel.setTextFill(Color.BLACK);
		collegeLabel.setStyle("-fx-background-color: White");
		
		allPeople = new Button("People");
		allPeople.setAlignment(Pos.CENTER);
		allPeople.setFont(Font.font("Times", FontWeight.BOLD, 14));
		allPeople.setTextFill(Color.WHITESMOKE);
		allPeople.setStyle("-fx-background-color: Black");
		
		allCourses = new Button("Courses");
		allCourses.setAlignment(Pos.CENTER);
		allCourses.setFont(Font.font("Times", FontWeight.BOLD, 14));
		allCourses.setTextFill(Color.WHITESMOKE);
		allCourses.setStyle("-fx-background-color: Black");
		
		bottomBox.getChildren().addAll(collegeLabel,allPeople,allCourses);
		mainPane.setBottom(bottomBox);
		
		
		pane.getChildren().addAll(studentButton, facultyButton, courseButton,textbookButton,importExportbutton);

		mainPane.setCenter(pane);
		mainPane.setStyle("-fx-background:#D3D3D3;");
		mainPane.setStyle("-fx-background-image: url(/view/nature.jpg)");

		mainScene = new Scene(mainPane, 900, 500);
		
		
		Button ActionForGoBack = new Button();
		ActionForGoBack.setOnAction(e-> mainScreenStage.setScene(mainScene));

		studentButton.setOnAction(e -> {

			StudentPage students = new StudentPage(ActionForGoBack.getOnAction());
			students.setBag(bag);
			students.setCoursesTotal(courseBag);
			mainScreenStage.setScene(students.getPrimaryScene());
			
		});

		facultyButton.setOnAction(e -> {
			FacultyPage faculties = new FacultyPage(ActionForGoBack.getOnAction());
			faculties.setBag(bag);
			mainScreenStage.setScene(faculties.getFacultyPageScene());

	
		});
		
		courseButton.setOnAction(e ->{
			CoursePage courses = new CoursePage(ActionForGoBack.getOnAction());
			courses.setCourseBag(courseBag);
			courses.setBookBag(bookBag);
			mainScreenStage.setScene(courses.getCoursePageScene());
			
		});
		textbookButton.setOnAction(e ->{
			TextbookPage books = new TextbookPage(ActionForGoBack.getOnAction());
			books.setBookBag(bookBag);
			mainScreenStage.setScene(books.getTextbookPageScene());
		});
		
		importExportbutton.setOnAction(e ->{
			ImportExportPage ImportPage = new ImportExportPage(ActionForGoBack.getOnAction());
			ImportPage.setCourseBag(courseBag);
			ImportPage.setPeopleBag(bag);
			ImportPage.setBookBag(bookBag);
			mainScreenStage.setScene(ImportPage.getImportExportScene());
		});
		
		allPeople.setOnAction(e ->{
			PeopleInCollege everyone = new PeopleInCollege(bag);
			mainPane.setRight(everyone.getPane());
		});
		allCourses.setOnAction(e ->{
			AllOfferedCourses everyCourse = new AllOfferedCourses(courseBag);
			mainPane.setRight(everyCourse.getPane());
		});

		

		mainScreenStage = new Stage();
		mainScreenStage.setTitle("Hernan's Project!");
		mainScreenStage.setScene(mainScene);
	
		mainScreenStage.setOnCloseRequest(e -> {
			save();
		});
		

	}

	private void save() {
		bag.save();
		courseBag.save();
		bookBag.save();
	}
	private void load() {
		// TODO Auto-generated method stub
		bag.load();
		courseBag.load();
		bookBag.load();
	}

	public Pane getPane() {
		return mainPane;
	}

	public void setPane(BorderPane pane) {
		this.mainPane = pane;
	}

	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}

	public Stage getMainScreenStage() {
		return mainScreenStage;
	}

	public void setMainScreenStage(Stage mainScreenStage) {
		this.mainScreenStage = mainScreenStage;
	}


}
