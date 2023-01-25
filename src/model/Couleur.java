package model;

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

    public static void changeColors(Joueur J){
        System.out.println("Veuillez choisir une couleur: ");
        System.out.println("[0] DEFAULT");
        System.out.println("[1] RED");
        System.out.println("[2] GREEN");
        System.out.println("[3] YELLOW");
        System.out.println("[4] BLUE");
        System.out.println("[5] PURPLE");
        System.out.println("[6] CYAN");
        System.out.println("[7] LIGHT RED");
        System.out.println("[8] LIGHT PURPLE");
        String choix = _scan.nextLine();
        switch (choix) {
            case "0":
                J.setCouleur(Couleur.DEFO);
                break;
            case "1":
                J.setCouleur(Couleur.RED);
                break;
            case "2":
                J.setCouleur(Couleur.GREEN);
                break;
            case "3":
                J.setCouleur(Couleur.YELLOW);
                break;
            case "4":
                J.setCouleur(Couleur.BLUE);
                break;
            case "5":
                J.setCouleur(Couleur.PURPLE);
                break;
            case "6":
                J.setCouleur(Couleur.CYAN);
                break;
            case "7":
                J.setCouleur(Couleur.LRED);
                break;
            case "8":
                J.setCouleur(Couleur.LPURPLE);
                break;
            default:
                break;
        }
    }

    private static Scanner _scan = new Scanner(System.in);

}
