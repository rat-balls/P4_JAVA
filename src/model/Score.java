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
    public static ArrayList<Score> creerListe() {
        ArrayList<Score> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/top10.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                Score score = new Score();
                Joueur joueur = new Joueur(line, null, null);
                joueur.setNom(data[0]);
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

    public static ArrayList<Score> listeOrdre() {
        ArrayList<Score> list = creerListe();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getScore() > list.get(j).getScore()) {
                    Score temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}