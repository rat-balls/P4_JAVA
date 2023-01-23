import model.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println();



        createGrid();



        System.out.println();
        System.out.println();
    }

    public static void createGrid(){
        ArrayList<ArrayList<String>> g = new ArrayList<ArrayList<String>>();
        ArrayList<String> column = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            column.add("\n+---+\n|   |\n+---+");
        }
        for (int j = 0; j < 6; j++) {
            g.add(column);
        }
        System.out.println(g);
        Plateau Pl = new Plateau(g, null);
    }
}
