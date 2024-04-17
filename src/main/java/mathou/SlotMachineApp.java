package mathou;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SlotMachineApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML pour l'interface utilisateur
            Parent root = FXMLLoader.load(getClass().getResource("SlotMachineUI.fxml"));

            // Définir le titre de la fenêtre
            primaryStage.setTitle("SlotMachine Pokémon");

            // Créer et définir la scène
            primaryStage.setScene(new Scene(root));

            // Afficher la fenêtre
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
