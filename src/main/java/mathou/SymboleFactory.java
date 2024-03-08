package mathou;

public class SymboleFactory {
    // Création des symboles représentant des Pokémon
    private static final Symbole Pikachu = new Symbole("Pikachu", 1.0/16, new double[]{4, 10, 20});
    private static final Symbole Bulbizarre = new Symbole("Bulbizarre", 1.0/12, new double[]{3, 6, 10});
    private static final Symbole Salamèche = new Symbole("Salamèche", 1.0/8, new double[]{2, 4, 6});
    private static final Symbole Carapuce = new Symbole("Carapuce", 1.0/6, new double[]{1.2, 3, 5});
    private static final Symbole Évoli = new Symbole("Évoli", 1.0/5, new double[]{0.8, 2, 4});
    private static final Symbole Magicarpe = new Symbole("Magicarpe", 1.0/4, new double[]{0.6, 1.6, 2.4});
    private static final Symbole Ronflex = new Symbole("Ronflex", 1.0/3, new double[]{0.4, 1.2, 2});
    private static final Symbole Mew = new Symbole("Mew", 1.0/3, new double[]{0.2, 0.8, 1.6});
    private static final Symbole Mewtwo = new Symbole("Mewtwo", 1.0/3, new double[]{0.12, 0.4, 1.2});

    // Méthode pour obtenir tous les symboles Pokémon avec leurs probabilités
    public static Symbole[] getSymbolesProbables() {
        return new Symbole[]{Pikachu, Bulbizarre, Salamèche, Carapuce, Évoli, Magicarpe, Ronflex, Mew, Mewtwo};
    }
}
