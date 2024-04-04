package rucafe.ordermanager;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Controller class for the donut ordering interface.
 *
 * @author Woogyeom Sim
 */
public class OrderDonutsController {
    public Button addToOrderButton;
    @FXML
    private ComboBox<String> donutTypeComboBox;

    @FXML
    private ComboBox<Integer> donutQuantityComboBox;

    @FXML
    private ListView<String> availableFlavorsListView;

    @FXML
    private ListView<String> selectedFlavorsListView;

    @FXML
    private TextField subTotalTextField;

    private final OrderList orderList = OrderList.getInstance();
    private List<Donut> selectedDonuts;

    /**
     * Initializes the controller.
     */
    @FXML
    private void initialize() {
        selectedDonuts = new ArrayList<Donut>();

        for (DonutType type : DonutType.values()) {
            donutTypeComboBox.getItems().add(type.getDisplayName());
        }
        donutTypeComboBox.setValue(DonutType.YEAST.getDisplayName());

        for (int i = 1; i <= 12; i++) {
            donutQuantityComboBox.getItems().add(i);
        }
        donutQuantityComboBox.setValue(1);

        updateAvailableFlavors();
        updateSubTotal();
    }

    /**
     * Retrieves the selected donut type.
     * @return The selected donut type.
     */
    private DonutType getDonutType() {
        return Objects.requireNonNull(DonutType.fromDisplayName(donutTypeComboBox.getValue()));
    }

    /**
     * Retrieves the selected donut quantity.
     * @return The selected donut quantity.
     */
    private int getDonutQuantity() {
        return donutQuantityComboBox.getValue();
    }

    /**
     * Handles the selection of donut type.
     */
    @FXML
    private void handleDonutType() {
        updateAvailableFlavors();
    }

    /**
     * Handles the addition of a donut to the order.
     */
    @FXML
    private void onAddDonutButtonClick() {
        if (availableFlavorsListView.getSelectionModel().getSelectedItem() == null) return;
        Donut selectedDonut = new Donut(getDonutType(), availableFlavorsListView.getSelectionModel().getSelectedItem(), getDonutQuantity());
        selectedDonuts.add(selectedDonut);

        updateAvailableFlavors();
        updateSelectedFlavors();
        updateSubTotal();
    }

    /**
     * Handles the removal of a donut from the order.
     */
    @FXML
    private void onRemoveDonutButtonClick() {
        if (selectedFlavorsListView.getSelectionModel().getSelectedItem() == null) return;
        Donut donutToRemove = null;
        for (Donut donut : selectedDonuts) {
            if (donut.equals(Utils.stringToDonut(selectedFlavorsListView.getSelectionModel().getSelectedItem()))) {
                donutToRemove = donut;
            }
        }
        if (donutToRemove != null) {
            selectedDonuts.remove(donutToRemove);
        }
        updateAvailableFlavors();
        updateSelectedFlavors();
        updateSubTotal();
    }

    /**
     * Handles the addition of selected donuts to the order.
     */
    @FXML
    private void onAddToOrderButtonClick() {
        Order curOrder = orderList.getCurOrder();
        if (selectedDonuts.isEmpty()) return;
        for (Donut selectedDonut : selectedDonuts) {
            if (curOrder.find(selectedDonut) == null) {
                curOrder.addItem(selectedDonut);
            } else {
                curOrder.find(selectedDonut).setQuantity(curOrder.find(selectedDonut).getQuantity() + selectedDonut.getQuantity());
            }
        }
        selectedDonuts.clear();
        updateAvailableFlavors();
        updateSelectedFlavors();
        updateSubTotal();

        Stage stage = (Stage) addToOrderButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Updates the available flavors list based on the selected donut type.
     */
    private void updateAvailableFlavors() {
        String[] availableFlavors = getDonutType().getFlavors();
        availableFlavorsListView.getItems().clear();

        for (String availableFlavor : availableFlavors) {
            boolean flavorAlreadySelected = false;
            for (Donut selectedDonut : selectedDonuts) {
                if (availableFlavor.equals(selectedDonut.getFlavor())) {
                    flavorAlreadySelected = true;
                    break;
                }
            }
            if (!flavorAlreadySelected) {
                availableFlavorsListView.getItems().add(availableFlavor);
            }
        }
    }

    /**
     * Updates the selected flavors list.
     */
    private void updateSelectedFlavors() {
        selectedFlavorsListView.getItems().clear();
        for (Donut donut : selectedDonuts) {
            selectedFlavorsListView.getItems().add(donut.getFlavor() + "(" + donut.getQuantity() + ")");
        }
    }

    /**
     * Updates the subtotal display.
     */
    private void updateSubTotal() {
        double subTotal = 0;
        for (Donut donut : selectedDonuts) {
            subTotal += donut.price();
        }
        String formattedSubTotal = String.format("%.2f", subTotal);
        subTotalTextField.setText(formattedSubTotal);
    }
}
