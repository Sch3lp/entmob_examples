package be.pxl.mockitis;

public class Settler {
    private boolean assignedToDefense;

    public Settler(boolean assignedToDefense) {
        this.assignedToDefense = assignedToDefense;
    }

    public boolean isAssignedToDefense() {
        return assignedToDefense;
    }
}
