package be.pxl.spring.rest.fallout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

/*
 * Automagic uber shorthand for:
 * @Configuration
 * @EnableAutoConfiguration
 * @EnableWebMVC --> which already automagically creates a DispatcherServlet
 * @ComponentScan --> which already automagically scans your class files (in the same package) for spring annotations
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        // Log Beans provided by SpringBoot
        Stream.of(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
    }
}
