package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




public class Game {
    
    public static void startGame1P() throws IOException{
        boolean won = false;
        boolean turn = false;
        ArrayList<ArrayList<String>> g = Grid.createGrid();
        // compte le score des joueurs (nb de coup par joueurs)
        int J1t = 0;
        int JIAt = 0;

        System.out.println("Veuillez entrer votre nom: ");
        String nom1 = _scan.nextLine();
        Joueur J1 = new Joueur(Couleur.GREEN + nom1 + Couleur.DEFO, Couleur.GREEN, Couleur.GREEN + "@" + Couleur.DEFO);
        Joueur JIA = new Joueur(Couleur.RED + "IA" + Couleur.DEFO, Couleur.RED, Couleur.RED + "#" + Couleur.DEFO);

        // ça continue tant que personne n'a gagné
        while(!won){
            if(!turn){
                System.out.println();
                System.out.println();
                System.out.println(J1.getNom() + ", veuillez sélectionner une colonne: ");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J1.getSymbole());
                won = Grid.checkWin(g, J1.getSymbole());
                turn = true;
                J1t += 1;
                System.out.println();
            } else {
                // IA Turn
                System.out.println();
                System.out.println("Tour de l" + JIA.getNom() + ".");
                System.out.println();
                Grid.affichage(g);
                IA.IAmodif(g, JIA.getSymbole());
                won = Grid.checkWin(g, JIA.getSymbole());
                JIAt += 1;
                turn = false;
            }
        }

        if(won){
            String winner;
            int score;
            if(turn){
                score = J1t;
                winner = J1.getNom();
            } else {
                score = JIAt;
                winner = JIA.getNom();
            }
            Grid.affichage(g);
            System.out.println("Bien joué, " + winner + ", vous avez gagné en " + score + " coups !");
            enregistrer(winner, score);
        }
    }

    public static void changeColorsJ1(){
        System.out.println("Veuillez choisir une couleur: ");

        String choix = _scan.nextLine();
        switch (choix) {
            case "1":
                
                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
        
            default:
                break;
        }
    }

    public static void startGame2P(){
        boolean won = false;
        boolean turn = false;
        ArrayList<ArrayList<String>> g = Grid.createGrid();

        // compte le score des joueurs (nb de coup par joueurs)
        int J1t = 0;
        int J2t = 0;

        System.out.println("Veuillez entrer le nom du premier joueur: ");
        String nom1 = _scan.nextLine();
        Joueur J1 = new Joueur(Couleur.GREEN + nom1 + Couleur.DEFO, Couleur.GREEN, Couleur.GREEN + "@" + Couleur.DEFO);
        System.out.println("Veuillez entrer le nom du deuxième joueur: ");
        String nom2 = _scan.nextLine();
        Joueur J2 = new Joueur(Couleur.RED + nom2 + Couleur.DEFO, Couleur.RED, Couleur.RED + "#" + Couleur.DEFO);

        // ça continue tant que personne n'a gagné
        while(!won){
            if(!turn){
                System.out.println();
                System.out.println();
                System.out.println(J1.getNom() + ", veuillez sélectionner une colonne: ");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J1.getSymbole());
                won = Grid.checkWin(g, J1.getSymbole());
                turn = true;
                J1t += 1;
                System.out.println();
            } else {
                System.out.println();
                System.out.println();
                System.out.println(J2.getNom() + ", veuillez sélectionner une colonne: ");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J2.getSymbole());
                won = Grid.checkWin(g, J2.getSymbole());
                turn = false;
                J2t += 1;
                System.out.println();
            }
        }

        if(won){
            String winner;
            int score;
            if(turn){
                winner = J1.getNom();
                score = J1t;
            } else {
                winner = J2.getNom();
                score = J2t;
            }
            Grid.affichage(g);
            System.out.println("Bien joué, " + winner + ", vous avez gagné!");
        }
    }

    private static Scanner _scan = new Scanner(System.in);

    public static void enregistrer(String joueur, int score) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("P4_JAVA/src/top10.csv", true)));
        try {
            pw.println(joueur + ";" + score);
        }
        finally {
            pw.close();
        }
    }
}

