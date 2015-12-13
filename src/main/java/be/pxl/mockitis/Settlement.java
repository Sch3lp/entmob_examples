package be.pxl.mockitis;

import java.util.List;

public class Settlement {
    private List<Settler> settlers;

    public Settlement(List<Settler> settlers) {
        this.settlers = settlers;
    }

    /**
     *
     * @param raiders
     * @return returns true if defending was successful, false otherwise
     */
    public boolean defend(Raiders raiders) {
        return raiders.getAmountOfRaiders() <= settlers.stream().filter(Settler::isAssignedToDefense).count();
    }
}
