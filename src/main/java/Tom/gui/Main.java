package Tom.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Tom.Tom;
//gui commit
//assertions trial
/**
 * Main driver class for the GUI application
 */
public class Main extends Application {
    private Tom tom = new Tom();

    /**
     * Starts the JavaFX application.
     * Loads the FXML layout, initializes the scene, and displays the main window.
     *
     * @param stage The primary stage for the JavaFX application.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = loadFxml();
            assert fxmlLoader != null : "FXML loader should not be null!";
            AnchorPane root = loadRoot(fxmlLoader);
            setupStage(stage, root);
            initializeController(fxmlLoader);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private FXMLLoader loadFxml() {
        return new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
    }

    private AnchorPane loadRoot(FXMLLoader fxmlLoader) throws IOException {
        return fxmlLoader.load();
    }

    private void setupStage(Stage stage, AnchorPane root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tom");
        stage.show();
    }

    private void initializeController(FXMLLoader fxmlLoader) {
        MainWindow controller = fxmlLoader.getController();
        controller.setDuke(tom);
    }

    private void handleException(Exception e) {
        e.printStackTrace();
    }
}