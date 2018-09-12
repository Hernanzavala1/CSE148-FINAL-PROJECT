 package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Textbook;
import model.TextbookBag;

public class TextbookPage {
private Scene textbookPageScene;
private BorderPane mainPane;

private Button insertBook;
private Button findBook;
private Button removeBook;
private Button updateBook;
private Button goBackButton;



private TextbookBag bookBag;

public TextbookPage(EventHandler<ActionEvent> onAction) {
	mainPane = new BorderPane();
//	mainPane.setStyle("-fx-background:#E6E6FA;");
	mainPane.setStyle("-fx-Background-image: url(/view/sea2.jpg)");
	
	Label pageLabel = new Label();
	pageLabel.setText("Welcome to textbook page");
	pageLabel.setMinWidth(250);
	pageLabel.setAlignment(Pos.TOP_CENTER);
	pageLabel.setFont(Font.font("Times", FontWeight.BOLD, 20));
	HBox topPane = new HBox();
	topPane.setPadding(new Insets(10));
	topPane.setAlignment(Pos.TOP_CENTER);
	topPane.setMinWidth(pageLabel.getMinWidth());
	topPane.getChildren().add(pageLabel);
	mainPane.setTop(topPane);
	
	
	insertBook = new Button("insert Book");
	insertBook.setFont(Font.font("Times", FontWeight.BOLD, 14));
	insertBook.minWidth(100);
	findBook = new Button("search Book");
	findBook.setFont(Font.font("Times", FontWeight.BOLD, 14));
	findBook.minWidth(100);
	removeBook = new Button("remove Book");
	removeBook.setFont(Font.font("Times", FontWeight.BOLD, 14));
	removeBook.minWidth(100);
	updateBook = new Button("update Book");
	updateBook.setFont(Font.font("Times", FontWeight.BOLD, 14));
	updateBook.maxWidth(100);
	goBackButton = new Button("Go Back");
	goBackButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
	goBackButton.setOnAction(onAction);
	

	
	
	VBox buttonBox = new VBox();

	buttonBox.setPadding(new Insets(12));
	buttonBox.setMaxWidth(300);
	buttonBox.setSpacing(10);
	buttonBox.setAlignment(Pos.CENTER);
	buttonBox.getChildren().addAll(insertBook, findBook, removeBook, updateBook,goBackButton);
	

	mainPane.setLeft(buttonBox);
	textbookPageScene = new Scene(mainPane, 600, 400);
	
	insertBook.setOnAction(e ->{
		InsertTextbook insert = new InsertTextbook(bookBag);
		mainPane.setCenter(insert.getInsertBookPane());
	});

	setFindAction();
	setRemoveAction();
	setUpdateAction();
	
	
}


private void setUpdateAction() {
	// TODO Auto-generated method stub
	updateBook.setOnAction(e ->{
		String isbn = Util.getUserInput("Please enter the book ISBN!");
		try {
			Textbook bookFound = bookBag.findTextbook(isbn);
			System.out.println(bookFound.toString());
			UpdateBook display = new UpdateBook(bookBag,bookFound);
			mainPane.setCenter(display.getDisplayPane());
			
		}catch(NullPointerException er) {
//			Util.BookNotFound();
			er.printStackTrace();
		}
	});
	
}


private void setRemoveAction() {
	 removeBook.setOnAction(e ->{
		 String isbn = Util.getUserInput("Please enter the book ISBN!");
		 try {
			 Textbook book = bookBag.deleteByISBN(isbn);
			 mainPane.setCenter(displayBook(book));
			 }catch(NullPointerException ttt) {
				 Util.BookNotFound();
			 }
				 
	 });
	
}


private void setFindAction() {
	// TODO Auto-generated method stub
	findBook.setOnAction(e ->{
		String isbn = Util.getUserInput("Please enter the book ISBN!");
		try {
			Textbook book = bookBag.findTextbook(isbn);
			mainPane.setCenter(displayBook(book));
			
		}
		catch(NullPointerException tt) {
			Util.BookNotFound();
		}
	});
}

public BorderPane displayBook(Textbook book) {
	
	InsertTextbook insertPane = new InsertTextbook(bookBag);
	BorderPane displayPane = insertPane.getInsertBookPane();
	insertPane.getTitleField().setText(book.getBookTitle());
	insertPane.getAuthorField().setText(book.getAuthor());
	insertPane.getPublisherField().setText(book.getPublisher());
	insertPane.getPriceField().setText(String.valueOf(book.getPrice()));
	insertPane.getIsbnField().setText(book.getISBN());

	
	return displayPane;
}



public Scene getTextbookPageScene() {
	return textbookPageScene;
}

public void setTextbookPageScene(Scene textbookPageScene) {
	this.textbookPageScene = textbookPageScene;
}

public BorderPane getMainPane() {
	return mainPane;
}

public void setMainPane(BorderPane mainPane) {
	this.mainPane = mainPane;
}

public Button getInsertBook() {
	return insertBook;
}

public void setInsertBook(Button insertBook) {
	this.insertBook = insertBook;
}

public Button getFindBook() {
	return findBook;
}

public void setFindBook(Button findBook) {
	this.findBook = findBook;
}

public Button getRemoveBook() {
	return removeBook;
}

public void setRemoveBook(Button removeBook) {
	this.removeBook = removeBook;
}

public Button getUpdateBook() {
	return updateBook;
}

public void setUpdateBook(Button updateBook) {
	this.updateBook = updateBook;
}

public Button getGoBackButton() {
	return goBackButton;
}

public void setGoBackButton(Button goBackButton) {
	this.goBackButton = goBackButton;
}
public TextbookBag getBookBag() {
	return bookBag;
}

public void setBookBag(TextbookBag bookBag) {
	this.bookBag = bookBag;
}
}
