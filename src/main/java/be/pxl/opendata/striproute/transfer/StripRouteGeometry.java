package be.pxl.opendata.striproute.transfer;

import java.util.List;

public class StripRouteGeometry {
    private String type;
    private List<Long> coordinates;

    public StripRouteGeometry(String type, List<Long> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public List<Long> getCoordinates() {
        return coordinates;
    }
}
