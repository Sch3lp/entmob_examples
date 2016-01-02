package be.pxl.spring.aop.fallout;

import be.pxl.spring.aop.fallout.people.Enemy;
import be.pxl.spring.aop.fallout.people.Protagonist;
import org.springframework.stereotype.Service;

@Service
public class AttackHandler implements AttackService {

    @Override
    public void attack(Protagonist protagonist, Enemy enemy) {
        protagonist.attack(enemy);
    }
}
