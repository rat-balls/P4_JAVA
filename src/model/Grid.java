package model;
import java.util.Scanner;

import java.util.ArrayList;

public class Grid {

    private static Scanner _scan = new Scanner(System.in);
    
    public static ArrayList<ArrayList<String>> createGrid(){
        ArrayList<ArrayList<String>> g = new ArrayList<ArrayList<String>>();
        for (int col = 0; col < 6; col++) {
            ArrayList<String> colonne = new ArrayList<>();
            for (int li = 0; li < 7; li++) {
                colonne.add("-");
            }
            g.add(colonne);
        }
        return g;
    }
    
    public static void affichage (ArrayList<ArrayList<String>> g){
        System.out.println("  1   2   3   4   5   6   7");
        for (int li = 5; li >= 0; li--) {
            for (int col = 0; col < 7; col++) {
                System.out.print("| " + g.get(li).get(col) + " ");
            }
            System.out.println("|");
            System.out.println("|---------------------------|");
        }
    }
    
    public static ArrayList<ArrayList<String>> modif(ArrayList<ArrayList<String>> g, String message, String symbole){
        System.out.println(message);
        String err1 = "Veuillez entrer une colonne valide.";
        String err2 = "Veuillez entrer un chiffre.\nPas une lettre ou un nombre.\nbozo";
        int coor = 0;
        boolean error = true;

        String choix = _scan.nextLine();

        while(error){
            try {
                String coorString = choix;
                coor = Integer.parseInt(coorString);
                error = false;
            } catch (NumberFormatException e) {
                return modif(g, err2, symbole);
            }
        }

        if(coor < 1 || coor > 7) {
            return modif(g, err1, symbole);
        }

        int li;

        if(!(g.get(5).get(coor-1)).equals("-")){
            return modif(g, err1, symbole);
        }
        
        for(li = 5; li > 0 ; li -- ){
            if((g.get(li).get(coor-1)).equals("-")){
                
                if(!(g.get(li-1).get(coor-1)).equals("-")){
                    break;
                }
            }
            if(li == 0 || !g.get(li).contains("-")){
                return modif(g, err1, symbole);
            }
        }

        g.get(li).set(coor-1, symbole);
        return g;
    }


