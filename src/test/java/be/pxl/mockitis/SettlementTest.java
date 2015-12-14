package be.pxl.mockitis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static be.pxl.mockitis.RaiderTestBuilder.aRaider;
import static be.pxl.mockitis.SettlerTestBuilder.aDefender;
import static be.pxl.mockitis.SettlerTestBuilder.aSettler;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SettlementTest {

    @Test
    public void settlement_WhenMoreSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raider raider1 = aRaider().build();
        Raiders raiders = RaidersTestBuilder.aBunchOfRaiders(raider1).build();

        Settler defender = aDefender().build();
        Settler farmer = aSettler().build();
        Settler clerk = aSettler().build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenEqualSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raider raider1 = aRaider().build();
        Raider raider2 = aRaider().build();
        Raiders raiders = RaidersTestBuilder.aBunchOfRaiders(raider1, raider2).build();

        Settler defender = aDefender().build();
        Settler farmer = aSettler().withAssignedToDefense(true).build();
        Settler clerk = aSettler().build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenLessSettlersAssignedToDefenseThanAmountOfRaiders_CanNotDefendItself() throws Exception {
        Raider raider1 = aRaider().build();
        Raider raider2 = aRaider().build();
        Raiders raiders = RaidersTestBuilder.aBunchOfRaiders(raider1, raider2).build();

        Settler defender = aDefender().build();
        Settler farmer = aSettler().build();
        Settler clerk = aSettler().build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isFalse();
    }
}
