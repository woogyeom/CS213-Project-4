package rucafe.ordermanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderCoffeeController {
    public Button addToOrderButton;
    @FXML
    private ComboBox<Integer> coffeeQuantityComboBox;
    @FXML
    private ComboBox<CoffeeSize> coffeeSizeComboBox;
    @FXML
    private TextField subTotalTextField;
    @FXML
    private CheckBox sweetCreamCheckBox;
    @FXML
    private CheckBox frenchVanillaCheckBox;
    @FXML
    private CheckBox irishCreamCheckBox;
    @FXML
    private CheckBox mochaCheckBox;
    @FXML
    private CheckBox caramelCheckBox;

    private final OrderList orderList = OrderList.getInstance();
    private Coffee coffee;

    @FXML
    private void initialize() {
        for (CoffeeSize coffeeSize : CoffeeSize.values()) {
            coffeeSizeComboBox.getItems().add(coffeeSize);
        }
        coffeeSizeComboBox.setValue(CoffeeSize.SHORT);

        for (int i = 1; i <= 5; i++) {
            coffeeQuantityComboBox.getItems().add(i);
        }
        coffeeQuantityComboBox.setValue(1);

        coffee = new Coffee(CoffeeSize.SHORT, new boolean[]{false, false, false, false, false}, 1);
        updateSubTotal();
    }

    @FXML
    private void clear() {
        coffeeSizeComboBox.setValue(CoffeeSize.SHORT);
        coffeeQuantityComboBox.setValue(1);
        sweetCreamCheckBox.setSelected(false);
        frenchVanillaCheckBox.setSelected(false);
        irishCreamCheckBox.setSelected(false);
        mochaCheckBox.setSelected(false);
        caramelCheckBox.setSelected(false);
        coffee = new Coffee(CoffeeSize.SHORT, new boolean[]{false, false, false, false, false}, 1);
        updateSubTotal();
    }

    @FXML
    private void handleCoffeeSize() {
        coffee.setCoffeeSize(coffeeSizeComboBox.getValue());
        updateSubTotal();
    }

    @FXML
    private void handleCoffeeQuantity() {
        coffee.setQuantity(coffeeQuantityComboBox.getValue());
        updateSubTotal();
    }

    @FXML
    private void handleAddIns() {
        boolean[] selected = new boolean[]{sweetCreamCheckBox.isSelected(), frenchVanillaCheckBox.isSelected(), irishCreamCheckBox.isSelected(), mochaCheckBox.isSelected(), caramelCheckBox.isSelected()};
        coffee.setAdd_ins(selected);
        updateSubTotal();
    }

    @FXML
    private void onAddToOrderButtonClick() {
        Order curOrder = orderList.getCurOrder();
        if (curOrder.find(coffee) == null) {
            curOrder.addItem(coffee);
        } else {
            curOrder.find(coffee).setQuantity(curOrder.find(coffee).getQuantity() + coffee.getQuantity());
        }
//        clear();

        Stage stage = (Stage) addToOrderButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void updateSubTotal() {
        double subTotal = coffee.price();
        String formattedSubTotal = String.format("%.2f", subTotal);
        subTotalTextField.setText(formattedSubTotal);
    }
}
