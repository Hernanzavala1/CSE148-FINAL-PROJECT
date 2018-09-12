package view;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.MasterCourseBag;
import model.PeopleBag;
import model.Person;
import model.TextbookBag;

public class ImportExportPage {
	private BorderPane mainPane;
	private Scene importExportScene;

	private Button saveData;
	private Button loadData;
	private Button importStudent;
	private Button exportStudent;
	private Button importFaculty;
	private Button exportFaculty;
	private Button importCourse;
	private Button exportCourse;
	private Button goBackButton;

	private PeopleBag peopleBag;
	private MasterCourseBag courseBag;
	private TextbookBag bookBag;

	public TextbookBag getBookBag() {
		return bookBag;
	}





	public void setBookBag(TextbookBag bookBag) {
		this.bookBag = bookBag;
	}





	public ImportExportPage(EventHandler<ActionEvent> onAction) {
	
		mainPane = new BorderPane();
		mainPane.setPadding(new Insets(10));
		mainPane.setStyle("-fx-Background-image: url(/view/city.jpg)");

		Label pageLabel = new Label("welcome to import/export page");
		pageLabel.setFont(Font.font("Times", FontWeight.BOLD, 20));
		pageLabel.setAlignment(Pos.TOP_CENTER);
		pageLabel.setMinWidth(200);

		HBox labelBox = new HBox();
		labelBox.setPadding(new Insets(10));
		labelBox.setAlignment(Pos.TOP_CENTER);
		labelBox.setMinWidth(pageLabel.getMinWidth());
		labelBox.getChildren().add(pageLabel);

		mainPane.setTop(labelBox);

		saveData = new Button("Save Data");
		saveData.setStyle("fx-background: #ADFF2F;");
		saveData.setFont(Font.font("Times", FontWeight.BOLD, 14));
		loadData = new Button("load Data");
		loadData.setFont(Font.font("Times", FontWeight.BOLD, 14));
		importStudent = new Button("Import Student");
		importStudent.setFont(Font.font("Times", FontWeight.BOLD, 14));
		exportStudent = new Button("Export Student");
		exportStudent.setFont(Font.font("Times", FontWeight.BOLD, 14));
		importFaculty = new Button("Import Faculty");
		importFaculty.setFont(Font.font("Times", FontWeight.BOLD, 14));
		exportFaculty = new Button("Export Faculty");
		exportFaculty.setFont(Font.font("Times", FontWeight.BOLD, 14));
		importCourse = new Button("Import Course");
		importCourse.setFont(Font.font("Times", FontWeight.BOLD, 14));
		exportCourse = new Button("Export Course");
		exportCourse.setFont(Font.font("Times", FontWeight.BOLD, 14));
		goBackButton = new Button("Go Back");
		goBackButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		
		//SET ACTION FOR GO BACK BUTTON BELOW
		goBackButton.setOnAction(onAction);
		
		saveData.setOnAction(e ->{
			peopleBag.save();
			courseBag.save();
			bookBag.save();
			
		});
		loadData.setOnAction(e ->{
			peopleBag.load();
			courseBag.load();
			bookBag.load();
		});
		
		importStudentAction();
		exportStudentAction();
		importFacultyAction();
		exportFacultyAction();
		importCourseAction();
		exportCourseAction();
		
		

		
		VBox buttonBox = new VBox();
		buttonBox.setPadding(new Insets(10));
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(saveData, loadData, importStudent, exportStudent, importFaculty, exportFaculty,
				importCourse, exportCourse,goBackButton );
		mainPane.setLeft(buttonBox);
		
		

		importExportScene = new Scene(mainPane, 700, 800);
		

	}


	


	private void exportCourseAction() {
		exportCourse.setOnAction(e ->{
			courseBag.exportData(Util.getFileName());
			
		});
		
	}





	private void importCourseAction() {
		importCourse.setOnAction(e ->{
			courseBag.importData(Util.getFileName());
		
		});
		
	}





	private void exportFacultyAction() {
		exportFaculty.setOnAction(e ->{
			peopleBag.exportFaculty(Util.getFileName());
			
		});
		
	}





	private void importFacultyAction() {
		importFaculty.setOnAction(e ->{
			peopleBag.importFaculty(Util.getFileName());
			peopleBag.display();
		});
		
	}





	private void exportStudentAction() {
		exportStudent.setOnAction(e ->{
			peopleBag.exportStudent(Util.getFileName());
		});
		
	}





	private void importStudentAction() {
		importStudent.setOnAction(e ->{
			peopleBag.importStudents(Util.getFileName());
			peopleBag.display();
		});
	 

		
	}





	public Scene getImportExportScene() {
		return importExportScene;
	}


	public void setImportExportScene(Scene importExportScene) {
		this.importExportScene = importExportScene;
	}


	public BorderPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}

	public Button getSaveData() {
		return saveData;
	}

	public void setSaveData(Button saveData) {
		this.saveData = saveData;
	}

	public Button getLoadData() {
		return loadData;
	}

	public void setLoadData(Button loadData) {
		this.loadData = loadData;
	}

	public Button getImportStudent() {
		return importStudent;
	}

	public void setImportStudent(Button importStudent) {
		this.importStudent = importStudent;
	}

	public Button getExportStudent() {
		return exportStudent;
	}

	public void setExportStudent(Button exportStudent) {
		this.exportStudent = exportStudent;
	}

	public Button getImportFaculty() {
		return importFaculty;
	}

	public void setImportFaculty(Button importFaculty) {
		this.importFaculty = importFaculty;
	}

	public Button getExportFaculty() {
		return exportFaculty;
	}

	public void setExportFaculty(Button exportFaculty) {
		this.exportFaculty = exportFaculty;
	}

	public Button getImportCourse() {
		return importCourse;
	}

	public void setImportCourse(Button importCourse) {
		this.importCourse = importCourse;
	}

	public Button getExportCourse() {
		return exportCourse;
	}

	public void setExportCourse(Button exportCourse) {
		this.exportCourse = exportCourse;
	}

	public PeopleBag getPeopleBag() {
		return peopleBag;
	}

	public void setPeopleBag(PeopleBag peopleBag) {
		this.peopleBag = peopleBag;
	}

	public MasterCourseBag getCourseBag() {
		return courseBag;
	}

	public void setCourseBag(MasterCourseBag courseBag) {
		this.courseBag = courseBag;
	}

}
