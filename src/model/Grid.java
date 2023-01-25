package model;
import java.util.Scanner;

import java.util.ArrayList;

public class Grid {
    
    public static ArrayList createGrid(){
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
    public static ArrayList<ArrayList<String>> modif(ArrayList<ArrayList<String>> g, String message,int joueur){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String err1 = "Entrer une colone valide";
        String err2 = "Entrer un chiffre.\nPas une lettre ou un nombre ";
        int coor = 0;
        
        boolean error = true;
        while(error){
            try {
                String coorString = sc.nextLine();
                coor = Integer.parseInt(coorString);
                error = false;
            } catch (NumberFormatException e) {
                return modif(g,err2,1);
            }
        }
        int li = 0;
        if (joueur==1){
            while((g.get(li).get(coor-1)) != "-"){
                if(li == 6){
                    return modif(g,err1,1);
                }
                li = li + 1;   
            }
            g.get(li).set(coor-1,"X");
            return g;
        }
        else if (joueur==2){
            while((g.get(li).get(coor-1)) != "-"){
                if(li == 6){
                    return modif(g,err1,2);
                }
                li = li + 1;   
            }
            g.get(li).set(coor-1,"O");
            return g;
        }
        else{
            return modif(g,err2,0);
        }
    
    }


    public static ArrayList checkWin(ArrayList<ArrayList<String>> g, String symbole){
        ArrayList pozi_win = new ArrayList();

        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) == symbole && g.get(li).get(col+1) == symbole && g.get(li).get(col+2) == symbole && g.get(li).get(col+3) == symbole){
                    pozi_win.add(g.get(li).get(col));
                    pozi_win.add(g.get(li).get(col+1));
                    pozi_win.add(g.get(li).get(col+2));
                    pozi_win.add(g.get(li).get(col+3));
                    return pozi_win;
                }
            }
        }
        // check vertical
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col) == symbole && g.get(li+1).get(col) == symbole && g.get(li+2).get(col) == symbole && g.get(li+3).get(col) == symbole){
                    pozi_win.add(g.get(li).get(col));
                    pozi_win.add(g.get(li+1).get(col));
                    pozi_win.add(g.get(li+2).get(col));
                    pozi_win.add(g.get(li+3).get(col));
                    return pozi_win;
                }
            }
        }
        // check diagonal
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) == symbole && g.get(li+1).get(col+1) == symbole && g.get(li+2).get(col+2) == symbole && g.get(li+3).get(col+3) == symbole){
                    pozi_win.add(g.get(li).get(col));
                    pozi_win.add(g.get(li+1).get(col+1));
                    pozi_win.add(g.get(li+2).get(col+2));
                    pozi_win.add(g.get(li+3).get(col+3));
                    return pozi_win;
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col) == symbole && g.get(li+1).get(col-1) == symbole && g.get(li+2).get(col-2) == symbole && g.get(li+3).get(col-3) == symbole){
                    pozi_win.add(g.get(li).get(col));
                    pozi_win.add(g.get(li+1).get(col+1));
                    pozi_win.add(g.get(li+2).get(col+2));
                    pozi_win.add(g.get(li+3).get(col+3));
                    return pozi_win;
                }
            }
        }
        return new ArrayList<>();
    }
}
