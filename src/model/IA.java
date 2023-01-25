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

    public static ArrayList<ArrayList<String>> IAmodif(ArrayList<ArrayList<String>> g, String symbole){        
        int coor = (int)(Math.random() * 7 + 1);

        int li;
        
        for(li = 5; li > 0 ; li -- ){
            if((g.get(li).get(coor-1)) == "-" ){
                if((g.get(li-1).get(coor-1)) != "-"){
                    break;
                }
            }
        }

        g.get(li).set(coor-1, symbole);
        return g;
    }
}

