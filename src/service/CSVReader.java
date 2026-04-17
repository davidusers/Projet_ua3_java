package service;

import model.Etudiant;
import java.io.*;
import java.util.*;

public class CSVReader {
    public static Map<Integer, Etudiant> lireCSV(String fichier) {
        Map<Integer, Etudiant> etudiants = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            br.readLine();
            while ((ligne = br.readLine()) != null) {
                String[] d = ligne.split(",");
                int id = Integer.parseInt(d[0]);
                String nom = d[1];
                String prenom = d[2];
                double note = Double.parseDouble(d[4]);
                etudiants.putIfAbsent(id, new Etudiant(id, nom, prenom));
                etudiants.get(id).ajouterNote(note);
            }
        } catch (Exception e) {
            System.err.println("Erreur CSV : " + e.getMessage());
        }
        return etudiants;
    }
}
