package app;

import model.Etudiant;
import service.CSVReader;
import service.EtudiantService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Programme de Gestion des Étudiants ---");

        try {
            Map<Integer, Etudiant> etudiants =
                    CSVReader.lireCSV("data/etudiants.csv");

            List<Etudiant> etudiantsTries =
                    EtudiantService.trierParMoyenne(etudiants.values());

            EtudiantService.afficherDansTerminal(etudiantsTries);
            EtudiantService.sauvegarder(etudiantsTries, "data/resultats.csv");

            System.out.println("\nTraitement terminé.");
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
    }
}