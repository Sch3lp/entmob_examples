package be.pxl.opendata.striproute.domain;

import java.util.ArrayList;
import java.util.List;

public class RouteDAO {

    private List<Route> allRoutes = new ArrayList<>();

    public List<Route> getAllRoutes() {
        return allRoutes;
    }
}
