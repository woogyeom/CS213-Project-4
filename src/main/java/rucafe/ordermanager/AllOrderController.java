package rucafe.ordermanager;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.stream.Collectors;


public class AllOrderController {

    @FXML
    private ListView<String> ordersList;

    @FXML
    private Button removeOrderButton;

    @FXML
    private Button exportOrdersButton;

    private final OrderList orderList = OrderList.getInstance();
    private Order curOrder;

    @FXML
    public void initialize() {
        List<String> orderStrings = OrderList.getInstance().getAllOrders().stream()
                .map(Order::toString)
                .collect(Collectors.toList());
        ordersList.setItems(FXCollections.observableArrayList(orderStrings));
    }

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

    private int extractOrderNumber(String orderString) {
        try {
            String orderNumberStr = orderString.substring(orderString.indexOf(":") + 2, orderString.indexOf("\n"));
            return Integer.parseInt(orderNumberStr.trim());
        } catch (Exception e) {
            System.err.println("Failed to extract order number: " + e.getMessage());
            return -1;
        }
    }

    @FXML
    void onExportOrdersClicked(ActionEvent event) {
        OrderList.getInstance().saveOrdersToFile();
        //System.out.println("Orders have been successfully exported to orders.txt");
    }



}
