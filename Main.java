public class Main {
    public static void main(String[] args) {

        Ouvrier ouvrier = new Ouvrier("Dupont", "Jean", 1500.0f, 35);
        ouvrier.afficherInformations();

        Macon macon = new Macon("Dupont", "Jean", 1500f, 35, "Brique", "Truelle");
        macon.afficherInformations();
        macon.poserMur();

        Chantier chantier = new Chantier("Construction école", "Kinshasa");
        chantier.afficherChantier();
        System.out.println("Début des travaux : " + chantier.dateDebut());

        Peintre peintre = new Peintre("Dupont", "Jean", 2500.0f, 35, "Acrylique", "Pinceau");
        peintre.afficherInformations(); // Appel de la méthode pour Peintre
        peintre.appliquerPeinture();
        peintre.preparerSurface();

        Electricien electricien = new Electricien("Durand", "Luc", 2800.0f, 30, "Domestique", "Tournevis");
        electricien.afficherInformations(); // Appel de la méthode pour Electricien
        electricien.installerCircuit();
        electricien.reparerCircuit();

        Plombier plombier = new Plombier("Bernard", "Jacques", 2600.0f, 45, "Sanitaire", "Clé à molette");
        plombier.afficherInformations(); // Appel de la méthode pour Plombier
        plombier.installerPlomberie();
        plombier.reparerFuite();
    }
}