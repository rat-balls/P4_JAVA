package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static boolean win = false;
    
    public static void startGame(){

        System.out.println();
        System.out.println();

        
        ArrayList<ArrayList<String>> g = Grid.createGrid();
        Grid.affichage(g);
        System.out.println();
        while (win == false){
            System.out.println();

            g = Grid.modif(g, "Joueur 1 : entrez une colonne",1);
            Grid.affichage(g);
            System.out.println();
            System.out.println();
            g = Grid.modif(g, "Joueur 2 : entrez une colonne",2);
            Grid.affichage(g);
            System.out.println();
        }

    }
    public static void startGameia(){

        System.out.println();
        System.out.println();

        
        ArrayList<ArrayList<String>> g = Grid.createGrid();
        Grid.affichage(g);
        System.out.println();
        while (win == false){
            System.out.println();

            g = Grid.modif(g, "Joueur 1 : entrez une colonne",1);
            Grid.affichage(g);
            System.out.println();
            System.out.println();
            g = IA.modifia(g,2);
            Grid.affichage(g);
            System.out.println();
        }

    }
    

    private static Scanner _scan = new Scanner(System.in);


}

