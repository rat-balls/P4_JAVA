package model;

import java.util.ArrayList;

public class Plateau {
    
    private ArrayList<ArrayList<Character>> Grille;
    private Pion Pion;

    public Plateau(ArrayList<ArrayList<Character>> grille, model.Pion pion) {
        Grille = grille;
        Pion = pion;
    }
    
    public ArrayList<ArrayList<Character>> getGrille() {
        return Grille;
    }
    public void setGrille(ArrayList<ArrayList<Character>> grille) {
        Grille = grille;
    }
    public Pion getPion() {
        return Pion;
    }
    public void setPion(Pion pion) {
        Pion = pion;
    }

    
}
