package view;

import java.io.PrintWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MainScreenPane root = new MainScreenPane();
		
		
		primaryStage.centerOnScreen();
		primaryStage= root.getMainScreenStage();
		primaryStage.show();
		
//		PrintWriter studentFile = new PrintWriter("studentToImport.txt");
//		studentFile.println("reina:Yanes:6319182293:Math");
//		studentFile.close();
		
	}

}
