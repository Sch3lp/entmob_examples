package be.pxl.spring.rest.fallout.security.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();
    }

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