package view;

import java.io.File;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class viewProject extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		
		LogIn project = new LogIn();
		
		Scene scene = project.showView(primaryStage);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		PrintWriter output = new PrintWriter("note.txt");
		output.println("Hello, I am Laura and here you can find the usernames and passwords needed to log in in my project :) ."
				+ "\n\n                         Usernames         Passwords"
				+ "\n\nLog in as cashier:        cashier           cashier"
				+ "\nLog in as manager:        manager           manager"
				+ "\nLog in as admin:          administrator     administrator");
		output.close();

	}
	
	public static void main (String [] args) {
		launch(args);
	}

}
