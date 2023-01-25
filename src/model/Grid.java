package model;
import java.util.Scanner;

import java.util.ArrayList;

public class Grid {

    private static Scanner _scan = new Scanner(System.in);
    
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
            System.out.println("|---------------------------|");
        }
    }
    
    public static ArrayList<ArrayList<String>> modif(ArrayList<ArrayList<String>> g, String message, String symbole){
        System.out.println(message);
        String err1 = "Veulliez entrer une colonne valide";
        String err2 = "Veuillez entrer un chiffre.\nPas une lettre ou un nombre.\nbozo";
        int coor = 0;
        boolean error = true;
        String choix = _scan.nextLine();

        while(error){
            try {
                String coorString = choix;
                coor = Integer.parseInt(coorString);
                error = false;
            } catch (NumberFormatException e) {
                return modif(g, err2, symbole);
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
                return modif(g, err1, symbole);
            }
        }
        
        if(coor < 1 || coor > 7) {
            System.out.println(err1);
            return modif(g, err1, symbole);
        }

        g.get(li).set(coor-1, symbole);
        return g;
    }


    public static ArrayList checkWin(ArrayList<ArrayList<String>> g, String symbole){
        ArrayList<ArrayList<Integer>> pozi_win = new ArrayList<ArrayList<Integer>>();
        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) == symbole && g.get(li).get(col+1) == symbole && g.get(li).get(col+2) == symbole && g.get(li).get(col+3) == symbole){
                    pozi_win.get(1).add(li,col);
                    pozi_win.get(2).add(li,col+1);
                    pozi_win.get(3).add(li,col+2);
                    pozi_win.get(4).add(li,col+3);
                    System.out.println(pozi_win);
                    return pozi_win;
                }
            }
        }
        // check vertical
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col) == symbole && g.get(li+1).get(col) == symbole && g.get(li+2).get(col) == symbole && g.get(li+3).get(col) == symbole){
                    pozi_win.get(1).add(li,col);
                    pozi_win.get(2).add(li+1,col);
                    pozi_win.get(3).add(li+2,col);
                    pozi_win.get(4).add(li+3,col);
                    System.out.println(pozi_win);
                    return pozi_win;
                }
            }
        }
        // check diagonal
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) == symbole && g.get(li+1).get(col+1) == symbole && g.get(li+2).get(col+2) == symbole && g.get(li+3).get(col+3) == symbole){
                    pozi_win.get(1).add(li,col);
                    pozi_win.get(2).add(li+1,col+1);
                    pozi_win.get(3).add(li+2,col+2);
                    pozi_win.get(4).add(li+3,col+3);
                    System.out.println(pozi_win);
                    return pozi_win;
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col) == symbole && g.get(li+1).get(col-1) == symbole && g.get(li+2).get(col-2) == symbole && g.get(li+3).get(col-3) == symbole){
                    return pozi_win;
                }
            }
        }
        return new ArrayList<>();
    }
}
