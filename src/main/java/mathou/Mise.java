package mathou;

public class Mise {
    private long valeur;
    private String affichage;

    public Mise(long valeur, String affichage) {
        this.valeur = valeur;
        this.affichage = affichage;
    }

    public long getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return affichage;
    }
}

