public class Macon extends Ouvrier {
    private String typeDeMur;
    private String outils;

    public Macon(String nom, String prenom, float salaire, int age, String typeDeMur, String outils) {
        super(nom, prenom, salaire, age);
        this.typeDeMur = typeDeMur;
        this.outils = outils;
    }

    public void poserMur() {
        System.out.println("Pose du mur de type : " + typeDeMur);
    }

    public void mesurerMur() {
        System.out.println("Mesure du mur...");
    }
}
