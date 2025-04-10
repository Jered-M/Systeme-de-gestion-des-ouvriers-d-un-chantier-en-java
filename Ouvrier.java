import java.util.ArrayList;
import java.util.List;

public class Ouvrier {
    private int id; // Identifiant unique
    private String nom;
    private String prenom;
    private float salaire;
    private int age;

    public Ouvrier(int id, String nom, String prenom, float salaire, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void afficherInformations() {
        System.out.println("ID : " + id);
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
