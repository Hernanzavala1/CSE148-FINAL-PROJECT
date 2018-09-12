package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Course;
import model.MasterCourseBag;


public class AllOfferedCourses {
private ListView<Course> allCourses;
private BorderPane pane;

public AllOfferedCourses(MasterCourseBag courseBag) {
	pane = new BorderPane();
	pane.setPadding(new Insets(11));
	
	Label label = new Label("All of the Courses offered by the college: ");
	label.setFont(Font.font("Times", FontWeight.BOLD, 16));
	label.setAlignment(Pos.TOP_RIGHT);
	label.setStyle("-fx-background-color:white");
	pane.setTop(label);
	
	allCourses = new ListView<>();
	allCourses.setMinWidth(412);
	
	Course[] courses = courseBag.getCourses();
	for(int i =0; i< courses.length; i++) {
		allCourses.getItems().add(courses[i]);
		
	}
	
	pane.setCenter(allCourses);

	
}

public BorderPane getPane() {
	return pane;
}

public void setPane(BorderPane pane) {
	this.pane = pane;
}


}
