package model;

import java.util.ArrayList;


public class IA {
    
    private Joueur joueur;
    private int difficulte;

    public IA(model.Joueur joueur, int difficulte) {
        this.joueur = joueur;
        this.difficulte = difficulte;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public int getDifficulte() {
        return difficulte;
    }
    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
    // ============================================================================================
    // ============================================================================================
    public static void jeuOrdi(){
        System.out.println();
        System.out.println();
        ArrayList<ArrayList<String>> g = Grid.createGrid();
        Grid.affichage(g);
        System.out.println();
        System.out.println();
    }
}
