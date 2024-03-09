package mathou;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SlotMachineController {
    private GrilleJeu grilleJeu; // Utilisez votre propre logique de grille de jeu ici

    // Déclaration des ImageView définis dans le fichier FXML
    @FXML
    private ImageView image00, image01, image02, image03, image04,
            image10, image11, image12, image13, image14,
            image20, image21, image22, image23, image24; // Continuez pour les autres ImageView

    // Méthode pour initialiser la grille de jeu et les images
    @FXML
    public void initialize() {
        grilleJeu = new GrilleJeu(); // Supposons que cela initialise la grille de jeu
        grilleJeu.remplirGrille();

    }

    // Méthode appelée lorsque l'utilisateur appuie sur le bouton "Spin"
    @FXML
    private void spin() {
        grilleJeu.remplirGrille(); // Remplir la grille avec des symboles aléatoires
        updateGrid(); // Mettre à jour l'interface utilisateur en fonction de la nouvelle grille
    }

    // Mettre à jour les images basées sur la grille de jeu
    private void updateGrid() {
        ImageView[][] images = {
                {image00, image01, image02, image03, image04},
                {image10, image11, image12, image13, image14},
                {image20, image21, image22, image23, image24}
        };

        Symbole[][] symboles = grilleJeu.getSymboles();

        for (int i = 0; i < symboles.length; i++) {
            for (int j = 0; j < symboles[i].length; j++) {
                String nomImage = symboles[i][j].getNom().toLowerCase().replace('é', 'e') + ".png";
                Image image = new Image(getClass().getResourceAsStream("/images/" + nomImage));
                images[i][j].setImage(image);
            }
        }
    }
}