package mathou;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SlotMachineApp extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        try {
            SlotMachineApp.primaryStage = primaryStage;

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));

            primaryStage.setTitle("Connexion");

            primaryStage.setScene(new Scene(root));

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}