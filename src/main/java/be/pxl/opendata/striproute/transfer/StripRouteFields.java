package be.pxl.opendata.striproute.transfer;

public class StripRouteFields {
    private String auteur_s;
    private StripRoutePhoto photo;
    private String personnage_s;
    private Long[] coordonnees_geographiques;
    private String annee;

    public StripRouteFields(String auteur_s, StripRoutePhoto photo, String personnage_s, Long[] coordonnees_geographiques, String annee) {
        this.auteur_s = auteur_s;
        this.photo = photo;
        this.personnage_s = personnage_s;
        this.coordonnees_geographiques = coordonnees_geographiques;
        this.annee = annee;
    }

    public String getAuteur_s() {
        return auteur_s;
    }

    public StripRoutePhoto getPhoto() {
        return photo;
    }

    public String getPersonnage_s() {
        return personnage_s;
    }

    public Long[] getCoordonnees_geographiques() {
        return coordonnees_geographiques;
    }

    public String getAnnee() {
        return annee;
    }
}
