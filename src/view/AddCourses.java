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
import model.CourseBag;
import model.Student;

public class AddCourses {
	private BorderPane addCoursePane;

	private Button takenButton;
	private Button takingButton;
	private Button neededButton;
	private Button removeTakenCourse;
	private Button removeTakingCourse;
	private Button removeNeededCourse;
	
	private TextField courseTitle;
	private TextField courseNumber;
	private TextField courseGrade;
	
	private Label StatusLabel;
	private CourseBag courseBag;
	private Student student;
	
	public AddCourses(Student student) {
		this.student = student;

		courseBag = student.getCourses();
		
		
		addCoursePane = new BorderPane();
		addCoursePane.setStyle("-fx-background:#E6E6FA;");
		
		StatusLabel = new Label();
		StatusLabel.setAlignment(Pos.CENTER);
		StatusLabel.setFont(Font.font("Times", FontWeight.BOLD, 16));
		HBox UpBox = new HBox();
		UpBox.setPadding(new Insets(10));
		UpBox.setAlignment(Pos.TOP_LEFT);
		
		UpBox.getChildren().add(StatusLabel);
		addCoursePane.setTop(UpBox);
		
				
		FlowPane fieldPane =  new FlowPane();
		fieldPane.setPadding(new Insets(10));
		fieldPane.setOrientation(Orientation.HORIZONTAL);
		fieldPane.setAlignment(Pos.CENTER);
		fieldPane.setPrefWrapLength(300);
		fieldPane.setMinWidth(200);
		fieldPane.setVgap(10);
		fieldPane.setHgap(6);
		
		courseTitle = new TextField();
		courseTitle.setPromptText("Course Title");
		courseNumber = new TextField();
		courseNumber.setPromptText("Course Number");
		courseGrade = new TextField();
		courseGrade.setPromptText("Grade");
		
		fieldPane.getChildren().addAll(courseTitle,courseNumber,courseGrade);
		addCoursePane.setCenter(fieldPane);
		Label Addto = new Label("Add to:");
		Addto.setFont(Font.font("Times", FontWeight.BOLD, 15));
		
		Label RemoveFrom = new Label("Remove from:");
		RemoveFrom.setFont(Font.font("Times", FontWeight.BOLD, 15));
		
		takenButton = new Button("Taken Courses");
		takenButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		takingButton = new Button("Courses Taking");
		takingButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		neededButton = new Button("Courses Needed");
		neededButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		removeTakenCourse = new Button("Taken Course");
		removeTakingCourse = new Button("Taking Course");
		removeNeededCourse = new Button("Needed Course");
		
		HBox bottomBox = new HBox();
		bottomBox.setPadding(new Insets(10));
		bottomBox.setAlignment(Pos.CENTER);
		bottomBox.setSpacing(5);
		bottomBox.getChildren().addAll(RemoveFrom,removeTakenCourse,removeTakingCourse,removeNeededCourse);
		addCoursePane.setBottom(bottomBox);
		
				
		
		FlowPane buttonPane = new FlowPane();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setOrientation(Orientation.VERTICAL);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPrefWrapLength(350);
		buttonPane.setMinHeight(300);
		buttonPane.setVgap(10);
		
		buttonPane.getChildren().addAll(Addto,takenButton,takingButton,neededButton);
	
		takenButtonAction();
		takingButtonAction();
		neededButtonAction();
		removeTakenAction();
		removeTakingAction();
		removeNeededAction();
		
		addCoursePane.setRight(buttonPane);
		
		student.getCourses().save();
		
	}
	




	private void removeNeededAction() {
		// TODO Auto-generated method stub
		removeNeededCourse.setOnAction(e -> {
			courseBag.removeNeededCourse(courseNumber.getText());
			StatusLabel.setText("Done");
			courseTitle.clear();
			courseNumber.clear();
			courseGrade.clear();
			courseBag.display();
		});
	}





	private void removeTakingAction() {
		// TODO Auto-generated method stub
		removeTakingCourse.setOnAction(e ->{
			Util.rememberGrade();
			if(Util.inputCheck( courseGrade,"course grade cant be empty!")) {
				courseBag.removeTakingCourse(courseNumber.getText());
				courseBag.setGrade(courseNumber.getText(), courseGrade.getText());
				StatusLabel.setText("Done");
			}
			else {
				Util.ExecutionFailed();
				StatusLabel.setText("Failed");
			}
			
			courseTitle.clear();
			courseNumber.clear();
			courseGrade.clear();
			courseBag.display();
			
		});
	}





	private void removeTakenAction() {
		// TODO Auto-generated method stub
		removeTakenCourse.setOnAction(e ->{
			courseBag.removeTakenCourse(courseNumber.getText());
			courseTitle.clear();
			courseNumber.clear();
			courseGrade.clear();
			courseBag.display();
		});
	}





	private void neededButtonAction() {
		// TODO Auto-generated method stub
		neededButton.setOnAction(e ->{
			courseBag.addCoursesNeeded(courseNumber.getText());
			courseTitle.clear();
			courseNumber.clear();
			courseGrade.clear();
			courseBag.display();
	
	});
	}






	private void takingButtonAction() {
		// TODO Auto-generated method stub
		takingButton.setOnAction(e ->{
			courseBag.addCoursesTaking(courseNumber.getText());
			courseTitle.clear();
			courseNumber.clear();
			courseGrade.clear();
			courseBag.display();
		});
	}





	private void takenButtonAction() {
		takenButton.setOnAction(e ->{
			Util.rememberGrade();
			if(Util.inputCheck(courseGrade, "Course grade cant be EMPTY!")) {
				courseBag.addCoursesTaken(courseNumber.getText()); 
				courseBag.setGrade(courseNumber.getText(), courseGrade.getText());
				StatusLabel.setText("Done");
			}
			else {
				Util.ExecutionFailed();
				StatusLabel.setText("Failed");
			}
			courseTitle.clear();
			courseNumber.clear();
			courseGrade.clear();
			courseBag.display();
		});
		
	}



	


	public BorderPane getAddCoursePane() {
		return addCoursePane;
	}


	public void setAddCoursePane(BorderPane addCoursePane) {
		this.addCoursePane = addCoursePane;
	}
	
	
	
	

}
