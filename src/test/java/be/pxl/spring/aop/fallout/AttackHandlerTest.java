package be.pxl.spring.aop.fallout;

import be.pxl.spring.aop.TestConfiguration;
import be.pxl.spring.rest.fallout.people.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class AttackHandlerTest {

    @Autowired
    private AttackService attackHandler;

    @Test
    public void attack_ProtagonistWithZeroLuck_MysteriousStrangerNeverKillsEnemy() throws Exception {
        Protagonist hero = new Protagonist(10, Luck.ZeroLuck());
        Enemy enemy = new Enemy(Health.of(100));

        attackHandler.attack(hero, enemy);

        assertThat(enemy.healthStatus()).isEqualTo(HealthStatus.ALIVE);
    }

    @Test
    public void attack_ProtagonistWithALotOfLuck_MysteriousStrangerAlwaysKillsEnemy() throws Exception {
        Protagonist luckyHero = new Protagonist(10, Luck.SuperLucky());
        Enemy enemy = new Enemy(Health.of(100));

        attackHandler.attack(luckyHero, enemy);

        assertThat(enemy.healthStatus()).isEqualTo(HealthStatus.DEAD);
    }
}