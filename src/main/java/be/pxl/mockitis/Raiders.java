package be.pxl.mockitis;

import java.util.ArrayList;
import java.util.List;

public class Raiders {

    private List<Raider> raiders = new ArrayList<>();

    public void addAttacker(Raider raider){
        raiders.add(raider);
    }

    public int getAmountOfRaiders() {
        return raiders.size();
    }

}
