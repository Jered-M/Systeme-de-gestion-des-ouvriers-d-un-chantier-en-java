public class Chantier {
    private String nomChantier;
    private String localisation;

    public Chantier(String nomChantier, String localisation) {
        this.nomChantier = nomChantier;
        this.localisation = localisation;
    }

    public String dateDebut() {
        // Pour l'exemple, retour d'une date statique
        return "2025-04-01";
    }

    public void afficherChantier() {
        System.out.println("Chantier : " + nomChantier + ", Localisation : " + localisation);
    }
}
