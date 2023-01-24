package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    
    public static void startGame(){
        System.out.println();
        System.out.println();

        
        ArrayList<ArrayList<String>> g = Grid.createGrid();
        Grid.affichage(g);
        System.out.println();
        System.out.println();
    }

    private static Scanner _scan = new Scanner(System.in);


}

