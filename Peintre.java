public class Peintre extends Ouvrier {
    private String typeDePeinture;
    private String outils;

    public Peintre(String nom, String prenom, float salaire, int age, String typeDePeinture, String outils) {
        super(nom, prenom, salaire, age);
        this.typeDePeinture = typeDePeinture;
        this.outils = outils;
    }

    public void appliquerPeinture() {
        System.out.println("Application de peinture de type : " + typeDePeinture);
    }

    public void preparerSurface() {
        System.out.println("Préparation de la surface...");
    }
}
