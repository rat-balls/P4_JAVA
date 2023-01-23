package model;

public class IA {
    Joueur Joueur;
    int Difficulté;

    public IA(model.Joueur joueur, int difficulté) {
        Joueur = joueur;
        Difficulté = difficulté;
    }
    public Joueur getJoueur() {
        return Joueur;
    }
    public void setJoueur(Joueur joueur) {
        Joueur = joueur;
    }
    public int getDifficulté() {
        return Difficulté;
    }
    public void setDifficulté(int difficulté) {
        Difficulté = difficulté;
    }
}
