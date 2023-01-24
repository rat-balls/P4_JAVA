import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class App {
    Joueur joueur = new Joueur();
    Score score = new Score();
    // Main =======================================================================================
    // ============================================================================================
    public static void main(String[] args) throws Exception {
        while(true) {
            afficherMenu();
            String choix = _scan.nextLine();
            switch(choix) {
                case "1":
                    jouer();
                    break;
                case "2":
                    parametres();
                    break;
                case "3":
                    System.out.println("Quitter");
                    return;
                default:
                    System.out.println("Aucune option correspondante. Veuillez réessayer.");
                    break;
            }
        }
    }
    // ============================================================================================
    // ============================================================================================




    // Affiche le menu principal ==================================================================
    // ============================================================================================
    public static void afficherMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("\n-- MENU PUISSANCE 4 --");
        menus.add("[1] Jouer");
        menus.add("[2] Paramètres");
        menus.add("[3] Quitter");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }
    // ============================================================================================
    // ============================================================================================




    // Menus pour Jouer ===========================================================================
    // ============================================================================================
    public static void afficherMenuJeu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("\n-- MENU JEU --");
        menus.add("[1] Joueur contre Ordinateur");
        menus.add("[2] Joueur contre Joueur");
        menus.add("[3] Retour");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }


    public static void jouer() {
        afficherMenuJeu();
        String choix = _scan.nextLine();
        switch(choix) {
            case "1":
                System.out.println("Jouer contre l'Ordi");
                break;
            case "2":
                System.out.println("Jouer contre un ami");
                break;
            case "3":
                System.out.println("Quitter");
                return;
            default:
                System.out.println("Aucune option correspondante. Veuillez réessayer.");
                break;
        }
    }
    // ============================================================================================
    // ============================================================================================



    // Menus des paramètres =======================================================================
    // ============================================================================================
    public static void afficherMenuParam() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("\n-- MENU PARAMETRES --");
        menus.add("[1] Régler la couleur des pions");
        menus.add("[2] Top 10 des meilleurs scores");
        menus.add("[3] Retour");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }


    public static void parametres() {
        afficherMenuParam();
        String choix = _scan.nextLine();
        switch(choix) {
            case "1":
                System.out.println("Régler la couleur des pions");
                break;
            case "2":
                afficherListe();
                break;
            case "3":
                System.out.println("Retour");
                return;
            default:
                System.out.println("Aucune option correspondante. Veuillez réessayer.");
                break;
        }
    }
    // ============================================================================================
    // ============================================================================================




    // Scanner ====================================================================================
    // ============================================================================================
    private static Scanner _scan = new Scanner(System.in);
    // ============================================================================================
    // ============================================================================================




    // Override ===================================================================================
    // ============================================================================================
    @Override
    public String toString() {
        return joueur.getNom() + " : " + score;
    }
    // ============================================================================================
    // ============================================================================================


    // Lister =====================================================================================
    // ============================================================================================
    private static void afficherListe() {
        ArrayList<Score> list = Score.listeOrdre();
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1) + " - " + list.get(i).getJoueur() + " : " + list.get(i).getScore());
        }
    }
    // ============================================================================================
    // ============================================================================================
}