package mathou;
import java.util.Random;

public class GrilleJeu {
    // Attributs de la classe
    private Symbole[][] symboles; // Un tableau 2D pour stocker les symboles de la grille
    private final int lignes = 3; // Nombre de lignes de la grille
    private final int colonnes = 5; // Nombre de colonnes de la grille

    // Constructeur de la classe Grille
    public GrilleJeu() {
        this.symboles = new Symbole[lignes][colonnes]; // Initialisation du tableau de symboles
    }


    public void remplirGrille() {
        Random random = new Random(); // Créer une instance de Random pour générer des nombres aléatoires

        Symbole[] symbolesProbables = SymboleFactory.getSymbolesProbables();

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                double p = random.nextDouble(); // Générer un nombre aléatoire entre 0.0 et 1.0
                double cumulativeProbability = 0.0;

                // Parcourir tous les symboles possibles
                for (Symbole symbole : symbolesProbables) {
                    cumulativeProbability += symbole.getProbabilité(); // Cumuler la probabilité

                    // Sélectionner le symbole si p est inférieur à la probabilité cumulative
                    if (p <= cumulativeProbability) {
                        this.symboles[i][j] = symbole;
                        break; // Arrêter la boucle une fois le symbole assigné
                    }
                }
            }
        }
    }

    // Méthode pour afficher la grille dans la console
    public void afficherGrille() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (symboles[i][j] != null) {
                    System.out.print(symboles[i][j].getNom() + " ");
                } else {
                    System.out.print("Empty ");
                }
            }
            System.out.println();
        }
    }


    public Symbole[][] getSymboles() {
        return symboles;
    }

    public int getLignes() {
        return lignes;
    }

    public int getColonnes() {
        return colonnes;
    }

}
