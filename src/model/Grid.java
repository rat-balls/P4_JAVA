package model;
import java.util.Scanner;

import java.util.ArrayList;

public class Grid {
    
    public static ArrayList<ArrayList<String>> createGrid(){
        ArrayList<ArrayList<String>> g = new ArrayList<ArrayList<String>>();
        for (int col = 0; col < 6; col++) {
            ArrayList<String> colonne = new ArrayList<>();
            for (int li = 0; li < 7; li++) {
                colonne.add("-");
            }
            g.add(colonne);
        }
        return g;
    }
    
    public static void affichage (ArrayList<ArrayList<String>> g){
        System.out.println("  1   2   3   4   5   6   7");
        for (int li = 5; li >= 0; li--) {
            for (int col = 0; col < 7; col++) {
                System.out.print("| " + g.get(li).get(col) + " ");
            }
            System.out.println("|");
            System.out.println("-----------------------------");
        }
    }
    public static ArrayList<ArrayList<String>> modif(ArrayList<ArrayList<String>> g, String message, String symbole, String choix){
        System.out.println(message);
        String err1 = "Entrer une colone valide";
        String err2 = "Entrer un chiffre.\nPas une lettre ou un nombre ";
        int coor = 0;
        boolean error = true;

        while(error){
            try {
                String coorString = choix;
                coor = Integer.parseInt(coorString);
                error = false;
            } catch (NumberFormatException e) {
                return modif(g, err2, symbole, choix);
            }
        }

        int li;
        
        for(li = 5; li > 0 ; li -- ){
            if((g.get(li).get(coor-1)) == "-" ){
                if((g.get(li-1).get(coor-1)) != "-"){
                    break;
                }
            }
            if(li == 0 || !g.get(li).contains("-")){
                return modif(g, err1, symbole, choix);
            }
        }
        
        if(coor < 1 || coor > 7) {
            System.out.println(err1);
            return modif(g, err1, symbole, choix);
        }

        g.get(li).set(coor-1,"X");
        
        return g;
    }
}
