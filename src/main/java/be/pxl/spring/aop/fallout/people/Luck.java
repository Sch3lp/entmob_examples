package be.pxl.spring.aop.fallout.people;

public class Luck {
    private static int factor;

    private Luck(int factor) {
        this.factor = factor;
    }

    public boolean isOver10() {
        return factor > 10;
    }

    public static Luck ZeroLuck() {
        return new Luck(0);
    }

    public static Luck SuperLucky() {
        return new Luck(11);
    }
}
