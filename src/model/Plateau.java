package model;

import java.util.ArrayList;

public class Plateau {
    
    private ArrayList<ArrayList<String>> Grille;
    private Pion Pion;

    public Plateau(ArrayList<ArrayList<String>> grille, model.Pion pion) {
        Grille = grille;
        Pion = pion;
    }
    
    public ArrayList<ArrayList<String>> getGrille() {
        return Grille;
    }
    public void setGrille(ArrayList<ArrayList<String>> grille) {
        Grille = grille;
    }
    public Pion getPion() {
        return Pion;
    }
    public void setPion(Pion pion) {
        Pion = pion;
    }

    
}
