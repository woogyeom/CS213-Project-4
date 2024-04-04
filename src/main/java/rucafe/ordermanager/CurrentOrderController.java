package rucafe.ordermanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller class for managing the current order view.
 *
 * @author Woogyeom Sim
 */
public class CurrentOrderController {
    @FXML
    private ListView<MenuItem> orderItemsListView;
    @FXML
    private TextField subTotalTextField;
    @FXML
    private TextField salesTaxTextField;
    @FXML
    private TextField totalAmountTextField;

    private final OrderList orderList = OrderList.getInstance();
    private Order curOrder;

    /**
     * Initializes the current order view with the current order details.
     */
    @FXML
    private void initialize() {
        curOrder = orderList.getCurOrder();

        updateItemListView();
        updatePrice();
    }

    /**
     * Handles the event when the place order button is clicked.
     */
    @FXML
    private void onPlaceOrderButtonClick() {
        if (curOrder.getItems().isEmpty()) return;
        orderList.submitOrder(curOrder);
        curOrder = orderList.getCurOrder();
        updateItemListView();
        updatePrice();
    }

    /**
     * Handles the event when the remove item button is clicked.
     */
    @FXML
    private void onRemoveItemButtonClick() {
        if (orderItemsListView.getSelectionModel().getSelectedItem() == null) return;
        curOrder.removeItem(orderItemsListView.getSelectionModel().getSelectedItem());

        updateItemListView();
        updatePrice();
    }

    /**
     * Updates the order items list view with the current order items.
     */
    private void updateItemListView() {
        orderItemsListView.getItems().clear();
        for (MenuItem item : curOrder.getItems()) {
            orderItemsListView.getItems().add(item);
        }
    }

    /**
     * Updates the price fields with the current order details.
     */
    private void updatePrice() {
        double subTotal = curOrder.getSubTotal();
        double salesTax = curOrder.getSalesTax();
        double totalAmount = curOrder.getTotalAmount();

        String formattedSubTotal = String.format("%.2f", subTotal);
        subTotalTextField.setText(formattedSubTotal);
        String formattedSalesTax = String.format("%.2f", salesTax);
        salesTaxTextField.setText(formattedSalesTax);
        String formattedTotalAmount = String.format("%.2f", totalAmount);
        totalAmountTextField.setText(formattedTotalAmount);
    }

}
