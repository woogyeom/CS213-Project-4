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
    @FXML
    protected void onOrderDonutsButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RUCafe.class.getResource("order-donuts.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onOrderCoffeeButtonClick() {

    }

    @FXML
    protected void onOrderSandwichesButtonClick() {

    }

    @FXML
    protected void onOrderCurrentOrderButtonClick() {

    }

    @FXML
    protected void onOrderAllOrdersButtonClick() {

    }
}