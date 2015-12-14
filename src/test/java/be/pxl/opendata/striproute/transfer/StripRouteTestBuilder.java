package be.pxl.opendata.striproute.transfer;

import java.time.LocalDateTime;
import java.util.Arrays;

public class StripRouteTestBuilder {

    private String auteur;
    private String jaar;
    private Long longitude;
    private Long latitude;

    public StripRoute build(){
        String datasetid = null;
        String recordid = null;
        StripRouteFields fields = new StripRouteFields(auteur,null,null,null,jaar);
        StripRouteGeometry geometry = new StripRouteGeometry(null, Arrays.asList(longitude,latitude));
        LocalDateTime record_timestamp = null;
        StripRoute stripRoute = new StripRoute(datasetid, recordid, fields, geometry, record_timestamp);
        return stripRoute;
    }


    public StripRouteTestBuilder withAuteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    public StripRouteTestBuilder withAnnee(String jaar) {
        this.jaar = jaar;
        return this;
    }

    public StripRouteTestBuilder withLongitude(long longitude) {
        this.longitude = longitude;
        return this;
    }

    public StripRouteTestBuilder withLatitude(long latitude) {
        this.latitude = latitude;
        return this;
    }

    public StripRouteTestBuilder withoutAnnee() {
        this.jaar = null;
        return this;
    }

    public StripRouteTestBuilder withoutLongitude() {
        this.longitude = null;
        return this;
    }

    public StripRouteTestBuilder withoutLatitude() {
        this.latitude = null;
        return this;
    }
}