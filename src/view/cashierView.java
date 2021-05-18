package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.User;

public class cashierView {

	public Scene showScene(Stage primaryStage) {
		
		MenuBar menuBar = new MenuBar();
		
		GridPane pane = new GridPane();
		pane.setVgap(20);
		pane.getChildren().add(menuBar);
		Menu checkMenu = new Menu("File");
		
		MenuItem billItem = new MenuItem("Create bill");
		
		checkMenu.getItems().add(billItem);
		
		billItem.setOnAction(e->{
			User u = new User("Laura", "Mucaraku","lmucaraku@epoka.edu.al", "manager");
			AddBillView abv = new AddBillView(u);
			Scene sc1 = abv.showView(primaryStage);
			primaryStage.setScene(sc1);
		});
		
		Label logout = new Label("Log out");
		Menu exitMenu= new Menu("", logout);
		
		logout.setOnMouseClicked(e->{
			LogIn lv= new LogIn();
			primaryStage.setScene(lv.showView(primaryStage));
		});
		
		Button addItem = new Button("Create bill");
		addItem.setOnAction(e->{
				User u = new User("Laura", "Mucaraku","lmucaraku@epoka.edu.al", "manager");
				AddBillView abv = new AddBillView(u);
				Scene sc1 = abv.showView(primaryStage);
				primaryStage.setScene(sc1);
			});
		pane.add(addItem,3,7);
		
		Label helpLabel = new Label("Help");
		Menu helpMenu = new Menu("", helpLabel);
		helpLabel.setOnMouseClicked(e->{
			Alert helpAlert = new Alert(AlertType.INFORMATION);
			helpAlert.setTitle("Cashier functionalities");
			helpAlert.setContentText("By clicking the *Add bill* button, you can add a new bill ordered by the customer.");
			helpAlert.show();
		});
		
		menuBar.getMenus().addAll(checkMenu, helpMenu, exitMenu);
		
		
		pane.setStyle("-fx-background-image:url('imageResources/imageA.jpg')");
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Cashier");
		
		return scene;

	}
	
}
