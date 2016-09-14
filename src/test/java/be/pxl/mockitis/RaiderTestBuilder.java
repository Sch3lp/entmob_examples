package be.pxl.mockitis;

public class RaiderTestBuilder {

    public static RaiderTestBuilder aRaider() {
        return new RaiderTestBuilder();
    }

    public Raider build(){
        return new Raider();
    }
}