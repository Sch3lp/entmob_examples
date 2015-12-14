package be.pxl.mockitis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SettlementTest {

    @Test
    public void settlement_WhenMoreSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raiders raiders = mock(Raiders.class);
        when(raiders.getAmountOfRaiders()).thenReturn(1);

        Settler defender = mock(Settler.class);
        Settler farmer = mock(Settler.class);
        Settler clerk = mock(Settler.class);

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
        when(defender.isAssignedToDefense()).thenReturn(true);
        when(farmer.isAssignedToDefense()).thenReturn(false);
        when(clerk.isAssignedToDefense()).thenReturn(false);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenEqualSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raiders raiders = mock(Raiders.class);
        when(raiders.getAmountOfRaiders()).thenReturn(2);

        Settler defender = mock(Settler.class);
        Settler farmer = mock(Settler.class);
        Settler clerk = mock(Settler.class);

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
        when(defender.isAssignedToDefense()).thenReturn(true);
        when(farmer.isAssignedToDefense()).thenReturn(true);
        when(clerk.isAssignedToDefense()).thenReturn(false);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenLessSettlersAssignedToDefenseThanAmountOfRaiders_CanNotDefendItself() throws Exception {
        Raiders raiders = mock(Raiders.class);
        when(raiders.getAmountOfRaiders()).thenReturn(2);

        Settler defender = mock(Settler.class);
        Settler farmer = mock(Settler.class);
        Settler clerk = mock(Settler.class);

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
        when(defender.isAssignedToDefense()).thenReturn(true);
        when(farmer.isAssignedToDefense()).thenReturn(false);
        when(clerk.isAssignedToDefense()).thenReturn(false);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isFalse();
    }
}
