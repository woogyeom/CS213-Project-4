module rucafe.ordermanager.cs213project4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens rucafe.ordermanager to javafx.fxml;
    exports rucafe.ordermanager;
}