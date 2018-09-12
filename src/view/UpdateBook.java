package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Textbook;
import model.TextbookBag;

public class UpdateBook {
private BorderPane displayPane;
private Button saveUpdates;
private Button reset;


	
	public UpdateBook(TextbookBag bookBag,Textbook book) {
		InsertTextbook displayBook = new InsertTextbook(bookBag);
		displayPane =displayBook.getInsertBookPane();
		
		reset = displayBook.getResetButton();
		reset.setOnAction(displayBook.getResetButton().getOnAction());
		
		saveUpdates = displayBook.getSaveButton();
		saveUpdates.setOnAction(e ->{
			String title = displayBook.getTitleField().getText();
			String author =displayBook.getAuthorField().getText();
			String publisher = displayBook.getPublisherField().getText();
			String price = displayBook.getPriceField().getText();
			String isbn = displayBook.getIsbnField().getText();
			
			if(!title.isEmpty()) {
				book.setBookTitle(title);
			}
		    if(!author.isEmpty()) {
		    	book.setAuthor(author);
		    }
		    if(!publisher.isEmpty()) {
		    	book.setPublisher(publisher);
		    }
		    if(!price.isEmpty()) {
		    	book.setPrice(Double.parseDouble(price));
		    }
		    if(!isbn.isEmpty()) {
		    	book.setISBN(isbn);
		    }
		  displayBook.clearFields();
		});
		
	}

	public BorderPane getDisplayPane() {
		return displayPane;
	}

	public void setDisplayPane(BorderPane displayPane) {
		this.displayPane = displayPane;
	}
	
}
