package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




public class Game {

    public static void afficherMenuIA() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("\n-- Choisir le niveau de l'IA --");
        menus.add("[1] Facile");
        menus.add("[2] Moyen");
        menus.add("[3] Difficile");
        menus.add("[4] Impossible");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }
    
    public static void startGame1P(Joueur J1, Joueur JIA) throws IOException, InterruptedException{
        boolean won = false;
        boolean turn = false;
        boolean endgame = false;
        String iaLV;
        String c1 = J1.getCouleur();
        String d = Couleur.DEFO;
        ArrayList<ArrayList<String>> g = Grid.createGrid();
        // compte le score des joueurs (nb de coup par joueurs)
        int J1t = 0;
        int JIAt = 0;

        while(true){
            afficherMenuIA();
            iaLV = _scan.nextLine();
            switch (iaLV) {
                case "1":
                case "2":
                case "3":
                case "4":
                    break;
                default:
                    System.out.println("Veuillez entrer un chiffre entre 1 et 4.");
                    continue;
            }
            break;
        }
        

        System.out.println("\nVeuillez entrer votre nom: ");
        String nom1 = _scan.nextLine();


        J1.setNom(c1 + nom1 + d);
        J1.setSymbole(c1 + "@" + d);

        JIA.setNom(Couleur.RED + "IA" + Couleur.DEFO);
        JIA.setSymbole(Couleur.RED + "#" + Couleur.DEFO);

        // ça continue tant que personne n'a gagné
        while(!won){
            if(Grid.matchnul(g)){
                endgame = true;
                break;
            }
            if(!turn){
                System.out.println();
                System.out.println();
                System.out.println(J1.getNom() + ", veuillez sélectionner une colonne: ");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J1.getSymbole());
                won = Grid.checkWin(g, J1.getSymbole(), J1.getCouleur());
                turn = true;
                J1t += 1;
                System.out.println();
            } else {
                // IA Turn
                System.out.println();
                Grid.affichage(g);
                System.out.println("Tour de l'" + JIA.getNom() + ".");
                System.out.println();
                Grid.affichage(g);
                if(iaLV.equals("1")){
                    IA.IAmodif(g, JIA.getSymbole());
                } else if(iaLV.equals("2")){
                    IA.IAmodifLV2(g, J1.getSymbole(), JIA.getSymbole());
                } else if (iaLV.equals("3")){
                    IA.IAmodifLV3(g, J1.getSymbole(), JIA.getSymbole());
                }
                won = Grid.checkWin(g, JIA.getSymbole(), JIA.getCouleur());
                turn = false;
            }
        }

        if(won){
            String winner;
            String nomASave;
            int score;
            if(turn){
                score = J1t;
                winner = J1.getNom();
                nomASave = nom1;
                enregistrer(nomASave, score);
            } else {
                score = JIAt;
                winner = JIA.getNom();
            }
            Grid.affichage(g);
            System.out.println("Bien joué, " + winner + ", vous avez gagné en " + score + " coups !");
        }

        if(endgame){
            Grid.affichage(g);
            System.out.println("Match nul, personne n'a gagné. \ntro nul");
        }
    }

    

    public static void startGame2P(Joueur J1, Joueur J2){
        boolean won = false;
        boolean turn = false;
        boolean endgame = false;
        String c1 = J1.getCouleur();
        String c2 = J2.getCouleur();
        String d = Couleur.DEFO;
        ArrayList<ArrayList<String>> g = Grid.createGrid();

        // compte le score des joueurs (nb de coup par joueurs)
        int J1t = 0;
        int J2t = 0;

        System.out.println("\nVeuillez entrer le nom du Joueur 1: ");
        String nom1 = _scan.nextLine();
        
        System.out.println("\nVeuillez entrer le nom du Joueur 2: ");
        String nom2 = _scan.nextLine();

        J1.setNom(c1 + nom1 + d);
        J1.setSymbole(c1 + "@" + d);

        J2.setNom(c2 + nom2 + d);
        J2.setSymbole(c2 + "#" + d);

        // ça continue tant que personne n'a gagné
        while(!won){
            if(!turn){
                if(Grid.matchnul(g)){
                    endgame = true;
                    break;
                }
                System.out.println();
                System.out.println();
                System.out.println(J1.getNom() + ", veuillez sélectionner une colonne: ");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J1.getSymbole());
                won = Grid.checkWin(g, J1.getSymbole(), J1.getCouleur());
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
                won = Grid.checkWin(g, J2.getSymbole(), J2.getCouleur());
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
            System.out.println("\nBien joué, " + winner + ", vous avez gagné en " + score + " coups !");
        }

        if(endgame){
            Grid.affichage(g);
            System.out.println("\nMatch nul, personne n'a gagné. (tro nul)");
        }
    }

    private static Scanner _scan = new Scanner(System.in);

    public static void enregistrer(String joueur, int score) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/top10.csv", true)));
        try {
            pw.println(joueur + ";" + score);
        }
        finally {
            pw.close();
        }
    }
}

