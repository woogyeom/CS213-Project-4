package rucafe.ordermanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

    @FXML
    private void initialize() {
        curOrder = orderList.getCurOrder();

        updateItemListView();
        updatePrice();
    }

    @FXML
    private void onPlaceOrderButtonClick() {
        orderList.submitOrder(curOrder);
        updateItemListView();
        updatePrice();
    }

    @FXML
    private void onRemoveItemButtonClick() {
        if (orderItemsListView.getSelectionModel().getSelectedItem() == null) return;
        curOrder.removeItem(orderItemsListView.getSelectionModel().getSelectedItem());

        updateItemListView();
        updatePrice();
    }

    private void updateItemListView() {
        orderItemsListView.getItems().clear();
        for (MenuItem item : curOrder.getItems()) {
            orderItemsListView.getItems().add(item);
        }
    }

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
