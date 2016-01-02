package be.pxl.spring.aop.fallout;

import be.pxl.spring.aop.fallout.people.Enemy;
import be.pxl.spring.aop.fallout.people.Protagonist;

public interface AttackService {
    void attack(Protagonist protagonist, Enemy enemy);
}
