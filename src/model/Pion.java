package model;

public class Pion {

    private Joueur joueur;

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Pion(Joueur joueur) {
        this.joueur = joueur;
    }

}
