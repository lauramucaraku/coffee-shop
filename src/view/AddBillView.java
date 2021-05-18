package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import controller.BillController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Bill;
import model.Item;
import model.User;

public class AddBillView {
    private final User currentUser;
    
    public AddBillView(User user) {
     currentUser = user;
    }

    public Scene showView(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setHgap(10); root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        TextField nameField = new TextField();
        root.add(new Label("Name of the product: "), 1, 1);
        root.add(nameField, 2, 1);

        TextField cathegoryField = new TextField();
        root.add(new Label("Cathegory"), 1, 2);
        root.add(cathegoryField, 2, 2);
        
        TextField supplierField = new TextField();
        root.add(new Label("Supplier"), 1, 3);
        root.add(supplierField, 2, 3);

        TextField quantityField = new TextField();
        root.add(new Label("Quantity"), 1, 4);
        root.add(quantityField, 2, 4);

        TextField sellPriceField = new TextField();
        root.add(new Label("Price"), 1, 5);
        root.add(sellPriceField, 2, 5);

        DatePicker date = new DatePicker();
        root.add(new Label("Date"), 1, 6);
        root.add(date, 2, 6);
        
        Button createBill = new Button("Create Bill");
        root.add(createBill, 2, 9);

        createBill.setOnAction(event -> {
        	int res;
            String name = nameField.getText();
            String supplier = supplierField.getText();
            String cathegory = cathegoryField.getText();
             res = Integer.parseInt(quantityField.getText());
            LocalDate datePurchased = date.getValue();
            double sellPrice = Double.parseDouble(sellPriceField.getText());
            BillController bc = new BillController();
            Bill bill = new Bill(name, supplier,datePurchased, sellPrice,res);
           // bc.addBill(bill); 
            bc.writeFile(bill);
            Alert addBill = new Alert(Alert.AlertType.CONFIRMATION);
            addBill.setHeaderText("The bill was created successfully. You can always check it in the bill folder under the project folder.");
            addBill.showAndWait();
            cashierView cv = new cashierView();
            primaryStage.setScene(cv.showScene(primaryStage));
        });
        primaryStage.setTitle("Create bill view");
        root.setStyle("-fx-background-image:url('imageResources/imageA.jpg')");
        return new Scene(root, 400, 400);
    }
}
