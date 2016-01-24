package be.pxl.spring.rest.fallout.logging.backend;

import be.pxl.spring.rest.fallout.logging.sharedapi.LogTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.jms.TextMessage;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JMSLogMessageWriterTest {

    @Mock
    private TextMessage jmsTextMessageMock;

    @Mock
    private JMSLogRepository jmsLogRepositoryMock;

    @Captor //captures arguments to verified method calls, so we can assert given arguments
    private ArgumentCaptor<JMSLog> jmsLogCaptor;

    @InjectMocks //both instantiates and injects necessary dependencies (by setter, constructor, reflection)
    private JMSLogMessageWriter consumer;

    @Test
    public void onMessage_CanTransformJMSMessageTOLogTO_AndPersists() throws Exception {
        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
        LocalDateTime loggedOn = LocalDateTime.now();
        String username = "derpface";
        String logMessage = "herptyderptyderp";
        when(jmsTextMessageMock.getText()).thenReturn(om.writeValueAsString(new LogTO(loggedOn, username, logMessage)));

        consumer.onMessage(jmsTextMessageMock);

        verify(jmsLogRepositoryMock).save(jmsLogCaptor.capture());
        JMSLog persistedJMSLog = jmsLogCaptor.getValue();
        assertThat(persistedJMSLog.getLoggedOn()).isEqualTo(loggedOn);
        assertThat(persistedJMSLog.getUsername()).isEqualTo(username);
        assertThat(persistedJMSLog.getMessage()).isEqualTo(logMessage);
    }
}