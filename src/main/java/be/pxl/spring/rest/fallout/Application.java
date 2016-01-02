package be.pxl.spring.rest.fallout;

import be.pxl.spring.rest.fallout.quote.QuoteAssembler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * Automagic uber shorthand for:
 * @Configuration
 * @EnableAutoConfiguration
 * @EnableWebMVC --> which already automagically creates a DispatcherServlet
 * @ComponentScan --> which already automagically scans your class files (in the same package) for spring annotations
 */
@SpringBootApplication
public class Application {

    // Example of not using @Service or @Component, while still having an instance known to Spring.
    @Bean
    public QuoteAssembler quoteAssembler() {
        return new QuoteAssembler();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
