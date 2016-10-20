package be.pxl.spring.rest.fallout.people;

public class Enemy {

    private Health health = Health.of(100);

    public Enemy(Health health) {
        this.health = health;
    }

    public HealthStatus healthStatus() {
        return health.status();
    }

    public HealthStatus takeDamage(int damagePoints) {
        health = health.subtract(damagePoints);
        return healthStatus();
    }

    public HealthStatus takeLethalDamage() {
        health = health.instaDeath();
        return healthStatus();
    }
}