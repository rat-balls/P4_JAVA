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
    public static ArrayList<ArrayList<String>> modif(ArrayList<ArrayList<String>> g, String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String err1 = "Entrer une colone valide";
        String err2 = "Entrer un chiffre.\nPas une lettre ou un nombre ";
        int coor = Integer.parseInt(sc.nextLine());
        int li = 0;
        while((g.get(li).get(coor-1)) != "-"){
            if(li == 6){
                return modif(g,err1);
            }
            li = li + 1;   
        }
        g.get(li).set(coor-1,"X");
        return g;
    }
}
