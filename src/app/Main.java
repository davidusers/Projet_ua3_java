package app;

import service.*;
import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Programme de Gestion des Étudiants ---");

        Map<Integer, Etudiant> etudiants =
            CSVReader.lireCSV("data/etudiants.csv");

        List<Etudiant> classes =
            EtudiantService.trierParMoyenne(etudiants.values());

        // ✅ Affichage dans le terminal
        EtudiantService.afficherDansTerminal(classes);

        // ✅ Sauvegarde dans un fichier
        EtudiantService.sauvegarder(classes, "data/resultats.csv");

        System.out.println("\nTraitement terminé.");
    }
}
