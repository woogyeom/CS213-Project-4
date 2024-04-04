package rucafe.ordermanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main application class for the RU Cafe.
 */
public class RUCafe extends Application {

    /**
     * Starts the JavaFX application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs during loading of the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUCafe.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("RU Cafe");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method to launch the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch();
    }
}