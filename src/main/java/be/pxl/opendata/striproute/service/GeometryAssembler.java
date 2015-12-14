package be.pxl.opendata.striproute.service;

import be.pxl.opendata.striproute.domain.Geometry;

import java.util.List;

public class GeometryAssembler {

    public static Geometry toGeometry(List<Long> coordinates) {
        if (coordinates == null || notExactlyTwoCoordinates(coordinates) || coordinatesAreNull(coordinates)) {
            throw new IllegalArgumentException("coordinates are invalid");
        }
        return new Geometry(coordinates.get(0),coordinates.get(1));
    }

    private static boolean notExactlyTwoCoordinates(List<Long> coordinates) {
        return coordinates.size() != 2;
    }

    private static boolean coordinatesAreNull(List<Long> coordinates) {
        return coordinates.stream().anyMatch(c -> c == null);
    }
}
