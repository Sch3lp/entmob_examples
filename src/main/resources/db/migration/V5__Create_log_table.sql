CREATE TABLE JMS_LOG (
  ID BIGINT PRIMARY KEY,
  LOGGED_ON TIMESTAMP,
  USERNAME VARCHAR(50),
  MESSAGE VARCHAR(255)
);