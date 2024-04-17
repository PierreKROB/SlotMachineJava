package mathou;

import javafx.collections.FXCollections;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SlotMachineController {
    @FXML
    private Label labelErreur;
    @FXML
    private Label labelJetons;
    @FXML
    private Label labelGains;
    @FXML
    private ComboBox<Mise> comboMise;

    @FXML
    private Button spinButton;

    private Joueur joueur;
    private GrilleJeu grilleJeu;

    @FXML
    private void handleInfoButton() {
        showPlayerInfoModal();
    }

    @FXML
    private ImageView image00, image01, image02, image03, image04,
            image10, image11, image12, image13, image14,
            image20, image21, image22, image23, image24;

    @FXML
    public void initialize() {
        joueur = new Joueur("Pierre");
        grilleJeu = new GrilleJeu();
        grilleJeu.remplirGrille();
        updateJetonsDisplay(0);
        comboMise.setItems(FXCollections.observableArrayList(
                new Mise(400, "400"),
                new Mise(50000, "50 000"),
                new Mise(100000, "100 000"),
                new Mise(200000, "200 000"),
                new Mise(500000, "500 000"),
                new Mise(1000000, "1 000 000")
        ));
    }

    private void showPlayerInfoModal() {
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Informations du Joueur");

        // Supposons que tu as une instance de Joueur disponible
        Joueur joueur = new Joueur("René");  // Ceci devrait venir de l'état de ton application

        Label nameLabel = new Label("Nom: " + joueur.getNom());
        Label jetonsLabel = new Label("Jetons: " + joueur.getJetons());
        Label meilleurGainLabel = new Label("Meilleur Gain: " + joueur.getMeilleurGain());
        Label coupsJouesLabel = new Label("Nombre de Coups Joués: " + joueur.getNombreDeCoupsJoués());
        Label joursJouesLabel = new Label("Nombre de Jours Joués: " + joueur.getNombreDeJoursJoués());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameLabel, jetonsLabel, meilleurGainLabel, coupsJouesLabel, joursJouesLabel);

        Scene scene = new Scene(layout, 300, 200);
        modalStage.setScene(scene);
        modalStage.showAndWait();
    }

    @FXML
    private void spin() {
        Mise miseSelectionnee = comboMise.getValue();
        if (miseSelectionnee != null) {
            long mise = miseSelectionnee.getValeur();
            if (joueur.getJetons() >= mise) {
                joueur.setJetons(joueur.getJetons() - mise);
                grilleJeu.remplirGrille();
                startRollAnimation();
            } else {
                labelErreur.setText("Pas assez de jetons pour cette mise.");
            }
        } else {
            labelErreur.setText("Veuillez sélectionner une mise.");
        }
    }

    private void startRollAnimation() {
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double elapsedTime = (currentNanoTime - startNanoTime) / 1000000000.0;

                if (elapsedTime < 0.75) {
                    changeImagesRandomly();
                } else {
                    this.stop();
                    updateGrid();
                }
            }
        }.start();
    }

    private void changeImagesRandomly() {
        ImageView[][] images = {
                {image00, image01, image02, image03, image04},
                {image10, image11, image12, image13, image14},
                {image20, image21, image22, image23, image24}
        };

        Symbole[][] symboles = grilleJeu.getSymboles();

        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images[i].length; j++) {
                String nomImage = symboles[i][j].getNom().toLowerCase().replace('é', 'e') + ".png";
                images[i][j].setImage(new Image(getClass().getResourceAsStream("/images/" + nomImage)));
            }
        }
    }



    private void updateGrid() {
        double gain = grilleJeu.évaluerGains();

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

        joueur.ajouterJetons((long) gain);
        updateJetonsDisplay(gain);  // Pass the gain as a parameter
    }

    private void updateJetonsDisplay(double gain) {
        labelJetons.setText("Jetons : " + joueur.getJetons());
        labelGains.setText(String.format("Gains : %.2f", gain));  // Use the passed gain value
    }


}
