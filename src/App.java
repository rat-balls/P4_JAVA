import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        while(true) {
            afficherMenu();
            String choix = _scan.nextLine();
            switch(choix) {
                case "1":
                    jouer();
                    break;
                case "2":
                    System.out.println("Paramètres");
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


    // Affiche le menu ====================
    // ====================================
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
    // ====================================
    // ====================================


    // Lance le menu Jouer ================
    // ====================================
    public static void jouer() {
        System.out.println("[1] Contre l'Ordi\n[2] Contre un ami\n[3] Retour");
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
    // ====================================
    // ====================================

    private static Scanner _scan = new Scanner(System.in);
}