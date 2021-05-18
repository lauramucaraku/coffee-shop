package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;

public class administratorView {

	private User currentUser;
	
	
	public Scene showView(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		
		MenuItem viewEmployees= new MenuItem("View employees");
		MenuItem addEmployees = new MenuItem("Add new employee");
		MenuItem totalIncome = new MenuItem("Total income");
		MenuItem totalCost = new MenuItem("Total cost");
		
		fileMenu.getItems().addAll(viewEmployees, addEmployees, totalIncome, totalCost);
		
		totalIncome.setOnAction(e->{
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setHeaderText("Total incomes for the day");
			alert1.setContentText("Total incomes that the company has earned up to this moment from the beggining of the day are: $530");
			alert1.show();
		});
		
		totalCost.setOnAction(e->{
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText("Total costs for the day");
			alert2.setContentText("Total costs that have arisen today because of the operations of the store are: $145.50");
			alert2.show();
		});
		
		addEmployees.setOnAction(e->{
			signUpView sv = new signUpView();
			Scene sc = sv.showView(primaryStage);
			primaryStage.setScene(sc);
		});
		
		viewEmployees.setOnAction(e->{
			AllEmployeesView aev = new AllEmployeesView(currentUser);
			Scene sc = aev.showScene(primaryStage);
			primaryStage.setScene(sc);
		});
		
		
		Label logout = new Label("Log out");
		Menu exitMenu= new Menu("", logout);
		logout.setOnMouseClicked(e->{
			LogIn lv= new LogIn();
			primaryStage.setScene(lv.showView(primaryStage));
		});
		
		Label helpLabel = new Label("Help");
		Menu helpMenu = new Menu("", helpLabel);
		helpLabel.setOnMouseClicked(e->{
			Alert helpAlert = new Alert(AlertType.INFORMATION);
			helpAlert.setTitle("Administrator functionalities");
			helpAlert.setContentText("These are all the administrator's functionalities.");
			helpAlert.show();
		});
		
		menuBar.getMenus().addAll(fileMenu, helpMenu, exitMenu);
		pane.getChildren().add(menuBar);
		
		VBox root= new VBox();
		root.setAlignment(Pos.CENTER);
		
		Button viewEmployee = new Button("View Employees");
		viewEmployee.setStyle("-fx-background-color:brown;");
		viewEmployee.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		pane.add(viewEmployee, 2 , 1);
		
		viewEmployee.setOnAction(e->{
			AllEmployeesView aev = new AllEmployeesView(currentUser);
			Scene sc = aev.showScene(primaryStage);
			primaryStage.setScene(sc);
		});
		
		Button addEmployee= new Button("Add a new employee");
		addEmployee.setStyle("-fx-background-color:brown;");
		addEmployee.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		pane.add(addEmployee, 2, 2);
		
		addEmployee.setOnAction(e->{
			signUpView sv = new signUpView();
			Scene sc = sv.showView(primaryStage);
			primaryStage.setScene(sc);
		});
		
		Button incomeButton = new Button("View total income");
		incomeButton.setStyle("-fx-background-color:brown;");
		incomeButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		pane.add(incomeButton, 2, 3);
		
		incomeButton.setOnAction(e->{
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setHeaderText("Total incomes for the day");
			alert1.setContentText("Total incomes that the company has earned up to this moment from the beggining of the day are: $530");
			alert1.show();
		});
		
		Button costButton = new Button ("View total cost");
		costButton.setStyle("-fx-background-color:brown;");
		costButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		pane.add(costButton, 2 , 4);
		
		costButton.setOnAction(e->{
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText("Total costs for the day");
			alert2.setContentText("Total costs that have arisen today because of the operations of the store are: $145.50");
			alert2.show();
		});
	
		primaryStage.setTitle("Administrator view");
		pane.setStyle("-fx-background-image:url('imageResources/imageA.jpg')");
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);
		return scene;
		
	}
	
}
