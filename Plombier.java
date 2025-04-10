public class Plombier extends Ouvrier {
    private String typeDePlomberie;
    private String outils;

    public Plombier(int id, String nom, String prenom, float salaire, int age, String typeDePlomberie, String outils) {
        super(id, nom, prenom, salaire, age);
        this.typeDePlomberie = typeDePlomberie;
        this.outils = outils;
    }

    public void installerPlomberie() {
        System.out.println("Installation de plomberie de type : " + typeDePlomberie);
    }

    public void reparerFuite() {
        System.out.println("Réparation de fuite...");
    }

    public String getTypeDePlomberie() {
        return typeDePlomberie;
    }

    public void setTypeDePlomberie(String typeDePlomberie) {
        this.typeDePlomberie = typeDePlomberie;
    }

    public String getOutils() {
        return outils;
    }

    public void setOutils(String outils) {
        this.outils = outils;
    }
}
