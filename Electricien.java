public class Electricien extends Ouvrier {
    private String typeDeCablage;
    private String outils;

    public Electricien(int id, String nom, String prenom, float salaire, int age, String typeDeCablage, String outils) {
        super(id, nom, prenom, salaire, age);
        this.typeDeCablage = typeDeCablage;
        this.outils = outils;
    }

    public void installerCircuit() {
        System.out.println("Installation de circuit de type : " + typeDeCablage);
    }

    public void reparerCircuit() {
        System.out.println("Réparation du circuit...");
    }

    public String getTypeDeCablage() {
        return typeDeCablage;
    }

    public void setTypeDeCablage(String typeDeCablage) {
        this.typeDeCablage = typeDeCablage;
    }

    public String getOutils() {
        return outils;
    }

    public void setOutils(String outils) {
        this.outils = outils;
    }
}
