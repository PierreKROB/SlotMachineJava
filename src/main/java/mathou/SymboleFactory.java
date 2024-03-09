package mathou;

public class SymboleFactory {
    // Création des symboles représentant des Pokémon
    private static final Symbole Mewtwo = new Symbole("mewtwo", 0.0359, new double[]{4, 10, 20});
    private static final Symbole Mew = new Symbole("mew", 0.0479, new double[]{3, 6, 10});
    private static final Symbole Ronflex = new Symbole("ronflex", 0.0719, new double[]{2, 4, 6});
    private static final Symbole Pikachu = new Symbole("pikachu", 0.0103, new double[]{1.2, 3, 5});
    private static final Symbole Évoli = new Symbole("evoli", 0.1150, new double[]{0.8, 2, 4});
    private static final Symbole Magicarpe = new Symbole("magicarpe", 0.1438, new double[]{0.6, 1.6, 2.4});
    private static final Symbole Bulbizarre = new Symbole("bulbizarre", 0.1917, new double[]{0.4, 1.2, 2});
    private static final Symbole Carapuce = new Symbole("carapuce", 0.1917, new double[]{0.2, 0.8, 1.6});
    private static final Symbole Salamèche = new Symbole("salameche", 0.1917, new double[]{0.12, 0.4, 1.2});

    // Méthode pour obtenir tous les symboles Pokémon avec leurs probabilités
    public static Symbole[] getSymbolesProbables() {
        return new Symbole[]{Pikachu, Bulbizarre, Salamèche, Carapuce, Évoli, Magicarpe, Ronflex, Mew, Mewtwo};
    }
}
