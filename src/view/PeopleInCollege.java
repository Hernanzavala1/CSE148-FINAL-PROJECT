package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.PeopleBag;
import model.Person;

public class PeopleInCollege {
private ListView<Person> AllPeople;
private BorderPane pane;

public PeopleInCollege(PeopleBag people1) {
	pane = new BorderPane();
	pane.setPadding(new Insets(10));
	
	Label label = new Label("All of the people in the college:");
	label.setFont(Font.font("Times", FontWeight.BOLD, 16));
	label.setAlignment(Pos.TOP_RIGHT);
	label.setTextFill(Color.BLUE);
	label.setStyle("-fx-background-color:white");
	pane.setTop(label);
	
	Person[] people = people1.getPeople();
	AllPeople = new ListView<>();
	AllPeople.setMinWidth(380);
	
	for(int i =0; i <people.length; i++) {
		AllPeople.getItems().add(people[i]);
	}
	
	pane.setCenter(AllPeople);
}

public BorderPane getPane() {
	return pane;
}

public void setPane(BorderPane pane) {
	this.pane = pane;
}




}
