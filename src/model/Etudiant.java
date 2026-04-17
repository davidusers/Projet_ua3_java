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
        if (notes.isEmpty()) {
            return 0;
        }

        double somme = 0;
        for (double note : notes) {
            somme += note;
        }

        return somme / notes.size();
    }

    public double getMoyenne() {
        return calculerMoyenne();
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<Double> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Etudiant{id=" + id +
                ", nomComplet='" + getNomComplet() + '\'' +
                ", moyenne=" + String.format("%.2f", getMoyenne()) +
                '}';
    }
}