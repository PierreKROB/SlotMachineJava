package mathou;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SlotMachineApp extends Application {
    private GrilleJeu grilleJeu; // Ajoutez cette ligne pour utiliser la grille de jeu
    private Circle[][] circles; // Pour garder la trace des cercles dans la grille UI

    @Override
    public void start(Stage primaryStage) {
        grilleJeu = new GrilleJeu(); // Initialiser la grille de jeu
        circles = new Circle[3][5]; // Initialiser le tableau de cercles

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10); // Espacement entre les éléments

        // Créer et ajouter des cercles colorés pour représenter les Pokémon
        initializeGrid(grid);

        Button spinButton = new Button("Spin");
        spinButton.setOnAction(event -> {
            grilleJeu.remplirGrille(); // Remplir la grille avec des symboles aléatoires
            updateGrid(); // Mettre à jour l'interface utilisateur en fonction de la nouvelle grille
        });

        Label infoLabel = new Label("Bienvenue à la machine à sous Pokémon !");

        HBox controlBox = new HBox(10, spinButton, infoLabel);
        controlBox.setAlignment(Pos.CENTER);
        grid.add(controlBox, 0, 3, 5, 1); // Fusionnez les colonnes pour le contrôle

        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setTitle("Machine à Sous Pokémon JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeGrid(GridPane grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Circle circle = new Circle(50); // Créer un cercle avec un rayon de 50
                grid.add(circle, j, i);
                circles[i][j] = circle; // Stocker le cercle pour mise à jour ultérieure
            }
        }
    }

    private void updateGrid() {
        Symbole[][] symboles = grilleJeu.getSymboles(); // Obtenir les symboles de la grille de jeu
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Color color = getColorForSymbole(symboles[i][j]); // Obtenir la couleur associée au symbole
                circles[i][j].setFill(color); // Mettre à jour la couleur du cercle
            }
        }
    }

    // Cette méthode doit retourner une couleur pour chaque type de symbole
    private Color getColorForSymbole(Symbole symbole) {
        if (symbole == null) return Color.WHITE; // Si aucun symbole, afficher un cercle blanc
        switch (symbole.getNom()) {
            case "Pikachu": return Color.YELLOW;
            case "Bulbizarre": return Color.GREEN;
            case "Salamèche": return Color.RED;
            case "Carapuce": return Color.BLUE;
            case "Évoli": return Color.BROWN;
            case "Magicarpe": return Color.ORANGE;
            case "Ronflex": return Color.GRAY;
            case "Mew": return Color.PINK;
            case "Mewtwo": return Color.PURPLE;
            default: return Color.BLACK; // Couleur par défaut si le symbole n'est pas reconnu
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
