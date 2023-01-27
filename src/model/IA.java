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
    
    public static ArrayList<ArrayList<String>> IAmodifLV2(ArrayList<ArrayList<String>>g, String symbole, String symbole2){
        if (Grid.anticipation(g,symbole,symbole2) > 0){
            int coor = Grid.anticipation(g,symbole,symbole2)+1;
            System.out.println(coor);
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)) == "-" ){
                    if((g.get(li-1).get(coor-1)) != "-"){
                        break;
                    }
                }
            }
    
            g.get(li).set(coor-1, symbole2);
            return g;
        }else{
            int coor = (int)(Math.random() * 7+1);
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)) == "-" ){
                    if((g.get(li-1).get(coor-1)) != "-"){
                        break;
                    }
                }
                if(li == 0 || !g.get(li).contains("-")){
                    return IAmodifLV2(g,symbole,symbole2);
                }
            }
            g.get(li).set(coor-1, symbole2);
        }
        
        return g;

    }

    
    public static ArrayList<ArrayList<String>> IAmodifLV3(ArrayList<ArrayList<String>>g, String symbole, String symbole2){
        if (Grid.anticipationNiv2(g,symbole,symbole2) > 0){
            int coor = Grid.anticipationNiv2(g,symbole,symbole2)+1;
            System.out.println(coor);
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)).equals("-") ){
                    if(!(g.get(li-1).get(coor-1)).equals("-")){
                        break;
                    }
                }
            }
    
            g.get(li).set(coor-1, symbole2);
            return g;
        }else{
            int coor = (int)(Math.floor(Math.random() * 6) + 1);
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)).equals("-")){
                    if(!(g.get(li-1).get(coor-1)).equals("-")){
                        break;
                    }
                }
                if(li == 0 || !g.get(li).contains("-")){
                    return IAmodifLV3(g,symbole,symbole2);
                }
            }
            g.get(li).set(coor-1, symbole2);
        }
        
        return g;

    }

    public static ArrayList<ArrayList<String>> IAmodifLV4(ArrayList<ArrayList<String>>g, String symbole, String symbole2){
        if (Grid.anticipationNiv2(g,symbole,symbole2) > 0){
            int coor = Grid.anticipationNiv2(g,symbole,symbole2)+1;
            System.out.println(coor);
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)).equals("-") ){
                    if(!(g.get(li-1).get(coor-1)).equals("-")){
                        break;
                    }
                }
            }
    
            g.get(li).set(coor-1, symbole2);
            return g;
        } else if (Grid.anticipationNiv2(g,symbole2,symbole) > 0){
            int coor = Grid.anticipationNiv2(g,symbole2,symbole)+1;
            System.out.println(coor);
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)).equals("-") ){
                    if(!(g.get(li-1).get(coor-1)).equals("-")){
                        break;
                    }
                }
            }
    
            g.get(li).set(coor-1, symbole2);
            return g;
        } else {
            int coor = (int)(Math.random() * 7+1);
            int li;
            for(li = 5; li > 0 ; li -- ){
                if((g.get(li).get(coor-1)).equals("-")){
                    if(!(g.get(li-1).get(coor-1)).equals("-")){
                        break;
                    }
                }
                if(li == 0 || !g.get(li).contains("-")){
                    return IAmodifLV3(g,symbole,symbole2);
                }
            }
            g.get(li).set(coor-1, symbole2);
        }
        
        return g;

    }

}

