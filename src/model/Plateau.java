package model;

import java.util.ArrayList;

public class Plateau {
    
    private ArrayList<ArrayList> Grille;
    private Pion Pion;

    public Plateau(ArrayList<ArrayList> grille, model.Pion pion) {
        Grille = grille;
        Pion = pion;
    }
    
    public ArrayList<ArrayList> getGrille() {
        return Grille;
    }
    public void setGrille(ArrayList<ArrayList> grille) {
        Grille = grille;
    }
    public Pion getPion() {
        return Pion;
    }
    public void setPion(Pion pion) {
        Pion = pion;
    }

    
}
