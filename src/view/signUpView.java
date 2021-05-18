package view;

import controller.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

public class signUpView {

	public Scene showView(Stage primaryStage) {
		
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		
		Label firstNameLabel= new Label("First Name");
		TextField firstNameField = new TextField();
		root.add(firstNameLabel, 1, 1);
		root.add(firstNameField, 2, 1);
		
		Label lastNameLabel= new Label("Last Name");
		TextField lastNameField = new TextField();
		root.add(lastNameLabel, 1, 2);
		root.add(lastNameField, 2, 2);
		
		Label emailLabel= new Label("Email:");
		TextField emailField = new TextField();
		root.add(emailLabel, 1, 3);
		root.add(emailField, 2, 3);
		
		Label passwordLabel = new Label("Password:");
		PasswordField passwordField= new PasswordField();
		root.add(passwordLabel, 1, 4);
		root.add(passwordField, 2, 4);
		
		Label verifyLabel = new Label("Verify Password:");
		PasswordField verifyField= new PasswordField();
		root.add(verifyLabel, 1, 5);
		root.add(verifyField, 2, 5);
		
		
		Label positionLabel = new Label("Position");
		root.add(positionLabel, 1, 6);
		RadioButton cashier= new RadioButton("Cashier");
		RadioButton manager= new RadioButton("Manager");
		HBox hb = new HBox();
		hb.getChildren().addAll(cashier, manager);
		root.add(hb, 2, 6);
		
		Label gender = new Label("Gender");
		root.add(gender, 1, 7);
		RadioButton male= new RadioButton("Male");
		RadioButton female= new RadioButton("Female");
		RadioButton other = new RadioButton("Other");
		HBox h = new HBox();
		h.getChildren().addAll(male, female);
		VBox v= new VBox();
		v.getChildren().addAll(h, other);
		root.add(v, 2, 7);
		
		Button addButton = new Button("Add employee");
		addButton.setStyle("-fx-background-color:pink;");
		root.add(addButton, 2, 9);
		
		addButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				String name= firstNameField.getText();
				String surname= lastNameField.getText();
				String email= emailField.getText();
				String password= passwordField.getText();
				String verifyPassword= verifyField.getText();
				String gender="";
				if(male.isSelected()){
					gender=male.getText();
				}else{
					if(female.isSelected()){
						gender=female.getText();
					}else{
						gender=other.getText();
					}
				}
				String access="";
				if(cashier.isSelected()) {
					access=cashier.getText();
				}
				else if(manager.isSelected())
					access=manager.getText();
				
				UserController uc= new UserController();
			
				if(email.matches("^[a-z]*@epoka.edu.al$")) {

                boolean result = uc.signUp(name, surname, email, password, verifyPassword, access);
				
				if(result){
					
				Alert successAlert= new Alert(AlertType.CONFIRMATION);
				successAlert.setHeaderText("The employee was registered successfully!");
				successAlert.showAndWait();
				successAlert.close();
				
				administratorView av = new administratorView();
				Scene sc = av.showView(primaryStage);
				primaryStage.setScene(sc);
				}
				}
				else {
					Alert error = new Alert(AlertType.ERROR);
					error.setContentText("Not registered successfully. Please enter only Epoka emails!!");
					error.show();
				
				}}
			
		});
		Button cancelButton = new Button("Cancel");
		cancelButton.setStyle("-fx-background-color:pink");
		root.add(cancelButton, 3, 9);
		
		cancelButton.setOnAction(e->{
			administratorView av = new administratorView();
			Scene sc1 = av.showView(primaryStage);
			primaryStage.setScene(sc1);
		});
		
		root.setStyle("-fx-background-image:url('imageResources/imageA.jpg')");
		Scene scene = new Scene(root, 350, 350);
		primaryStage.setTitle("Sign up");
		primaryStage.setScene(scene);
		return scene;
		
	}

	
	
}
