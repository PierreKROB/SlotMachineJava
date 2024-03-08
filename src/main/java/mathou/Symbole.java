package mathou;

public class Symbole {
    // Attributs de la classe
    private String nom;
    private double probabilité;
    private double[] multiplicateurs; // Changé en tableau de double

    // Constructeur de la classe Symbole
    public Symbole(String nom, double probabilité, double[] multiplicateurs) {
        this.nom = nom;
        this.probabilité = probabilité;
        this.multiplicateurs = multiplicateurs;
    }

    // Méthodes get pour chaque attribut
    public String getNom() {
        return nom;
    }

    public double getProbabilité() {
        return probabilité;
    }

    public double[] getMultiplicateurs() { // Retourne maintenant un tableau de double
        return multiplicateurs;
    }

    // Méthode pour afficher les informations du symbole
    public void afficherInfos() {
        System.out.println("Symbole: " + nom);
        System.out.println("Probabilité: " + probabilité);
        System.out.print("Multiplicateurs: ");
        for (int i = 0; i < multiplicateurs.length; i++) {
            System.out.print(multiplicateurs[i] + " ");
        }
        System.out.println();
    }
}
