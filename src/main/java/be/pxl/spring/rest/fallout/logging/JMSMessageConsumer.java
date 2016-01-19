package be.pxl.spring.rest.fallout.logging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class JMSMessageConsumer {

    @JmsListener(destination = "ItemLogQueue")
    public void onMessage(Message message) {
        //TODO: save to log table or something
        System.out.println("Hi, I'm JMSMessageConsumer and I got " + message);
    }
}
