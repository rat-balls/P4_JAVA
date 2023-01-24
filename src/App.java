import model.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Grid grid = new Grid();
        System.out.println();
        System.out.println();
        ArrayList g = grid.createGrid();
        for(int iii = 0; iii < 6; iii++){
            grid.affichage(g);
            System.out.println();
            g = grid.modif( g, "Entrer le numéro de la colone");
            System.out.print(g);
            grid.affichage(g);
        }
        
    }

}
