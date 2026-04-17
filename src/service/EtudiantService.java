package service;

import model.Etudiant;
import java.io.FileWriter;
import java.util.*;

public class EtudiantService {

    public static List<Etudiant> trierParMoyenne(Collection<Etudiant> etudiants) {
        List<Etudiant> liste = new ArrayList<>(etudiants);
        liste.sort((a, b) -> Double.compare(b.getMoyenne(), a.getMoyenne()));
        return liste;
    }

    // ✅ Affichage dans le terminal
    public static void afficherDansTerminal(List<Etudiant> etudiants) {
        System.out.println("\n--- Classement des étudiants ---");
        int rang = 1;
        for (Etudiant e : etudiants) {
            System.out.printf(
                "%d. %-20s | Moyenne : %.2f%n",
                rang++, e.getNomComplet(), e.getMoyenne()
            );
        }
    }

    // ✅ Sauvegarde dans le fichier CSV
    public static void sauvegarder(List<Etudiant> etudiants, String fichier) {
        try (FileWriter fw = new FileWriter(fichier)) {
            fw.write("Nom,Moyenne\n");
            for (Etudiant e : etudiants) {
                fw.write(e.getNomComplet() + "," + e.getMoyenne() + "\n");
            }
        } catch (Exception e) {
            System.err.println("Erreur écriture fichier : " + e.getMessage());
        }
    }
}