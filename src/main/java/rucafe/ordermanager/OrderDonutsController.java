package rucafe.ordermanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDonutsController {
    @FXML
    private ComboBox<String> donutTypeComboBox;

    @FXML
    private ComboBox<String> donutQuantityComboBox;

    @FXML
    private ListView<String> availableFlavorsListView;

    @FXML
    private ListView<String> selectedFlavorsListView;

    @FXML
    private TextField subTotalTextField;

    private List<Donut> selectedDonuts;

    @FXML
    private void initialize() {
        selectedDonuts = new ArrayList<Donut>();

        for (DonutType type : DonutType.values()) {
            donutTypeComboBox.getItems().add(type.getDisplayName());
        }
        donutTypeComboBox.setValue(DonutType.YEAST.getDisplayName());

        for (int i = 1; i <= 12; i++) {
            donutQuantityComboBox.getItems().add(String.valueOf(i));
        }
        donutQuantityComboBox.setValue("1");

        updateAvailableFlavors();
    }

    private DonutType getDonutType() {
        return Objects.requireNonNull(DonutType.fromDisplayName(donutTypeComboBox.getValue()));
    }

    private int getDonutQuantity() {
        return Integer.parseInt(donutQuantityComboBox.getValue());
    }

    @FXML
    private void handleDonutType() {
        updateAvailableFlavors();
    }

    @FXML
    private void onAddDonutButtonClick() {
        if (availableFlavorsListView.getSelectionModel().getSelectedItem() == null) return;
        Donut selectedDonut = new Donut(getDonutType(), availableFlavorsListView.getSelectionModel().getSelectedItem(), getDonutQuantity());
        selectedDonuts.add(selectedDonut);

        updateAvailableFlavors();
        updateSelectedFlavors();
        updateSubTotal();
    }

    @FXML
    private void onRemoveDonutButtonClick() {
        if (selectedFlavorsListView.getSelectionModel().getSelectedItem() == null) return;
        Donut donutToRemove = null;
        for (Donut donut : selectedDonuts) {
            if (donut.equals(selectedFlavorsListView.getSelectionModel().getSelectedItem())) {
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

    @FXML
    private void onAddToOrderButtonClick(ActionEvent actionEvent) {
        if (selectedDonuts.isEmpty()) return;

    }

    @FXML
    private void updateAvailableFlavors() {
        String[] availableFlavors = getDonutType().getFlavors();
        availableFlavorsListView.getItems().clear();

        for (String availableFlavor : availableFlavors) {
            boolean flavorAlreadySelected = false;
            for (int i = 0; i < selectedDonuts.size(); i++) {
                if (availableFlavor.equals(selectedDonuts.get(i).getFlavor())) {
                    flavorAlreadySelected = true;
                    break;
                }
            }
            if (!flavorAlreadySelected) {
                availableFlavorsListView.getItems().add(availableFlavor);
            }
        }
    }

    @FXML
    private void updateSelectedFlavors() {
        selectedFlavorsListView.getItems().clear();
        for (Donut donut : selectedDonuts) {
            selectedFlavorsListView.getItems().add(donut.getFlavor() + "(" + donut.getQuantity() + ")");
        }
    }

    @FXML
    private void updateSubTotal() {
        double subTotal = 0;
        for (Donut donut : selectedDonuts) {
            subTotal += donut.getType().getPrice() * donut.getQuantity();
        }
        String formattedSubTotal = String.format("%.2f", subTotal);

        subTotalTextField.setText(formattedSubTotal);
    }
}
