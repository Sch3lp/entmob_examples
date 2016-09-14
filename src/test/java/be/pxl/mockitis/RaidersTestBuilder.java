package be.pxl.mockitis;

import java.util.Arrays;
import java.util.List;

public class RaidersTestBuilder {

    private List<Raider> attackers;
    private boolean hasLegendary;

    public static RaidersTestBuilder aBunchOfRaiders(Raider... raiders){
        return new RaidersTestBuilder().withRaiders(raiders);
    }

    public Raiders build(){
        Raiders raiders = new Raiders(hasLegendary);
        attackers.forEach(raiders::addAttacker);
        return raiders;
    }

    public RaidersTestBuilder withRaiders(Raider... raiders) {
        this.attackers = Arrays.asList(raiders);
        return this;
    }

    public RaidersTestBuilder withALegendary() {
        this.hasLegendary = true;
        return this;
    }

    public RaidersTestBuilder withoutALegendary() {
        this.hasLegendary = false;
        return this;
    }
}