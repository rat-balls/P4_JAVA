package model;

public class Joueur {
    private String nom;
    private int couleur;
    private Character symbole;

    public Joueur() {
    }

    // Nom du joueur ================================================================================
    // ==============================================================================================
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    // ============================================================================================
    // ============================================================================================

    


    // Couleur du joueur ==========================================================================
    // ============================================================================================
    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
    // ============================================================================================
    // ============================================================================================




    // Symbole du joueur ==========================================================================
    // ============================================================================================
    public Character getSymbole() {
        return symbole;
    }

    public void setSymbole(Character symbole) {
        this.symbole = symbole;
    }
    // ============================================================================================
    // ============================================================================================
}
