public class Electricien extends Ouvrier {
    private String typeDeCablage;
    private String outils;

    public Electricien(String nom, String prenom, float salaire, int age, String typeDeCablage, String outils) {
        super(nom, prenom, salaire, age);
        this.typeDeCablage = typeDeCablage;
        this.outils = outils;
    }

    public void installerCircuit() {
        System.out.println("Installation de circuit de type : " + typeDeCablage);
    }

    public void reparerCircuit() {
        System.out.println("Réparation du circuit...");
    }
}
