package be.pxl.mockitis;

public class SettlerTestBuilder {

    private boolean isAssignedToDefense;

    public SettlerTestBuilder(){}

    public static SettlerTestBuilder aDefender(){
        return new SettlerTestBuilder().withAssignedToDefense(true);
    }

    public static SettlerTestBuilder aSettler(){
        return new SettlerTestBuilder();
    }

    public Settler build(){
        return new Settler(isAssignedToDefense);
    }

    public SettlerTestBuilder withAssignedToDefense(boolean assignedToDefense) {
        isAssignedToDefense = assignedToDefense;
        return this;
    }
}