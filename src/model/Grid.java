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
    
    public static int anticipation(ArrayList<ArrayList<String>> g, String symbole, String symbole2){
        // check horizontal
        for (int li = 0; li < 6; li++) {
            for (int col = 0; col < 4; col++) {
                if (g.get(li).get(col) .equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2)){

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

                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col+1).equals(symbole) && g.get(li+2).get(col+2).equals(symbole)){
                        return col+3;
                    }
                }
            }
        }
        for (int li = 0; li < 3; li++) {
            for (int col = 3; col < 7; col++) {
                if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col-1).equals(symbole) && g.get(li+2).get(col-2).equals(symbole) && !g.get(li+3).get(col-3).equals(symbole2) ){

                    if (g.get(li).get(col).equals(symbole) && g.get(li+1).get(col-1).equals(symbole) && g.get(li+2).get(col-2).equals(symbole)){
                        return col-3;
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



    
    
    public static int anticipationNiv2(ArrayList<ArrayList<String>> g, String symbole, String symbole2) throws IndexOutOfBoundsException{
        // check horizontal
        for (int li = 0; li < 6; li++){
            for (int col = 0; col < 4; col++){
                
                if (li == 0){
                    if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2) && !g.get(li).get(col+3).equals("-")){
                        return col+3;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+2).equals(symbole2) && !g.get(li).get(col+2).equals("-")){
                        return col+2;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+2).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+1).equals(symbole2) && !g.get(li).get(col+1).equals("-")){
                        return col+1;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col-1).equals(symbole) && g.get(li).get(col-2).equals(symbole) && !g.get(li).get(col-3).equals(symbole2) && !g.get(li).get(col-3).equals("-")){
                        return col-3;
                    }
                    
                } else {
                    if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+2).equals(symbole) && !g.get(li).get(col+3).equals(symbole2) && !g.get(li-1).get(col+3).equals("-")){
                        return col+3;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+1).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+2).equals(symbole2) && !g.get(li-1).get(col+2).equals("-")){
                        return col+2;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col+2).equals(symbole) && g.get(li).get(col+3).equals(symbole) && !g.get(li).get(col+1).equals(symbole2) && !g.get(li-1).get(col+1).equals("-")){
                        return col+1;
                    } else if (g.get(li).get(col).equals(symbole) && g.get(li).get(col-1).equals(symbole) && g.get(li).get(col-2).equals(symbole) && !g.get(li).get(col-3).equals(symbole2) && !g.get(li).get(col-3).equals("-")){
                            return col-3;
                    }
                }
                }
            }
    
            // check vertical
    
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
    
            for (int li = 0; li < 3; li++) {
                for (int col = 3; col < 7; col++) {
                    if(li >= 4){
                        if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && !g.get(li-3).get(col+3).equals(symbole2) && !g.get(li-4).get(col+3).equals("-")){
                            return col+3;
                        } else if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-2).get(col+2).equals(symbole2) && !g.get(li-3).get(col+2).equals("-")){
                            return col+2;
                        } else if (g.get(li).get(col).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-1).get(col+1).equals(symbole2) && !g.get(li-2).get(col+1).equals("-")){
                            return col+1;
                        }
                    } else if(li == 3){
                        if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && !g.get(li-3).get(col+3).equals(symbole2)){
                            return col+3;
                        } else if (g.get(li).get(col).equals(symbole) && g.get(li-1).get(col+1).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-2).get(col+2).equals(symbole2) && !g.get(li-3).get(col+2).equals("-")){
                            return col+2;
                        } else if (g.get(li).get(col).equals(symbole) && g.get(li-2).get(col+2).equals(symbole) && g.get(li-3).get(col+3).equals(symbole) && !g.get(li-1).get(col+1).equals(symbole2) && !g.get(li-2).get(col+1).equals("-")){
                            return col+1;
                        }
                    } 
                }
            }
            return -1;
        
        
    }

    public static boolean checkWinIA(ArrayList<ArrayList<String>> g, String symboleIA, String symboleJoueur){
        if (anticipationNiv3(g, symboleIA, symboleJoueur)!= -1){
            return true;
        }
        else{
            return false;
        }
    }

    public static int anticipationNiv3(ArrayList<ArrayList<String>> g, String symboleIA, String symboleJoueur){
            // check horizontal
            for (int li = 0; li < 6; li++){
                for (int col = 0; col < 4; col++){
                    if (li == 0){
                        if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+1).equals(symboleIA) && g.get(li).get(col+2).equals(symboleIA) && !g.get(li).get(col+3).equals(symboleJoueur) && !g.get(li).get(col+3).equals("-")){
                            return col+3;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+1).equals(symboleIA) && g.get(li).get(col+3).equals(symboleIA) && !g.get(li).get(col+2).equals(symboleJoueur) && !g.get(li).get(col+2).equals("-")){
                            return col+2;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+2).equals(symboleIA) && g.get(li).get(col+3).equals(symboleIA) && !g.get(li).get(col+1).equals(symboleJoueur) && !g.get(li).get(col+1).equals("-")){
                            return col+1;
                        }
                    } else if (col < 3) {
                        if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+1).equals(symboleIA) && g.get(li).get(col+2).equals(symboleIA) && !g.get(li).get(col+3).equals(symboleJoueur) && !g.get(li-1).get(col+3).equals("-")){
                            return col+3;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+1).equals(symboleIA) && g.get(li).get(col+3).equals(symboleIA) && !g.get(li).get(col+2).equals(symboleJoueur) && !g.get(li-1).get(col+2).equals("-")){
                            return col+2;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+2).equals(symboleIA) && g.get(li).get(col+3).equals(symboleIA) && !g.get(li).get(col+1).equals(symboleJoueur) && !g.get(li-1).get(col+1).equals("-")){
                            return col+1;
                        }
                    } else {
                        if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+1).equals(symboleIA) && g.get(li).get(col+2).equals(symboleIA) && !g.get(li).get(col+3).equals(symboleJoueur) && !g.get(li-1).get(col+3).equals("-")){
                            return col+3;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+1).equals(symboleIA) && g.get(li).get(col+3).equals(symboleIA) && !g.get(li).get(col+2).equals(symboleJoueur) && !g.get(li-1).get(col+2).equals("-")){
                            return col+2;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col+2).equals(symboleIA) && g.get(li).get(col+3).equals(symboleIA) && !g.get(li).get(col+1).equals(symboleJoueur) && !g.get(li-1).get(col+1).equals("-")){
                            return col+1;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li).get(col-1).equals(symboleIA) && g.get(li).get(col-2).equals(symboleIA) && !g.get(li).get(col-3).equals(symboleJoueur) && !g.get(li-1).get(col-3).equals("-")){
                            return col-3;
                        }
                    }
                }
            }
    
            // check vertical
    
            for (int li = 0; li < 3; li++) {
                for (int col = 0; col < 7; col++) {
                    if (g.get(li).get(col).equals(symboleIA) && g.get(li+1).get(col).equals(symboleIA) && g.get(li+2).get(col).equals(symboleIA) && !g.get(li+3).get(col).equals(symboleJoueur)){
                        if (g.get(li).get(col).equals(symboleIA) && g.get(li+1).get(col).equals(symboleIA) && g.get(li+2).get(col).equals(symboleIA)){
                            return col;
                        }
                    }
                }
            }
            // check diagonal
    
            for (int li = 0; li < 3; li++) {
                for (int col = 0; col < 4; col++) {
                    if (g.get(li).get(col).equals(symboleIA) && g.get(li+1).get(col+1).equals(symboleIA) && g.get(li+2).get(col+2).equals(symboleIA) && !g.get(li+3).get(col+3).equals(symboleJoueur) && !g.get(li+2).get(col+3).equals("-")){
                        return col+3;
                    } else if (g.get(li).get(col).equals(symboleIA) && g.get(li+1).get(col+1).equals(symboleIA) && g.get(li+3).get(col+3).equals(symboleIA) && !g.get(li+2).get(col+2).equals(symboleJoueur) && !g.get(li+1).get(col+2).equals("-")){
                        return col+2;
                    } else if (g.get(li).get(col).equals(symboleIA) && g.get(li+2).get(col+2).equals(symboleIA) && g.get(li+3).get(col+3).equals(symboleIA) && !g.get(li+1).get(col+1).equals(symboleJoueur) && !g.get(li).get(col+1).equals("-")){
                        return col+1;
                    }
                }
            }
            // check anti-diagonal
    
            for (int li = 0; li < 3; li++) {
                for (int col = 3; col < 7; col++) {
                    if(li >= 4){
                        if (g.get(li).get(col).equals(symboleIA) && g.get(li-1).get(col+1).equals(symboleIA) && g.get(li-2).get(col+2).equals(symboleIA) && !g.get(li-3).get(col+3).equals(symboleJoueur) && !g.get(li-4).get(col+3).equals("-")){
                            return col+3;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li-1).get(col+1).equals(symboleIA) && g.get(li-3).get(col+3).equals(symboleIA) && !g.get(li-2).get(col+2).equals(symboleJoueur) && !g.get(li-3).get(col+2).equals("-")){
                            return col+2;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li-2).get(col+2).equals(symboleIA) && g.get(li-3).get(col+3).equals(symboleIA) && !g.get(li-1).get(col+1).equals(symboleJoueur) && !g.get(li-2).get(col+1).equals("-")){
                            return col+1;
                        }
                    } else if(li == 3){
                        if (g.get(li).get(col).equals(symboleIA) && g.get(li-1).get(col+1).equals(symboleIA) && g.get(li-2).get(col+2).equals(symboleIA) && !g.get(li-3).get(col+3).equals(symboleJoueur)){
                            return col+3;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li-1).get(col+1).equals(symboleIA) && g.get(li-3).get(col+3).equals(symboleIA) && !g.get(li-2).get(col+2).equals(symboleJoueur) && !g.get(li-3).get(col+2).equals("-")){
                            return col+2;
                        } else if (g.get(li).get(col).equals(symboleIA) && g.get(li-2).get(col+2).equals(symboleIA) && g.get(li-3).get(col+3).equals(symboleIA) && !g.get(li-1).get(col+1).equals(symboleJoueur) && !g.get(li-2).get(col+1).equals("-")){
                            return col+1;
                        }
                    } 
                }
            }
            return -1;    
        
    }
}
            