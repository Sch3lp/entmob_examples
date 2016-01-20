package be.pxl.spring.rest.fallout.logging.backend;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "JMS_LOG")
public class JMSLog {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private LocalDateTime loggedOn;

    @Column
    private String username;

    @Column
    private String message;

    protected JMSLog() {
    }

    private JMSLog(LocalDateTime loggedOn, String username, String message) {
        this.loggedOn = loggedOn;
        this.username = username;
        this.message = message;
    }

    public static JMSLog log(LocalDateTime loggedOn, String username, String message){
        return new JMSLog(loggedOn, username, message);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getLoggedOn() {
        return loggedOn;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
