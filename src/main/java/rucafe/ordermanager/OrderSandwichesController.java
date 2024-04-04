package rucafe.ordermanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller class for the "Order Sandwiches" view.
 *
 * @author Woogyeom Sim
 */
public class OrderSandwichesController {
    public Button addToOrderButton;
    @FXML
    private TextField subTotalTextField;
    @FXML
    private RadioButton bagelRadio;
    @FXML
    private RadioButton wheatToastRadio;
    @FXML
    private RadioButton sourDoughRadio;
    @FXML
    private RadioButton beefRadio;
    @FXML
    private RadioButton fishRadio;
    @FXML
    private RadioButton chickenRadio;
    @FXML
    private CheckBox cheeseCheckBox;
    @FXML
    private CheckBox lettuceCheckBox;
    @FXML
    private CheckBox tomatoCheckBox;
    @FXML
    private CheckBox onionCheckBox;

    @FXML
    private ToggleGroup breadGroup;
    @FXML
    private ToggleGroup proteinGroup;
    private final OrderList orderList = OrderList.getInstance();
    private Sandwich sandwich;

    /**
     * Initializes the controller.
     */
    @FXML
    private void initialize() {
        bagelRadio.setSelected(true);
        beefRadio.setSelected(true);
        sandwich = new Sandwich("Bagel", SandwichProtein.BEEF, new boolean[]{false, false, false, false}, 1);
        updateSubTotal();
    }

    /**
     * Clears the selection and resets the sandwich.
     */
    private void clear() {
        bagelRadio.setSelected(true);
        beefRadio.setSelected(true);
        cheeseCheckBox.setSelected(false);
        lettuceCheckBox.setSelected(false);
        tomatoCheckBox.setSelected(false);
        onionCheckBox.setSelected(false);
        sandwich = new Sandwich("Bagel", SandwichProtein.BEEF, new boolean[]{false, false, false, false}, 1);
        updateSubTotal();
    }

    /**
     * Handles the selection of bread type.
     */
    @FXML
    private void handleBread() {
        String bread = ((RadioButton) breadGroup.getSelectedToggle()).getText();
        sandwich.setBread(bread);
        updateSubTotal();
    }

    /**
     * Handles the selection of protein type.
     */
    @FXML
    private void handleProtein() {
        SandwichProtein protein = SandwichProtein.valueOf(((RadioButton) proteinGroup.getSelectedToggle()).getText().toUpperCase());
        sandwich.setProtein(protein);
        updateSubTotal();
    }

    /**
     * Handles the selection of add-ons.
     */
    @FXML
    private void handleAddOns() {
        boolean[] selected = new boolean[]{cheeseCheckBox.isSelected(), lettuceCheckBox.isSelected(), tomatoCheckBox.isSelected(), onionCheckBox.isSelected()};
        sandwich.setAdd_ons(selected);
        updateSubTotal();
    }

    /**
     * Handles the "Add to Order" button click event.
     */
    @FXML
    private void onAddToOrderButtonClick() {
        Order curOrder = orderList.getCurOrder();
        if (curOrder.find(sandwich) == null) {
            curOrder.addItem(sandwich);
        } else {
            curOrder.find(sandwich).setQuantity(curOrder.find(sandwich).getQuantity() + sandwich.getQuantity());
        }
        clear();

        Stage stage = (Stage) addToOrderButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Updates the subtotal text field based on the selected options.
     */
    @FXML
    private void updateSubTotal() {
        double subTotal = sandwich.price();
        String formattedSubTotal = String.format("%.2f", subTotal);
        subTotalTextField.setText(formattedSubTotal);
    }
}
