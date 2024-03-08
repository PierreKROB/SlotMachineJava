package mathou;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;

public class SlotMachineController {
    private GrilleJeu grilleJeu;

    @FXML
    private Circle circle00, circle01, circle02, circle03, circle04,
            circle10, circle11, circle12, circle13, circle14,
            circle20, circle21, circle22, circle23, circle24;

    // Méthode pour initialiser la grille de jeu et les cercles
    @FXML
    public void initialize() {
        grilleJeu = new GrilleJeu();
        updateGrid();
    }

    @FXML
    private void spin(ActionEvent event) {
        grilleJeu.remplirGrille();
        updateGrid();
    }

    private void updateGrid() {
        Circle[][] circles = {{circle00, circle01, circle02, circle03, circle04},
                {circle10, circle11, circle12, circle13, circle14},
                {circle20, circle21, circle22, circle23, circle24}};

        Symbole[][] symboles = grilleJeu.getSymboles();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Color color = getColorForSymbole(symboles[i][j]);
                circles[i][j].setFill(color);
            }
        }
    }

    private Color getColorForSymbole(Symbole symbole) {
        if (symbole == null) return Color.WHITE;
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
            default: return Color.BLACK;
        }
    }
}
