package be.pxl.spring.rest.fallout.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class JMSMessageConsumer {

    @Autowired
    private JMSLogRepository jmsLogRepository;

    @JmsListener(destination = "ItemLogQueue")
    public void onMessage(TextMessage message) throws JMSException, IOException {
        System.out.println(message.getText());
        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
        LogTO logTO = om.readValue(message.getText(), LogTO.class);
        JMSLog log = JMSLog.log(logTO.getLoggedOn(), logTO.getUsername(), logTO.getLogMessage());
        jmsLogRepository.save(log);
    }
}
