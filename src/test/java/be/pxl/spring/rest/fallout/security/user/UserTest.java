package be.pxl.spring.rest.fallout.security.user;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

public class UserTest {

    @Test
    public void testName() throws Exception {
        System.out.println(Base64.getEncoder().encodeToString("Father:institute4life".getBytes()));
        System.out.println(Base64.getEncoder().encodeToString("Desdemona:rescueallthesynths".getBytes()));
        System.out.println(new BCryptPasswordEncoder().encode("institute4life"));
        System.out.println(new BCryptPasswordEncoder().encode("rescueallthesynths"));
    }
}