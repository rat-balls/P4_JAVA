package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    
    public static void startGame1P(){
        boolean won = false;
        ArrayList<ArrayList<String>> g = Grid.createGrid();

        // ça continue tant que personne n'a gagné
        while(!won){
            System.out.println();
            System.out.println();
            Grid.affichage(g);
            Grid.modif(g, "", "!", "!");
            System.out.println();
            System.out.println();
        }
    }

    public static void startGame2P(){
        boolean won = false;
        ArrayList<ArrayList<String>> g = Grid.createGrid();
        System.out.println("Veuillez entrez le nom du premier joueur.");
        String nom1 = _scan.nextLine();
        Joueur J1 = new Joueur(nom1, 0, "@");
        String nom2 = _scan.nextLine();
        Joueur J2 = new Joueur(nom2, 0, "#");
        // ça continue tant que personne n'a gagné
        while(!won){
            System.out.println();
            System.out.println();
            Grid.affichage(g);
            System.out.println(J1.getNom() + " , veuillez sélectionner une colonne.");
            String choix = _scan.nextLine();
            Grid.modif(g, "", J1.getSymbole(), choix);
            System.out.println();
            System.out.println();
        }
    }

    private static Scanner _scan = new Scanner(System.in);


}

