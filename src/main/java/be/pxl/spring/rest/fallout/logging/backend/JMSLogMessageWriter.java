package be.pxl.spring.rest.fallout.logging.backend;

import be.pxl.spring.rest.fallout.logging.sharedapi.LogTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class JMSLogMessageWriter {

    @Autowired
    private JMSLogRepository jmsLogRepository;

    @JmsListener(destination = "ItemLogQueue")
    public void onMessage(TextMessage message) throws JMSException, IOException {
        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules(); //necessary for LocalDateTime conversion
        LogTO logTO = om.readValue(message.getText(), LogTO.class);
        JMSLog log = JMSLog.log(logTO.getLoggedOn(), logTO.getUsername(), logTO.getLogMessage());
        jmsLogRepository.save(log);
    }
}