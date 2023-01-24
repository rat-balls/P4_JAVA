package model;
import java.util.ArrayList;
import java.util.Scanner;




public class Game {
    
    public static void startGame1P(){
        boolean won = false;
        boolean turn = false;
        ArrayList<ArrayList<String>> g = Grid.createGrid();

        System.out.println("Veuillez entrer votre nom.");
        String nom1 = _scan.nextLine();
        Joueur J1 = new Joueur(nom1, 0, "@");
        Joueur JIA = new Joueur("IA", 0, "#");

        // ça continue tant que personne n'a gagné
        while(!won){
            if(!turn){
                System.out.println();
                System.out.println();
                System.out.println(J1.getNom() + ", veuillez sélectionner une colonne.");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J1.getSymbole());
                won = Grid.checkWin(g, J1.getSymbole());
                turn = true;
                System.out.println();
            } else {
                // IA Turn
                System.out.println();
                System.out.println("Tour de l'IA.");
                System.out.println();
                Grid.affichage(g);
                won = Grid.checkWin(g, JIA.getSymbole());
                turn = false;
                IA.IAmodif(g, JIA.getSymbole());
            }
        }
        if(won){
            String winner;
            if(turn){
                winner = J1.getNom();
            } else {
                winner = JIA.getNom();
            }
            Grid.affichage(g);
            System.out.println("Bien joué, " + winner + ", vous avez gagné!");
        }
    }

    public static void startGame2P(){
        boolean won = false;
        boolean turn = false;
        ArrayList<ArrayList<String>> g = Grid.createGrid();

        System.out.println("Veuillez entrer le nom du premier joueur.");
        String nom1 = _scan.nextLine();
        Joueur J1 = new Joueur(nom1, 0, "@");

        System.out.println("Veuillez entrer le nom du deuxième joueur.");
        String nom2 = _scan.nextLine();
        Joueur J2 = new Joueur(nom2, 0, "#");

        // ça continue tant que personne n'a gagné
        while(!won){
            if(!turn){
                System.out.println();
                System.out.println();
                System.out.println(J1.getNom() + ", veuillez sélectionner une colonne.");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J1.getSymbole());
                won = Grid.checkWin(g, J1.getSymbole());
                turn = true;
                System.out.println();
            } else {
                System.out.println();
                System.out.println();
                System.out.println(J2.getNom() + ", veuillez sélectionner une colonne.");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J2.getSymbole());
                won = Grid.checkWin(g, J2.getSymbole());
                turn = false;
                System.out.println();
            }
        }

        if(won){
            String winner;
            if(turn){
                winner = J1.getNom();
            } else {
                winner = J2.getNom();
            }
            Grid.affichage(g);
            System.out.println("Bien joué, " + winner + ", vous avez gagné!");
        }
    }

    private static Scanner _scan = new Scanner(System.in);


}

