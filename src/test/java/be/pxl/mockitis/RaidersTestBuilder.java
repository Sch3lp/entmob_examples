package be.pxl.mockitis;

import java.util.Arrays;
import java.util.List;

public class RaidersTestBuilder {

    private List<Raider> attackers;

    public static RaidersTestBuilder aBunchOfRaiders(Raider... raiders){
        return new RaidersTestBuilder().withRaiders(raiders);
    }

    public Raiders build(){
        Raiders raiders = new Raiders(false);
        attackers.forEach(raiders::addAttacker);
        return raiders;
    }

    public RaidersTestBuilder withRaiders(Raider... raiders) {
        this.attackers = Arrays.asList(raiders);
        return this;
    }
}