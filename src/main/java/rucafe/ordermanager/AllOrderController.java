package rucafe.ordermanager;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for managing all orders.
 *
 * @author Aravind Chendu
 */
public class AllOrderController {

    @FXML
    private ListView<String> ordersList;

    @FXML
    private Button removeOrderButton;

    @FXML
    private Button exportOrdersButton;

    private final OrderList orderList = OrderList.getInstance();
    private Order curOrder;

    /**
     * Initializes the orders list view with all existing orders.
     */
    @FXML
    public void initialize() {
        List<String> orderStrings = OrderList.getInstance().getAllOrders().stream()
                .map(Order::toString)
                .collect(Collectors.toList());
        ordersList.setItems(FXCollections.observableArrayList(orderStrings));
    }

    /**
     * Handles the event when the remove order button is clicked.
     */
    @FXML
    private void onRemoveOrderClicked() {
        String selectedOrderString = ordersList.getSelectionModel().getSelectedItem();
        if (selectedOrderString != null && !selectedOrderString.isEmpty()) {
            int orderNumber = extractOrderNumber(selectedOrderString);

            if (orderNumber != -1) {
                OrderList.getInstance().removeOrder(orderNumber);
                ordersList.getItems().remove(selectedOrderString);
            }
        }
    }

    /**
     * Extracts the order number from the order string representation.
     *
     * @param orderString The string representation of the order.
     * @return The extracted order number, or -1 if extraction fails.
     */
    private int extractOrderNumber(String orderString) {
        try {
            String orderNumberStr = orderString.substring(orderString.indexOf(":") + 2, orderString.indexOf("\n"));
            return Integer.parseInt(orderNumberStr.trim());
        } catch (Exception e) {
            System.err.println("Failed to extract order number: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Handles the event when the export orders button is clicked.
     *
     * @param event The action event triggered by the button click.
     */
    @FXML
    void onExportOrdersClicked(ActionEvent event) {
        OrderList.getInstance().saveOrdersToFile();
        //System.out.println("Orders have been successfully exported to orders.txt");
    }



}
