package be.pxl.opendata.striproute.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteAssemblerTest {

    private RouteAssembler routeAssembler;

    @Before
    public void setUp() throws Exception {
        routeAssembler = new RouteAssembler();
    }

    @Test
    public void assemble_DefaultStripRoute_RouteWordtVolledigIngevuld() throws Exception {
        //TODO Schrijf hier testcode die een StripRoute aanmaakt, dat meegeeft aan de assembler, en assertions
    }

    @Test
    public void assemble_StripRouteZonderJaar_RouteHeeftGeenJaar() throws Exception {
        //TODO Schrijf hier testcode die een StripRoute aanmaakt, dat meegeeft aan de assembler, en assertions
    }

    @Test
    public void assemble_StripRouteZonderCoordinaten_KunnenWeGeenRouteMeeAanmaken() throws Exception {
        //TODO Schrijf hier testcode die een StripRoute aanmaakt, dat meegeeft aan de assembler, en assertions
    }
}