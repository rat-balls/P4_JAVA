package model;

public class player {
    
    private String nom;
    private int couleur;
    private Character symbole;

    public player(String nom, int couleur, Character symbole) {
        this.nom = nom;
        this.couleur = couleur;
        this.symbole = symbole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public Character getSymbole() {
        return symbole;
    }

    public void setSymbole(Character symbole) {
        this.symbole = symbole;
    }
}
