package model;
import java.util.Scanner;

import javax.xml.transform.Source;

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

    public static boolean checkWin(ArrayList<ArrayList<String>> g, int joueur){
        String joueurString = "";
        if (joueur == 1){
            joueurString = "X";
        }
        else if (joueur == 2){
            joueurString = "O";
        }
        else{
            return false;
        }
        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) .equals(joueurString) && g.get(li).get(col+1) .equals(joueurString) && g.get(li).get(col+2).equals(joueurString) && g.get(li).get(col+3).equals(joueurString)){
                    return true;
                }
            }
        }
        // check vertical
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col).equals(joueurString) && g.get(li+1).get(col).equals(joueurString) && g.get(li+2).get(col).equals(joueurString) && g.get(li+3).get(col).equals(joueurString)){
                    return true;
                }
            }
        }
        // check diagonal
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col).equals(joueurString) && g.get(li+1).get(col+1).equals(joueurString) && g.get(li+2).get(col+2).equals(joueurString) && g.get(li+3).get(col+3).equals(joueurString)){
                    return true;
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col).equals(joueurString) && g.get(li+1).get(col-1).equals(joueurString) && g.get(li+2).get(col-2).equals(joueurString) && g.get(li+3).get(col-3).equals(joueurString)){
                    return true;
                }
            }
        }
        return false;
    }
    // faire une fonction anticipation qui va regarder si l'autre joueur peut gagner au prochain coup et qui retourne seulement le nombre de la colone de la case à jouer pour l'empécher de gagner

    public static int anticipation(ArrayList<ArrayList<String>> g, String symbole, String symbole2){
        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) .equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2)){

                    System.out.println("horizontal");
                    if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole)){
                        return col+3;
                    }
                }
            }
        }
        // check vertical
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col).equals(symbole) && g.get(li+2).get(col).equals(symbole) && !g.get(li+3).get(col).equals(symbole2)){
                    System.out.println("vertical");

                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col).equals(symbole) && g.get(li+2).get(col).equals(symbole)){
                        return col;
                    }
                }
            }
        }
        // check diagonal
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+2).get(col+2).equals(symbole) && !g.get(li+3).get(col+3).equals(symbole2)){

                    System.out.println("diagonal");
                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+2).get(col+2).equals(symbole)){
                        return col+3;
                    }
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col-1).equals(symbole) && g.get(li+2).get(col-2).equals(symbole) && !g.get(li+3).get(col-3).equals(symbole2) ){

                    System.out.println("diagonal2");
                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col-1).equals(symbole) && g.get(li+2).get(col-2).equals(symbole)){
                        return col-3;
                    }
                }
            }
        }
        return -1;
        
    }
}
            