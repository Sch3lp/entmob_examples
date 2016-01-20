package be.pxl.spring.rest.fallout.logging.client;

import be.pxl.spring.rest.fallout.logging.sharedapi.LogTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;
import java.time.LocalDateTime;

@Component
public class JMSMessageLogger {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("LogQueueBean")
    private Queue destination;

    public void log(String username, String logMessage) throws JMSException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
        String logMessageTO = om.writeValueAsString(new LogTO(LocalDateTime.now(), username, logMessage));
        jmsTemplate.send(
                destination,
                (session) -> session.createTextMessage(logMessageTO)
        );
    }
}
