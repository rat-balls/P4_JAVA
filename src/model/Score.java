package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Score {
    private int score;
    private Joueur joueur;

    public Score() {
    }

    // Score =======================================================================================
    // ============================================================================================
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    // ============================================================================================
    // ============================================================================================




    // Joueur =====================================================================================
    // ============================================================================================
    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    // ============================================================================================
    // ============================================================================================

    
    


    // Override ===================================================================================
    // ============================================================================================
    @Override
    public String toString() {
        return joueur.getNom() + " : " + score;
    }
    // ============================================================================================
    // ============================================================================================




    // Override ===================================================================================
    // ============================================================================================
    @Override
    public String toString() {
        return joueur.getNom() + " : " + score;
    }
    // ============================================================================================
    // ============================================================================================




    // Lister =====================================================================================
    // ============================================================================================
    public static ArrayList<Score> creerListe() {
        ArrayList<Score> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("P4_JAVA/src/top10.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                Score score = new Score();
                score.setScore(Integer.parseInt(data[0]));
                Joueur joueur = new Joueur();
                joueur.setNom(data[1]);
                score.setJoueur(joueur);
                score.setScore(Integer.valueOf(data[1]));
                list.add(score);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}