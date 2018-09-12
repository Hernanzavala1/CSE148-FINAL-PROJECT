package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Textbook;
import model.TextbookBag;

public class InsertTextbook {

	private BorderPane insertBookPane;
	
	private TextField titleField;
	private TextField authorField;
	private TextField publisherField;
	private TextField priceField;
	private TextField isbnField;
	
	private Button saveButton;
	private Button resetButton;
	
	
	private TextbookBag bookBag;
	
	public InsertTextbook(TextbookBag bookBag) {
		this.bookBag = bookBag;
		
		insertBookPane = new BorderPane();
		
		titleField = new TextField();
		titleField.setPromptText("Title");
		titleField.setMinWidth(200);
		
		authorField = new TextField();
		authorField.setPromptText("Author");
		authorField.setMinWidth(200);
		
		publisherField = new TextField();
		publisherField.setPromptText("Publisher");
		publisherField.setMinWidth(200);
		
		priceField = new TextField();
		priceField.setPromptText("Price");
		priceField.setMinWidth(200);
		
		isbnField = new TextField();
		isbnField.setPromptText("ISBN");
		isbnField.setMinWidth(200);
		
		FlowPane fieldPane = new FlowPane();
		fieldPane.setPadding(new Insets(10));
		fieldPane.setOrientation(Orientation.HORIZONTAL);
		fieldPane.setPrefWrapLength(300);
		fieldPane.setMinWidth(200);
		fieldPane.setMaxWidth(450);
		fieldPane.setVgap(10);
		fieldPane.setHgap(8);
		fieldPane.setAlignment(Pos.CENTER);
		
		fieldPane.getChildren().addAll(titleField,authorField,publisherField,priceField,isbnField);
		insertBookPane.setCenter(fieldPane);
		
		resetButton = new Button("reset");
		resetButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		saveButton = new Button("save");
		saveButton.setFont(Font.font("Times", FontWeight.BOLD, 14));
		saveButtonAction();
		
		resetButton.setOnAction(e -> {
			clearFields();
		});
		
		
		HBox buttonBox = new HBox();
		buttonBox.setPadding(new Insets(10));
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		buttonBox.setSpacing(10);
		buttonBox.setMinWidth(280);
		buttonBox.getChildren().addAll(resetButton,saveButton);
		
		insertBookPane.setBottom(buttonBox);
		
	}
	

	private void saveButtonAction() {
		// TODO Auto-generated method stub
		saveButton.setOnAction(e ->{
			String title = titleField.getText();
			String author = authorField.getText();
			String publisher = publisherField.getText();
			double price = Double.parseDouble(priceField.getText());
			String isbn = isbnField.getText();
			Textbook book = new Textbook(title,author,publisher,price,isbn);
			bookBag.addBook(book);
			clearFields();
		});
	}

	public void clearFields() {
		titleField.clear();
		authorField.clear();
		publisherField.clear();
		priceField.clear();
		isbnField.clear();
		bookBag.display();
	}
	public BorderPane getInsertBookPane() {
		return insertBookPane;
	}

	public void setInsertBookPane(BorderPane insertBookPane) {
		this.insertBookPane = insertBookPane;
	}

	public TextField getTitleField() {
		return titleField;
	}

	public void setTitleField(TextField titleField) {
		this.titleField = titleField;
	}

	public TextField getAuthorField() {
		return authorField;
	}

	public void setAuthorField(TextField authorField) {
		this.authorField = authorField;
	}

	public TextField getPublisherField() {
		return publisherField;
	}

	public void setPublisherField(TextField publisherField) {
		this.publisherField = publisherField;
	}

	public TextField getPriceField() {
		return priceField;
	}

	public void setPriceField(TextField priceField) {
		this.priceField = priceField;
	}

	public TextField getIsbnField() {
		return isbnField;
	}

	public void setIsbnField(TextField isbnField) {
		this.isbnField = isbnField;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
	}

	public Button getResetButton() {
		return resetButton;
	}

	public void setResetButton(Button resetButton) {
		this.resetButton = resetButton;
	}

	public TextbookBag getBookBag() {
		return bookBag;
	}

	public void setBookBag(TextbookBag bookBag) {
		this.bookBag = bookBag;
	}
	
}
