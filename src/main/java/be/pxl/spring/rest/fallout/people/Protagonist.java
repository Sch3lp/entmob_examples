package be.pxl.spring.rest.fallout.people;

public class Protagonist implements AdvisablePerson {

    private int damagePoints;
    private Luck luck;

    public Protagonist(int damagePoints, Luck luck) {
        this.damagePoints = damagePoints;
        this.luck = luck;
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(damagePoints);
    }

    public boolean hasALotOfLuck() {
        return luck.isOver10();
    }
}