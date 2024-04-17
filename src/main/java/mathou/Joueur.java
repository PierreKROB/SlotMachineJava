package mathou;

public class Joueur {
    // Attributs de la classe Joueur
    private String nom;
    private long jetons;
    private long meilleurGain;
    private int nombreDeCoupsJoués;
    private int nombreDeJoursJoués;

    // Constructeur de la classe Joueur
    public Joueur(String nom) {
        this.nom = nom;
        this.jetons = 200000;
        this.meilleurGain = 0;
        this.nombreDeCoupsJoués = 0;
        this.nombreDeJoursJoués = 0;
    }

    // Méthodes get et set pour chaque attribut
    public String getNom() {
        return nom;
    }

    public long getJetons() {
        return jetons;
    }

    public void setJetons(long jetons) {
        this.jetons = jetons;
    }

    public long getMeilleurGain() {
        return meilleurGain;
    }

    public void setMeilleurGain(long meilleurGain) {
        this.meilleurGain = meilleurGain;
    }

    public int getNombreDeCoupsJoués() {
        return nombreDeCoupsJoués;
    }

    public void incrementerCoupsJoués() {
        this.nombreDeCoupsJoués++;
    }

    public int getNombreDeJoursJoués() {
        return nombreDeJoursJoués;
    }

    public void incrementerJoursJoués() {
        this.nombreDeJoursJoués++;
    }

    // Méthode pour ajouter des jetons au joueur
    public void ajouterJetons(long montant) {
        this.jetons += montant;
    }

    // Méthode pour enregistrer un gain et mettre à jour le meilleur gain si nécessaire
    public void enregistrerGain(long montant) {
        this.jetons += montant;
        if (montant > meilleurGain) {
            meilleurGain = montant;
        }
        incrementerCoupsJoués();
    }
}

