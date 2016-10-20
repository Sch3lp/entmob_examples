package be.pxl.opendata.striproute.service;

import be.pxl.opendata.striproute.domain.Route;
import be.pxl.opendata.striproute.transfer.StripRoute;
import be.pxl.opendata.striproute.transfer.StripRouteTestBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteAssemblerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private RouteAssembler routeAssembler;

    @Before
    public void setUp() throws Exception {
        routeAssembler = new RouteAssembler();
    }

    @Test
    public void assemble_DefaultStripRoute_RouteWordtVolledigIngevuld() throws Exception {
        StripRoute stripRoute = new StripRouteTestBuilder()
                .withAuteur("derp")
                .withAnnee("2015")
                .withLongitude(2)
                .withLatitude(51)
                .build();

        Route route = routeAssembler.assemble(stripRoute);

        assertThat(route.getAuteur()).isEqualTo("derp");
        assertThat(route.getYear()).isEqualTo("2015");
        assertThat(route.getLatitude()).isEqualTo(51);
        assertThat(route.getLongitude()).isEqualTo(2);
    }

    @Test
    public void assemble_StripRouteZonderJaar_RouteHeeftGeenJaar() throws Exception {
        StripRoute stripRoute = new StripRouteTestBuilder()
                .withAuteur("derp")
                .withoutAnnee()
                .withLongitude(2)
                .withLatitude(51)
                .build();

        Route route = routeAssembler.assemble(stripRoute);

        assertThat(route.getAuteur()).isEqualTo("derp");
        assertThat(route.getYear()).isNull();
        assertThat(route.getLatitude()).isEqualTo(51);
        assertThat(route.getLongitude()).isEqualTo(2);
    }

    @Test
    public void assemble_StripRouteZonderCoordinaten_KunnenWeGeenRouteMeeAanmaken() throws Exception {
        StripRoute stripRoute = new StripRouteTestBuilder()
                .withAuteur("derp")
                .withAnnee("2015")
                .withoutLongitude()
                .withoutLatitude()
                .build();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("coordinates are invalid");

        routeAssembler.assemble(stripRoute);
    }
}