import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FICHIER_JSON = "ouvriers.json";
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ouvrier> ouvriers = chargerOuvriersDepuisJson();

        while (true) {
            afficherMenu();
            int choix = lireEntreeEntier(scanner);

            switch (choix) {
                case 1:
                    ajouterOuvrier(ouvriers, scanner);
                    sauvegarderOuvriersDansJson(ouvriers);
                    break;
                case 2:
                    afficherOuvriers(ouvriers);
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // Affiche le menu principal
    private static void afficherMenu() {
        System.out.println("\nMenu :");
        System.out.println("1. Ajouter un ouvrier");
        System.out.println("2. Afficher les ouvriers");
        System.out.println("3. Quitter");
        System.out.print("Choisissez une option : ");
    }

    // Lit une entrée entière avec validation
    private static int lireEntreeEntier(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            scanner.next(); // Consomme l'entrée invalide
        }
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne
        return choix;
    }

    // Ajoute un ouvrier à la liste
    private static void ajouterOuvrier(List<Ouvrier> ouvriers, Scanner scanner) {
        System.out.println("\nTypes d'ouvriers :");
        System.out.println("1. Macon");
        System.out.println("2. Peintre");
        System.out.println("3. Electricien");
        System.out.println("4. Plombier");
        System.out.print("Choisissez un type d'ouvrier : ");
        int type = lireEntreeEntier(scanner);

        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Salaire : ");
        float salaire = scanner.nextFloat();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne

        List<String> outilsDisponibles = obtenirOutilsDisponibles(type);
        if (outilsDisponibles.isEmpty()) {
            System.out.println("Type d'ouvrier invalide.");
            return;
        }

        System.out.println("\nOutils disponibles :");
        for (int i = 0; i < outilsDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + outilsDisponibles.get(i));
        }

        System.out.println("Choisissez les outils (entrez les numéros séparés par des espaces, max 4) :");
        String[] choixOutils = scanner.nextLine().split(" ");
        List<String> outilsChoisis = new ArrayList<>();
        for (String choix : choixOutils) {
            try {
                int index = Integer.parseInt(choix) - 1;
                if (index >= 0 && index < outilsDisponibles.size()) {
                    outilsChoisis.add(outilsDisponibles.get(index));
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide ignorée : " + choix);
            }
        }

        if (outilsChoisis.size() > 4) {
            System.out.println("Vous avez sélectionné plus de 4 outils. Seuls les 4 premiers seront pris en compte.");
            outilsChoisis = outilsChoisis.subList(0, 4);
        }

        String outils = String.join(", ", outilsChoisis);

        switch (type) {
            case 1:
                System.out.print("Type de mur : ");
                String typeDeMur = scanner.nextLine();
                ouvriers.add(new Macon(nom, prenom, salaire, age, typeDeMur, outils));
                break;
            case 2:
                System.out.print("Type de peinture : ");
                String typeDePeinture = scanner.nextLine();
                ouvriers.add(new Peintre(nom, prenom, salaire, age, typeDePeinture, outils));
                break;
            case 3:
                System.out.print("Type de câblage : ");
                String typeDeCablage = scanner.nextLine();
                ouvriers.add(new Electricien(nom, prenom, salaire, age, typeDeCablage, outils));
                break;
            case 4:
                System.out.print("Type de plomberie : ");
                String typeDePlomberie = scanner.nextLine();
                ouvriers.add(new Plombier(nom, prenom, salaire, age, typeDePlomberie, outils));
                break;
            default:
                System.out.println("Type d'ouvrier invalide.");
        }
    }

    // Retourne la liste des outils disponibles pour un type d'ouvrier
    private static List<String> obtenirOutilsDisponibles(int type) {
        switch (type) {
            case 1: // Macon
                return List.of("Truelle", "Niveau", "Marteau", "Scie");
            case 2: // Peintre
                return List.of("Pinceau", "Rouleau", "Échelle", "Seau");
            case 3: // Electricien
                return List.of("Tournevis", "Pince coupante", "Multimètre", "Ruban isolant");
            case 4: // Plombier
                return List.of("Clé à molette", "Pince multiprise", "Déboucheur", "Ruban téflon");
            default:
                return new ArrayList<>();
        }
    }

    // Affiche les ouvriers enregistrés
    private static void afficherOuvriers(List<Ouvrier> ouvriers) {
        if (ouvriers.isEmpty()) {
            System.out.println("\nAucun ouvrier enregistré.");
        } else {
            System.out.println("\nListe des ouvriers :");
            for (Ouvrier ouvrier : ouvriers) {
                ouvrier.afficherInformations();
                System.out.println();
            }
        }
    }

    // Sauvegarde les ouvriers dans un fichier JSON
    private static void sauvegarderOuvriersDansJson(List<Ouvrier> ouvriers) {
        try (FileWriter writer = new FileWriter(FICHIER_JSON)) {
            gson.toJson(ouvriers, writer);
            System.out.println("Les ouvriers ont été enregistrés dans le fichier JSON.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement des ouvriers : " + e.getMessage());
        }
    }

    // Charge les ouvriers depuis un fichier JSON
    private static List<Ouvrier> chargerOuvriersDepuisJson() {
        try (FileReader reader = new FileReader(FICHIER_JSON)) {
            Type listType = new TypeToken<List<Ouvrier>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("Aucun fichier JSON trouvé. Une nouvelle liste sera créée.");
            return new ArrayList<>();
        }
    }
}