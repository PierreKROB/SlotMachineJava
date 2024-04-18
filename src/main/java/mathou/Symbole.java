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

    public double getMultiplier(int matchesNumber) {

        matchesNumber -= 3;
        if (matchesNumber > 0 && matchesNumber <= multiplicateurs.length) {
            System.out.println(multiplicateurs[matchesNumber - 1]);
            return multiplicateurs[matchesNumber - 1];

        }
        return 0;

    }
}
