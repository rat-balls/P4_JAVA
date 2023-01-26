package model;
import java.util.ArrayList;
import java.util.Scanner;




public class Game {
    
    public static void startGame1P(Joueur J1, Joueur JIA){
        boolean won = false;
        boolean turn = false;
        String c1 = J1.getCouleur();
        String d = Couleur.DEFO;
        ArrayList<ArrayList<String>> g = Grid.createGrid();

        System.out.println("Veuillez entrer votre nom: ");
        String nom1 = _scan.nextLine();
        
        J1.setNom(c1 + nom1 + d);
        J1.setSymbole(c1 + "@" + d);

        JIA.setNom(Couleur.RED + "IA" + Couleur.DEFO);
        JIA.setSymbole(Couleur.RED + "#" + Couleur.DEFO);

        System.out.println("Choisissez le niveau de l'IA: ");
        System.out.println("[1] Facile");
        System.out.println("[2] Intermédiaire");
        System.out.println("[3] Moyen");
        String iaLV = _scan.nextLine();

        // ça continue tant que personne n'a gagné
        while(!won){
            if(!turn){
                System.out.println();
                System.out.println();
                System.out.println(J1.getNom() + ", veuillez sélectionner une colonne: ");
                System.out.println();
                Grid.affichage(g);
                Grid.modif(g, "", J1.getSymbole());
                won = Grid.checkWin(g, J1.getSymbole(), J1.getCouleur());
                turn = true;
                System.out.println();
            } else {
                // IA Turn
                System.out.println();
                System.out.println("Tour de l" + JIA.getNom() + ".");
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
            if(turn){
                winner = J1.getNom();
            } else {
                winner = JIA.getNom();
            }
            Grid.affichage(g);
            System.out.println("Bien joué, " + winner + ", vous avez gagné!");
        }
    }

    

    public static void startGame2P(Joueur J1, Joueur J2){
        boolean won = false;
        boolean turn = false;
        String c1 = J1.getCouleur();
        String c2 = J2.getCouleur();
        String d = Couleur.DEFO;
        ArrayList<ArrayList<String>> g = Grid.createGrid();

        // compte le score des joueurs (nb de coup par joueurs)
        int J1t = 0;
        int J2t = 0;

        System.out.println("Veuillez entrer le nom du premier joueur: ");
        String nom1 = _scan.nextLine();
        
        System.out.println("Veuillez entrer le nom du deuxième joueur: ");
        String nom2 = _scan.nextLine();

        J1.setNom(c1 + nom1 + d);
        J1.setSymbole(c1 + "@" + d);

        J2.setNom(c2 + nom2 + d);
        J2.setSymbole(c2 + "#" + d);

        // ça continue tant que personne n'a gagné
        while(!won){
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
            System.out.println("Bien joué, " + winner + ", vous avez gagné!");
        }
    }

    private static Scanner _scan = new Scanner(System.in);


}

