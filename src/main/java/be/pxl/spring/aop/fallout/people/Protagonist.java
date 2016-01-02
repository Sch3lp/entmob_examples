package be.pxl.spring.aop.fallout.people;

public class Protagonist implements AdvisablePerson {

    private int damagePoints;
    private int luck;

    public Protagonist(int damagePoints, int luck) {
        this.damagePoints = damagePoints;
        this.luck = luck;
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(damagePoints);
    }

    public boolean hasALotOfLuck() {
        return luck > 10;
    }
}