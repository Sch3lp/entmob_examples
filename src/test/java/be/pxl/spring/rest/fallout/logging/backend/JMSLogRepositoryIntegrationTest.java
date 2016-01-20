package be.pxl.spring.rest.fallout.logging.backend;

import be.pxl.spring.rest.fallout.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JMSLogRepositoryIntegrationTest {

    @Autowired
    private JMSLogRepository repo;

    @Resource
    private EntityManager em;

    @Test
    public void canPersistAJMSLogEntity() throws Exception {
        LocalDateTime loggedOn = LocalDateTime.now();
        String username = "derpface";
        String message = "herptyderptyderp";
        JMSLog persistedLog = repo.saveAndFlush(JMSLog.log(loggedOn, username, message));
        long logId = persistedLog.getId();

        em.clear(); // get rid of cache

        JMSLog log = repo.findOne(logId);
        assertThat(log.getLoggedOn()).isEqualTo(loggedOn);
        assertThat(log.getUsername()).isEqualTo(username);
        assertThat(log.getMessage()).isEqualTo(message);
    }
}