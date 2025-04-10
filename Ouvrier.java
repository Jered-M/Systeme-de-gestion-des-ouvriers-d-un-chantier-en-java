import java.util.ArrayList;
import java.util.List;

public class Ouvrier {
    protected String nom;
    protected String prenom;
    protected float salaire;
    protected int age;

    public Ouvrier(String nom, String prenom, float salaire, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.age = age;
    }

    public void afficherInformations() {
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Salaire : " + salaire);
        System.out.println("Âge : " + age);
    }

    public float calculerSalaire() {
        return salaire;
    }

    // Méthode statique pour rechercher des ouvriers par nom ou métier
    public static List<Ouvrier> rechercherOuvriers(List<Ouvrier> ouvriers, String critere) {
        List<Ouvrier> resultats = new ArrayList<>();
        for (Ouvrier ouvrier : ouvriers) {
            if (ouvrier.nom.equalsIgnoreCase(critere) || ouvrier.getClass().getSimpleName().equalsIgnoreCase(critere)) {
                resultats.add(ouvrier);
            }
        }
        return resultats;
    }
}
