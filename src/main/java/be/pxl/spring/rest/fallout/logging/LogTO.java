package be.pxl.spring.rest.fallout.logging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class LogTO {

    @JsonProperty
    private final LocalDateTime loggedOn;
    @JsonProperty
    private final String username;
    @JsonProperty
    private final String logMessage;

    @JsonCreator
    public LogTO(@JsonProperty("loggedOn") LocalDateTime loggedOn, @JsonProperty("username") String username, @JsonProperty("logMessage") String logMessage) {
        this.loggedOn = loggedOn;
        this.username = username;
        this.logMessage = logMessage;
    }

    public LocalDateTime getLoggedOn() {
        return loggedOn;
    }

    public String getUsername() {
        return username;
    }

    public String getLogMessage() {
        return logMessage;
    }
}
