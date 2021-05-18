package view;

import controller.CashierController;
import controller.ManagerController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class managerView {
	
	public Scene showView(Stage primaryStage) {
		
		GridPane root = new GridPane();
		root.setVgap(15);
		
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		
		MenuItem viewStatistics= new MenuItem("View statistics");
		MenuItem buyItem = new MenuItem("Buy a new Item");
		MenuItem checkPerformance = new MenuItem("Check performance of the cashier");
		
		checkPerformance.setOnAction(e->{
			ManagerController mc = new ManagerController();
			String result = mc.checkCashierPerformance(new CashierController());
			System.out.println(result);
			if(result=="OK") {
				Alert okAlert = new Alert(AlertType.INFORMATION);
				okAlert.setHeaderText("Good performance");
				okAlert.setContentText("The performace of the cashier is satisfying. He has ordered more than 5 bills today. You can always check his bills in the bills folder inside the project folder.");
				okAlert.show();
			}
			else if(result=="FAIL") {
				Alert warningAlert = new Alert(AlertType.WARNING);
				warningAlert.setHeaderText("Bad performance");
				warningAlert.setContentText("The performace of the cashier is not satisfying. He has ordered less than 5 bills today. You can always check his bills in the bills folder inside the project folder.");
				warningAlert.show();
			}
		});
		
		Button statisticsButton = new Button("View statistics");
		statisticsButton.setStyle("-fx-background-color:brown;");
		statisticsButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		root.add(statisticsButton,3,7);
		
		Button newItemButton = new Button("Buy a new item");
		newItemButton.setStyle("-fx-background-color:brown;");
		newItemButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		root.add(newItemButton,3,8);
		
		Button performanceButton = new Button("Check performance of the cashier");
		performanceButton.setStyle("-fx-background-color:brown;");
		performanceButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 12));
		root.add(performanceButton,3,9);
		
		performanceButton.setOnAction(e->{
			ManagerController mc = new ManagerController();
			String result = mc.checkCashierPerformance(new CashierController());
			System.out.println(result);
			if(result=="OK") {
				Alert okAlert = new Alert(AlertType.INFORMATION);
				okAlert.setHeaderText("Good performance");
				okAlert.setContentText("The performace of the cashier is satisfying. He has ordered more than 5 bills today. You can always check his bills in the bills folder inside the project folder.");
				okAlert.show();
			}
			else if(result=="FAIL") {
				Alert warningAlert = new Alert(AlertType.WARNING);
				warningAlert.setHeaderText("Bad performance");
				warningAlert.setContentText("The performace of the cashier is not satisfying. He has ordered less than 5 bills today. You can always check his bills in the bills folder inside the project folder.");
				warningAlert.show();
			}
		});
		
		fileMenu.getItems().addAll(viewStatistics, buyItem, checkPerformance);
		
		Label helpLabel = new Label("Help");
		Menu helpMenu = new Menu("", helpLabel);
		helpLabel.setOnMouseClicked(e->{
			Alert helpAlert = new Alert(AlertType.INFORMATION);
			helpAlert.setTitle("Manager functionalities");
			helpAlert.setContentText("Here you can access all the manager's functionalities.");
			helpAlert.show();
		});
		
		Label logout = new Label("Log out");
		Menu exitMenu= new Menu("", logout);
		
		logout.setOnMouseClicked(e->{
			LogIn lv= new LogIn();
			primaryStage.setScene(lv.showView(primaryStage));
		});
		menuBar.getMenus().addAll(fileMenu, helpMenu, exitMenu);
		
		root.getChildren().add(menuBar);
		root.setStyle("-fx-background-image:url('imageResources/imageA.jpg')");
		
		primaryStage.setTitle("Manager view");
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		
		Alert alert1 = new Alert(AlertType.INFORMATION);
		alert1.setHeaderText("Dell computers missing");
		alert1.setContentText("There are no more DELL computers in the store!!");
		alert1.showAndWait();
		
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setHeaderText("Warning about Samsung TV's");
		alert2.setContentText("There is only one Samsung TV left in the store. Consider buying more!!");
		alert2.showAndWait();
		
	
		
		
		return scene;
		
		
		
		
	}

}
