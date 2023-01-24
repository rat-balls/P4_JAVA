package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


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
    public static ArrayList<ArrayList<String>> modifia(ArrayList<ArrayList<String>>g, int joueur){
        String err1 = "Entrer une colone valide";
        String err2 = "Entrer un chiffre.\nPas une lettre ou un nombre ";
        int coor = (int)(Math.random() * 10 + 1);
        if (joueur ==2){
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)) == "-" ){
                    if((g.get(li-1).get(coor-1)) != "-"){
                        break;
                    }
                }
                if(li == 0 || !g.get(li).contains("-")){
                    return modifia(g,2);
                }
            }
            
            if(coor < 1 || coor > 7) {
                System.out.println(err1);
                return modifia(g,2);
            }
        
            g.get(li).set(coor-1,"O");
        }
            
        return g;
        
    }

    
}
