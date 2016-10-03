package be.pxl.mockitis;

import static org.junit.Assert.*;

public class RaiderTestBuilder {

    public static RaiderTestBuilder aRaider() {
        return new RaiderTestBuilder();
    }

    public Raider build(){
        return new Raider();
    }
}