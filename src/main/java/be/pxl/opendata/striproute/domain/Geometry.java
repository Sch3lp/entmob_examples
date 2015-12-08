package be.pxl.opendata.striproute.domain;

public class Geometry {
    private long longitude;
    private long latitude;

    public Geometry(long longitude, long latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public long getLatitude() {
        return latitude;
    }
}
