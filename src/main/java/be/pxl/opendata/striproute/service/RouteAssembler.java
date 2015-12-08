package be.pxl.opendata.striproute.service;

import be.pxl.opendata.striproute.domain.Geometry;
import be.pxl.opendata.striproute.domain.Route;
import be.pxl.opendata.striproute.transfer.StripRoute;

/**
 * Transforms incoming (marshalled) JSON to our own Domain that makes sense for us
 */
public class RouteAssembler {

    public Route assemble(StripRoute stripRoute) {
        Geometry geometry = GeometryAssembler.toGeometry(stripRoute.getGeometry().getCoordinates());
        return new Route(geometry, stripRoute.getFields().getAuteur_s(), stripRoute.getFields().getAnnee());
    }
}
