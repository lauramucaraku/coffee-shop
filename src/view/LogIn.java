package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrator;
import model.Cashier;
import model.Manager;

public class LogIn {
 
	public Scene showView(Stage primaryStage) {
		
		Label usernameLabel = new Label("Username");
		usernameLabel.setTextFill(Color.WHITE);
		TextField usernameField = new TextField();
		
		Label passwordLabel = new Label("Password");
		passwordLabel.setTextFill(Color.WHITE);
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(20);
		gp.setPadding(new Insets(10,10,10,10));
		gp.addRow(0, usernameLabel, usernameField);
		gp.addRow(1, passwordLabel, passwordField);
		gp.setAlignment(Pos.CENTER);
		
		Button logInButton = new Button("Log In");
		logInButton.setStyle("-fx-background-color:yellow;");
		logInButton.getStyleClass().add("login-but");
		
		Button exitButton = new Button ("Exit");
		exitButton.setStyle("-fx-background-color:yellow;");
		exitButton.getStyleClass().addAll("exitButton", "login-but");
		
		HBox hb = new HBox(logInButton, exitButton);
		hb.setPadding(new Insets(5, 5, 5, 5));
		hb.setMargin(logInButton, new Insets(0, 10, 0, 0));
		hb.setAlignment(Pos.CENTER);
		
		GridPane mainPane = new GridPane();
		Text titleText=new Text("This is Laura Mucaraku's project");
		
		titleText.setFont(Font.font("Algerian", FontWeight.NORMAL, 20));
		titleText.setFill(Color.YELLOW); 
		mainPane.addColumn(0, titleText, gp, hb);
		mainPane.setId("actiontarget");
		mainPane.setAlignment(Pos.CENTER);
		
		exitButton.setOnAction(e->{
			primaryStage.close();
		});
		
		logInButton.setOnAction(e->{
			if(usernameField.getText().equals("cashier") && passwordField.getText().equals("cashier"))
			{
				//Cashier cashier = new Cashier(1, "Laura", "Mucaraku", "lmucaraku19@epoka.edu.al");
			    cashierView cashierview = new cashierView();
				Scene scene1 = cashierview.showScene(primaryStage);
				primaryStage.setScene(scene1);
					
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully logged in as a cashier!");
				alert.showAndWait();
			   
			}
			else if(usernameField.getText().equals("manager") && passwordField.getText().equals("manager"))
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully logged in as a manager!");
				alert.show();
				
				managerView mv = new managerView();
				Scene sc = mv.showView(primaryStage);
			}
			else if(usernameField.getText().equals("administrator") && passwordField.getText().equals("administrator"))
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully logged in as a administrator!");
				alert.show();
				administratorView av = new administratorView();
				Scene sc = av.showView(primaryStage);
			}
			
			else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Error");
				errorAlert.setContentText("Please, enter the correct credencials!");
	            errorAlert.show();
			}
			
		});
		mainPane.setStyle("-fx-background-image:url('imageResources/image.jpg')");
		Scene scene = new Scene(mainPane, 400, 400);
		primaryStage.setTitle("Log In");
		return scene;
	}
	
}
