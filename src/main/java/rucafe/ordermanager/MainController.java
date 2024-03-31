package rucafe.ordermanager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    // Gotta change the buttons to image buttons

    @FXML
    protected void onOrderDonutsButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RUCafe.class.getResource("order-donuts.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Donuts");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onOrderCoffeeButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RUCafe.class.getResource("order-coffee.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Coffee");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onOrderSandwichesButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RUCafe.class.getResource("order-sandwiches.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Sandwiches");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onOrderCurrentOrderButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RUCafe.class.getResource("current-order.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onOrderAllOrdersButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RUCafe.class.getResource("all-order.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("All Orders");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}