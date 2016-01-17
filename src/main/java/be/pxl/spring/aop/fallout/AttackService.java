package be.pxl.spring.aop.fallout;

import be.pxl.spring.rest.fallout.people.Enemy;
import be.pxl.spring.rest.fallout.people.Protagonist;

public interface AttackService {
    void attack(Protagonist protagonist, Enemy enemy);
}
