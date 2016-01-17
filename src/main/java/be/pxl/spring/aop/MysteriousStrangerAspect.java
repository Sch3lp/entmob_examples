package be.pxl.spring.aop;

import be.pxl.spring.rest.fallout.people.Enemy;
import be.pxl.spring.rest.fallout.people.Protagonist;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MysteriousStrangerAspect {

    @After("execution(* *.attack(..)) && args(protagonist, enemy)")
    public void attack(Protagonist protagonist, Enemy enemy) {
        if (protagonist.hasALotOfLuck()) {
            enemy.takeLethalDamage();
        }
    }
}
