public class Plombier extends Ouvrier {
    private String typeDePlomberie;
    private String outils;

    public Plombier(String nom, String prenom, float salaire, int age, String typeDePlomberie, String outils) {
        super(nom, prenom, salaire, age);
        this.typeDePlomberie = typeDePlomberie;
        this.outils = outils;
    }

    public void installerPlomberie() {
        System.out.println("Installation de plomberie de type : " + typeDePlomberie);
    }

    public void reparerFuite() {
        System.out.println("Réparation de fuite...");
    }
}
