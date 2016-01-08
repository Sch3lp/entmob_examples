package be.pxl.spring.rest.fallout.security.user;

import be.pxl.spring.rest.fallout.Application;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, FlywayTestExecutionListener.class})
@FlywayTest
@SpringApplicationConfiguration(Application.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save_CanPersistANewUser() throws Exception {
        userRepository.save(new User("gianni", "ub3rl33t"));

        User gianni = userRepository.findAll().stream().filter(u -> u.getName().equals("gianni")).findFirst().get();

        assertThat(gianni.getId()).isNotNull();
        assertThat(gianni.getName()).isEqualTo("gianni");
        assertThat(gianni.getPassword()).isEqualTo("ub3rl33t");
        assertThat(gianni.getRole()).isEqualTo(Role.ROLE_USER);
        assertThat(gianni.isEnabled()).isTrue();
    }
}