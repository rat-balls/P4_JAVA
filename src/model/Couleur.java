package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Couleur {
    public static final String DEFO = "\033[0m"; // Text Reset
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String LRED = "\033[1;31m";
    public static final String LPURPLE = "\033[1;35m";

    public static void afficherCouleurs() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("-- MENU COULEURS --");
        menus.add("[0] Couleur par défaut");
        menus.add("[1] Rouge");
        menus.add("[2] Vert");
        menus.add("[3] Jaune");
        menus.add("[4] Bleu");
        menus.add("[5] Violet");
        menus.add("[6] Cyan");
        menus.add("[7] Rouge Clair");
        menus.add("[8] Violet Clair");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void afficherSymboles() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("-- MENU SYMBOLES --");
        menus.add("[1] J1, J2 = @, # ");
        menus.add("[2] J1, J2 = O, X");
        menus.add("[3] J1, J2 = !, ?");
        menus.add("[4] J1, J2 = :D, :C (mauvaise idée)");
        for (String menu : menus) {
            System.out.println(menu);
        }
    }

    public static void changeSymbols(Joueur J1, Joueur J2, Joueur JIA){
        while(true){
            afficherSymboles();
            String choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("@ et # sélectionnés");
                    J1.setSymbole("@");
                    J2.setSymbole("#");
                    JIA.setSymbole("#");
                    break;
                case "2":
                    System.out.println("O et X sélectionnés");
                    J1.setSymbole("O");
                    J2.setSymbole("X");
                    JIA.setSymbole("X");
                    break;
                case "3":
                    System.out.println("! et ? sélectionnés");
                    J1.setSymbole("!");
                    J2.setSymbole("?");
                    JIA.setSymbole("?");
                    break;
                case "4":
                    System.out.println(":D et :C sélectionnés");
                    J1.setSymbole(":D");
                    J2.setSymbole(":C");
                    JIA.setSymbole(":C");
                    break;
                default:
                    System.out.println("\nVeuillez entrer une option valide.");
                    continue;
            }
            break;
        }
    }

    public static void changeColors(Joueur J){
        afficherCouleurs();
        String choix = _scan.nextLine();
        switch (choix) {
            case "0":
                System.out.println("Couleur par défaut sélectionnée");
                J.setCouleur(Couleur.DEFO);
                break;
            case "1":
                System.out.println("Rouge sélectionné");
                J.setCouleur(Couleur.RED);
                break;
            case "2":
                System.out.println("Vert sélectionné");
                J.setCouleur(Couleur.GREEN);
                break;
            case "3":
                System.out.println("Jaune sélectionné");
                J.setCouleur(Couleur.YELLOW);
                break;
            case "4":
                System.out.println("Bleu sélectionné");
                J.setCouleur(Couleur.BLUE);
                break;
            case "5":
                System.out.println("Violet sélectionné");
                J.setCouleur(Couleur.PURPLE);
                break;
            case "6":
                System.out.println("Cyan sélectionné");
                J.setCouleur(Couleur.CYAN);
                break;
            case "7":
                System.out.println("Rouge Clair sélectionné");
                J.setCouleur(Couleur.LRED);
                break;
            case "8":
                System.out.println("Violet Clair sélectionné");
                J.setCouleur(Couleur.LPURPLE);
                break;
            default:
                break;
        }
    }

    private static Scanner _scan = new Scanner(System.in);

}
