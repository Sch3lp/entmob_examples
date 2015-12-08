package be.pxl.opendata.striproute.domain;

public class Route {
    private Geometry geometry;
    private String auteur;
    private String year;

    public Route(Geometry geometry, String author, String year) {
        this.geometry = geometry;
        this.auteur = author;
        this.year = year;
    }

    public Route shortestRouteTo(Route route){
        //doe ferme algoritmische berekening dat domeinspecifiek is voor onze toepassing
        return null;
    }

    public boolean isNearTo(Route route) {
        //doe ferme algoritmische berekening dat domeinspecifiek is voor onze toepassing
        return true;
    }

    public long getLongitude() {
        return geometry.getLongitude();
    }

    public long getLatitude() {
        return geometry.getLatitude();
    }

    public String getAuteur() {
        return auteur;
    }

    public String getYear() {
        return year;
    }
}