    public static boolean checkWin(ArrayList<ArrayList<String>> g, String symbole, String couleur){
        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && g.get(li).get(col+3).equals(symbole)){
                    g.get(li).set(col, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li).set(col+1, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li).set(col+2, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li).set(col+3, symbole.replace(couleur, Couleur.YELLOW));
                    return true;
                }
            }
        }
        // check vertical
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col).equals(symbole) && g.get(li+2).get(col).equals(symbole) && g.get(li+3).get(col).equals(symbole)){
                    
                    g.get(li).set(col, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+1).set(col, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+2).set(col, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+3).set(col, symbole.replace(couleur, Couleur.YELLOW));
                    return true;
                }
            }
        }
        // check diagonal
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+2).get(col+2).equals(symbole) && g.get(li+3).get(col+3).equals(symbole)){
                    g.get(li).set(col, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+1).set(col+1, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+2).set(col+2, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+3).set(col+3, symbole.replace(couleur, Couleur.YELLOW));
                    return true;
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col-1).equals(symbole) && g.get(li+2).get(col-2).equals(symbole) && g.get(li+3).get(col-3).equals(symbole)){
                    g.get(li).set(col, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+1).set(col-1, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+2).set(col-2, symbole.replace(couleur, Couleur.YELLOW));
                    g.get(li+3).set(col-3, symbole.replace(couleur, Couleur.YELLOW));
                    return true;
                }
            }
        }
        return false;
    }
    // faire une fonction anticipation qui va regarder si l'autre joueur peut gagner au prochain coup et qui retourne seulement le nombre de la colone de la case à jouer pour l'empécher de gagner

    public static int anticipation(ArrayList<ArrayList<String>> g, String symbole, String symbole2){
        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) .equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2)){

                    System.out.println("horizontal");
                    if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole)){
                        return col+3;
                    }
                }
            }
        }
        // check vertical
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col).equals(symbole) && g.get(li+2).get(col).equals(symbole) && !g.get(li+3).get(col).equals(symbole2)){
                    System.out.println("vertical");

                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col).equals(symbole) && g.get(li+2).get(col).equals(symbole)){
                        return col;
                    }
                }
            }
        }
        // check diagonal
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+2).get(col+2).equals(symbole) && !g.get(li+3).get(col+3).equals(symbole2)){

                    System.out.println("diagonal");
                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+2).get(col+2).equals(symbole)){
                        return col+3;
                    }
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col-1).equals(symbole) && g.get(li+2).get(col-2).equals(symbole) && !g.get(li+3).get(col-3).equals(symbole2) ){

                    System.out.println("diagonal2");
                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col-1).equals(symbole) && g.get(li+2).get(col-2).equals(symbole)){
                        return col-3;
                    }
                }
            }
        }
        return -1;
    }

    public static int anticipationNiv2(ArrayList<ArrayList<String>> g, String symbole, String symbole2){
        // check horizontal
        System.out.println("check horizontal");
        for (int li = 0; li < 6; li++){
            for (int col = 0; col < 4; col++){
                if (li == 0){
                    if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2) && !g.get(li).get(col+3).equals("-")){
                        System.out.println("horz 1");
                        return col+3;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+2).equals(symbole2) && !g.get(li).get(col+2).equals("-")){
                        System.out.println("horz 2");
                        return col+2;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+2).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+1).equals(symbole2) && !g.get(li).get(col+1).equals("-")){
                        System.out.println("horz 3");
                        return col+1;
                    }
                } else if (col < 3) {
                    if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2) && !g.get(li-1).get(col+3).equals("-")){
                        System.out.println("horz 2 1");
                        return col+3;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+2).equals(symbole2) && !g.get(li-1).get(col+2).equals("-")){
                        System.out.println("horz 2 2");
                        return col+2;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+2).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+1).equals(symbole2) && !g.get(li-1).get(col+1).equals("-")){
                        System.out.println("horz 2 3");
                        return col+1;
                    }
                } else {
                    if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2) && !g.get(li-1).get(col+3).equals("-")){
                        System.out.println("horz 2 1");
                        return col+3;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+2).equals(symbole2) && !g.get(li-1).get(col+2).equals("-")){
                        System.out.println("horz 2 2");
                        return col+2;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+2).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+1).equals(symbole2) && !g.get(li-1).get(col+1).equals("-")){
                        System.out.println("horz 2 3");
                        return col+1;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col-1).equals(symbole) && g.get(li).get(col-2).equals(symbole) && !g.get(li).get(col-3).equals(symbole2) && !g.get(li-1).get(col-3).equals("-")){
                        System.out.println("horz 2 4");
                        return col-3;
                    }
                }
            }
        }

        // check vertical
        System.out.println("check vertical");

        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col).equals(symbole) && g.get(li+2).get(col).equals(symbole) && !g.get(li+3).get(col).equals(symbole2)){
                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col).equals(symbole) && g.get(li+2).get(col).equals(symbole)){
                        return col;
                    }
                }
            }
        }
        // check diagonal
        System.out.println("check diagonal");

        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+2).get(col+2).equals(symbole) && !g.get(li+3).get(col+3).equals(symbole2) && !g.get(li+2).get(col+3).equals("-")){
                    return col+3;
                } else if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+3).get(col+3).equals(symbole) && !g.get(li+2).get(col+2).equals(symbole2) && !g.get(li+1).get(col+2).equals("-")){
                    return col+2;
                } else if (g.get(li).get(col).equals(symbole) && g.get(li+2).get(col+2).equals(symbole) && g.get(li+3).get(col+3).equals(symbole) && !g.get(li+1).get(col+1).equals(symbole2) && !g.get(li).get(col+1).equals("-")){
                    return col+1;
                }
            }
        }
        // check anti-diagonal
        System.out.println("check anti-diagonal");

        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if(li >= 4){
                    if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && !g.get(li-3).get(col+3).equals(symbole2) && !g.get(li-4).get(col+3).equals("-")){
                        System.out.println("antidiag 1");
                        return col+3;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-2).get(col+2).equals(symbole2) && !g.get(li-3).get(col+2).equals("-")){
                        System.out.println("antidiag 2");
                        return col+2;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-1).get(col+1).equals(symbole2) && !g.get(li-2).get(col+1).equals("-")){
                        System.out.println("antidiag 3");
                        return col+1;
                    }
                } else if(li == 3){
                    if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && !g.get(li-3).get(col+3).equals(symbole2)){
                        System.out.println("antidiag 1");
                        return col+3;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-2).get(col+2).equals(symbole2) && !g.get(li-3).get(col+2).equals("-")){
                        System.out.println("antidiag 2");
                        return col+2;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-1).get(col+1).equals(symbole2) && !g.get(li-2).get(col+1).equals("-")){
                        System.out.println("antidiag 3");
                        return col+1;
                    }
                } 
            }
        }
        return -1;    
    }

    public static boolean checkWinIA(ArrayList<ArrayList<String>> g, String symboleIA){
        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) .equals(symboleIA) && g.get(li).get(col+1).equals(symboleIA) && g.get(li).get(col+2).equals(symboleIA) && g.get(li).get(col+3).equals(symboleIA)){
                    return true;
                }
            }
        }
        // check vertical
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 7; col++) {
                if (g.get(li).get(col).equals(symboleIA) && g.get(li+1).get(col).equals(symboleIA) && g.get(li+2).get(col).equals(symboleIA) && g.get(li+3).get(col).equals(symboleIA)){
                    return true;
                }
            }
        }
        // check diagonal
        for (int li = 0; li < 3; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col).equals(symboleIA) && g.get(li+1).get(col+1).equals(symboleIA) && g.get(li+2).get(col+2).equals(symboleIA) && g.get(li+3).get(col+3).equals(symboleIA)){
                    return true;
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col).equals(symboleIA) && g.get(li+1).get(col-1).equals(symboleIA) && g.get(li+2).get(col-2).equals(symboleIA) && g.get(li+3).get(col-3).equals(symboleIA)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean matchnul (ArrayList<ArrayList<String>> g){
        boolean endgame = true;
        for (int col = 0; col < 7; col++) {
            if(g.get(5).get(col).equals("-")){
                endgame = false;
            }    
        }
        return endgame;
    }
}
            