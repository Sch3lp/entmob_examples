package be.pxl.mockitis;

import java.util.ArrayList;
import java.util.List;

public class Raiders {

    private List<Raider> raiders = new ArrayList<>();
    private boolean hasLegendary;

    public Raiders(boolean hasLegendary) {
        this.hasLegendary = hasLegendary;
    }

    public void addAttacker(Raider raider){
        raiders.add(raider);
    }

    public boolean hasLegendary(){
        return hasLegendary;
    }

    public int getAmountOfRaiders() {
        return hasLegendary ? raiders.size() + 1 : raiders.size();
    }

}
