import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Score;
import model.Joueur;
import model.Couleur;
import model.Game;

public class App {
    Joueur joueur = new Joueur(null, null, null);
    Score score = new Score();
    public static Joueur J1 = new Joueur(null, Couleur.DEFO, null);
    public static Joueur J2 = new Joueur(null, Couleur.DEFO, null);
    public static Joueur JIA = new Joueur("IA", Couleur.DEFO, null);
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


    public static void jouer() throws IOException {
        afficherMenuJeu();
        String choix = _scan.nextLine();
        switch(choix) {
            case "1":
                System.out.println("Jouer contre l'Ordi");
                Game.startGame1P(J1, JIA);
                break;
            case "2":
                System.out.println("Jouer contre un ami");
                Game.startGame2P(J1, J2);
                break;
            case "3":
                System.out.println("Quitter");
                return;
            default:
                System.out.println("Aucune option correspondante. Veuillez réessayer.");
                break;
        }
    }


    public static void afficherMenuIA() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("\n-- MENU CONTRE IA --");
        menus.add("[1] IA de niveau 1");
        menus.add("[2] IA de niveau 2");
        menus.add("[3] IA de niveau 3");
        menus.add("[4] IA de niveau 4");
        menus.add("[5] Retour");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void versusIA() {
        afficherMenuIA();
        String choix = _scan.nextLine();
        switch(choix) {
            case "1":
                System.out.println("IA de niveau 1");
                break;
            case "2":
                System.out.println("IA de niveau 2");
                break;
            case "3":
                System.out.println("IA de niveau 3");
                return;
            case "4":
                System.out.println("IA de niveau 4");
                break;
            case "5":
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
        menus.add("[1] Régler la couleur des pions du J1");
        menus.add("[2] Régler la couleur des pions du J2");
        menus.add("[3] Top 10 des meilleurs scores");
        menus.add("[4] Retour");
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
                Couleur.changeColors(J1);
                break;
            case "2":
                System.out.println("Régler la couleur des pions");
                Couleur.changeColors(J2);
                break;
            case "3":
                afficherListe();
                break;
            case "4":
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
        if (list.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + " - " + list.get(i).getJoueur().getNom() + " : " + list.get(i).getScore());
            }
        }
    }
    // ============================================================================================
    // ============================================================================================
}