package be.pxl.opendata.striproute.domain;

public class Geometry {
    private Long longitude;
    private Long latitude;

    public Geometry(Long longitude, Long latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public Long getLatitude() {
        return latitude;
    }
}
