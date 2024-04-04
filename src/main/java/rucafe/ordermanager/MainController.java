package rucafe.ordermanager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Controller class for the main view of the application.
 *
 * @author Woogyeom Sim, Aravind Chendu
 */
public class MainController {
    @FXML
    public Button allOrdersButton;

    /**
     * Initializes the main view.
     */
    @FXML
    protected void initialize() {
        ImageView imageView = new ImageView(Objects.requireNonNull(getClass().getResource("all-orders.png")).toExternalForm());
        allOrdersButton.setGraphic(imageView);
    }

    /**
     * Handles the event when the order donuts button is clicked.
     */
    @FXML
    protected void onOrderDonutsButtonClick() {
        openNewStage("Order Donuts", "order-donuts.fxml");
    }

    /**
     * Handles the event when the order coffee button is clicked.
     */
    @FXML
    protected void onOrderCoffeeButtonClick() {
        openNewStage("Order Coffee", "order-coffee.fxml");
    }

    /**
     * Handles the event when the order sandwiches button is clicked.
     */
    @FXML
    protected void onOrderSandwichesButtonClick() {
        openNewStage("Order Sandwiches", "order-sandwiches.fxml");
    }

    /**
     * Handles the event when the order current order button is clicked.
     */
    @FXML
    protected void onOrderCurrentOrderButtonClick() {
        openNewStage("Current Order", "current-order.fxml");
    }

    /**
     * Handles the event when the order all orders button is clicked.
     */
    @FXML
    protected void onOrderAllOrdersButtonClick() {
        openNewStage("All Orders", "all-order.fxml");
    }

    /**
     * Opens a new stage with the specified title and FXML file.
     *
     * @param title   The title of the new stage.
     * @param fxmlUrl The URL of the FXML file.
     */
    private void openNewStage(String title, String fxmlUrl) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlUrl));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
