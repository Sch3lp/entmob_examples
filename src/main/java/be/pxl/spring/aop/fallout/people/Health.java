package be.pxl.spring.aop.fallout.people;

public class Health {
    private int totalHP;
    private int hp;

    private Health(int hp) {
        this.hp = hp;
        this.totalHP = hp;
    }

    private Health(int hp, int totalHP) {
        this.hp = hp;
        this.totalHP = totalHP;
    }

    public static Health of(int hp) {
        return new Health(hp);
    }

    public Health subtract(int damagePoints) {
        return new Health(hp - damagePoints, totalHP);
    }

    public HealthStatus status() {
        return hp > 0 ? HealthStatus.ALIVE : HealthStatus.DEAD;
    }

    public Health instaDeath() {
        return new Health(0, totalHP);
    }
}
