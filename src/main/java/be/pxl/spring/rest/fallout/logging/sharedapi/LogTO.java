package be.pxl.spring.rest.fallout.logging.sharedapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

public class LogTO {

    @JsonProperty
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
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
