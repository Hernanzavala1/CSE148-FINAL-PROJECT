package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import model.Student;

public class StudentCoursesView {
private GridPane pane;
private ComboBox<String> coursesTaken;
private ComboBox<String> coursesTaking;
private ComboBox<String> coursesNeeded;

public StudentCoursesView(Student student) {
	pane = new GridPane();
	pane.setPadding(new Insets(10));
	pane.setHgap(10);
	pane.setVgap(10);
	pane.setAlignment(Pos.CENTER);
	
	coursesTaken = new ComboBox<>();
	coursesTaken.setPromptText("Courses Took");
	coursesTaking = new ComboBox<>();
	coursesTaking.setPromptText("Courses Taking");
	coursesNeeded = new ComboBox<>();
	coursesNeeded.setPromptText("Courses Needed");
	
	String[] taken = student.getCourses().getCoursesTaken();
	String[] taking = student.getCourses().getCoursesTaking();
	String[] needed = student.getCourses().getCoursesNeeded();
	
	for(int i =0; i < taken.length; i++) {
		coursesTaken.getItems().add(taken[i]);
	}
	for(int i =0; i < taking.length; i++) {
		coursesTaking.getItems().add(taking[i]);
	}
	for(int i =0;  i < needed.length; i++) {
		coursesNeeded.getItems().add(needed[i]);
	}
	
	pane.setConstraints(coursesTaken, 1, 2);
	pane.setConstraints(coursesTaking, 1, 4);
	pane.setConstraints(coursesNeeded, 1, 6);
	pane.getChildren().addAll(coursesTaken, coursesTaking, coursesNeeded);
	
	
}

public GridPane getPane() {
	return pane;
}

public void setPane(GridPane pane) {
	this.pane = pane;
}

public ComboBox<String> getCoursesTaken() {
	return coursesTaken;
}

public void setCoursesTaken(ComboBox<String> coursesTaken) {
	this.coursesTaken = coursesTaken;
}

public ComboBox<String> getCoursesTaking() {
	return coursesTaking;
}

public void setCoursesTaking(ComboBox<String> coursesTaking) {
	this.coursesTaking = coursesTaking;
}

public ComboBox<String> getCoursesNeeded() {
	return coursesNeeded;
}

public void setCoursesNeeded(ComboBox<String> coursesNeeded) {
	this.coursesNeeded = coursesNeeded;
}

}
