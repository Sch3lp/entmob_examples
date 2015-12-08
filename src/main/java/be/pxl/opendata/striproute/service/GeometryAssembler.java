package be.pxl.opendata.striproute.service;

import be.pxl.opendata.striproute.domain.Geometry;

import java.util.List;

public class GeometryAssembler {

    public static Geometry toGeometry(List<Long> coordinates) {
        if (coordinates == null || coordinates.isEmpty()){
            throw new IllegalArgumentException("coordinates are invalid");
        }
        return new Geometry(coordinates.get(0),coordinates.get(1));
    }
}
