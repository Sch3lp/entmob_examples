package be.pxl.opendata.striproute.service;

import be.pxl.opendata.striproute.domain.Route;
import be.pxl.opendata.striproute.transfer.StripRoute;
import be.pxl.opendata.striproute.transfer.StripRouteFields;
import be.pxl.opendata.striproute.transfer.StripRouteGeometry;
import be.pxl.opendata.striproute.transfer.StripRouteTestBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouteAssemblerMockitisTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private RouteAssembler routeAssembler;

    @Before
    public void setUp() throws Exception {
        routeAssembler = new RouteAssembler();
    }

    @Test
    public void assemble_DefaultStripRoute_RouteWordtVolledigIngevuld() throws Exception {
        StripRoute stripRoute = mock(StripRoute.class);
        StripRouteFields stripRouteFields = mock(StripRouteFields.class);
        StripRouteGeometry stripRouteGeometry = mock(StripRouteGeometry.class);
        when(stripRoute.getFields()).thenReturn(stripRouteFields);
        when(stripRoute.getGeometry()).thenReturn(stripRouteGeometry);

        when(stripRouteFields.getAuteur_s()).thenReturn("derp");
        when(stripRouteFields.getAnnee()).thenReturn("2015");
        when(stripRouteGeometry.getCoordinates()).thenReturn(Arrays.asList(2L,51L));

        Route route = routeAssembler.assemble(stripRoute);

        assertThat(route.getAuteur()).isEqualTo("derp");
        assertThat(route.getYear()).isEqualTo("2015");
        assertThat(route.getLatitude()).isEqualTo(51);
        assertThat(route.getLongitude()).isEqualTo(2);
    }

    @Test
    public void assemble_StripRouteZonderJaar_RouteHeeftGeenJaar() throws Exception {
        StripRoute stripRoute = mock(StripRoute.class);
        StripRouteFields stripRouteFields = mock(StripRouteFields.class);
        StripRouteGeometry stripRouteGeometry = mock(StripRouteGeometry.class);
        when(stripRoute.getFields()).thenReturn(stripRouteFields);
        when(stripRoute.getGeometry()).thenReturn(stripRouteGeometry);

        when(stripRouteFields.getAuteur_s()).thenReturn("derp");
        when(stripRouteFields.getAnnee()).thenReturn(null);
        when(stripRouteGeometry.getCoordinates()).thenReturn(Arrays.asList(2L,51L));

        Route route = routeAssembler.assemble(stripRoute);

        assertThat(route.getAuteur()).isEqualTo("derp");
        assertThat(route.getYear()).isNull();
        assertThat(route.getLatitude()).isEqualTo(51);
        assertThat(route.getLongitude()).isEqualTo(2);
    }

    @Test
    public void assemble_StripRouteZonderCoordinaten_KunnenWeGeenRouteMeeAanmaken() throws Exception {
        StripRoute stripRoute = mock(StripRoute.class);
        StripRouteFields stripRouteFields = mock(StripRouteFields.class);
        StripRouteGeometry stripRouteGeometry = mock(StripRouteGeometry.class);
        when(stripRoute.getFields()).thenReturn(stripRouteFields);
        when(stripRoute.getGeometry()).thenReturn(stripRouteGeometry);

        when(stripRouteFields.getAuteur_s()).thenReturn("derp");
        when(stripRouteFields.getAnnee()).thenReturn("2015");
        when(stripRouteGeometry.getCoordinates()).thenReturn(Collections.emptyList());

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("coordinates are invalid");

        routeAssembler.assemble(stripRoute);
    }
}