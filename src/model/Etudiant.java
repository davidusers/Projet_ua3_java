package model;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private List<Double> notes;

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(double note) {
        notes.add(note);
    }

    public double calculerMoyenne() {
        if (notes.isEmpty()) return 0;
        double somme = 0;
        for (double n : notes) somme += n;
        return somme / notes.size();
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    public double getMoyenne() {
        return calculerMoyenne();
    }
}
