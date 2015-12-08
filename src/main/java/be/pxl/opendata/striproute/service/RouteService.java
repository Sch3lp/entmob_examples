package be.pxl.opendata.striproute.service;

import be.pxl.opendata.striproute.domain.Route;
import be.pxl.opendata.striproute.domain.RouteDAO;
import be.pxl.opendata.striproute.transfer.StripRoute;

import java.util.List;
import java.util.stream.Collectors;

public class RouteService {

    private RouteAssembler assembler;
    private RouteDAO routeDAO;

    public RouteService(RouteAssembler assembler, RouteDAO routeDAO) {
        this.assembler = assembler;
        this.routeDAO = routeDAO;
    }

    public List<Route> findNearestRoutes(StripRoute stripRoute){
        Route route = assembler.assemble(stripRoute);

        List<Route> allRoutes = routeDAO.getAllRoutes();
        return allRoutes.stream()
                .filter(aRoute -> aRoute.isNearTo(route))
                .collect(Collectors.toList());
    }
}
