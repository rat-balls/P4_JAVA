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




    // Lister =====================================================================================
    // ============================================================================================
    public static ArrayList<Score> lister() {
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