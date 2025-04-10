public class Macon extends Ouvrier {
    private String typeDeMur;
    private String outils;

    public Macon(int id, String nom, String prenom, float salaire, int age, String typeDeMur, String outils) {
        super(id, nom, prenom, salaire, age);
        this.typeDeMur = typeDeMur;
        this.outils = outils;
    }

    public void poserMur() {
        System.out.println("Pose du mur de type : " + typeDeMur);
    }

    public void mesurerMur() {
        System.out.println("Mesure du mur...");
    }

    public String getTypeDeMur() {
        return typeDeMur;
    }

    public void setTypeDeMur(String typeDeMur) {
        this.typeDeMur = typeDeMur;
    }

    public String getOutils() {
        return outils;
    }

    public void setOutils(String outils) {
        this.outils = outils;
    }
}
