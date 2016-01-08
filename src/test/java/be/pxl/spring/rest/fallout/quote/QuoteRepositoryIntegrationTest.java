package be.pxl.spring.rest.fallout.quote;

import be.pxl.spring.rest.fallout.Application;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.Arrays;
import java.util.List;

import static be.pxl.spring.rest.fallout.quote.QuoteTestBuilder.aQuote;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, FlywayTestExecutionListener.class})
@SpringApplicationConfiguration(Application.class)
@FlywayTest
public class QuoteRepositoryIntegrationTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Test
    public void findByAuthor_OnlyReturnsQuotesByGivenAuthor() throws Exception {
        Quote piperQuote1 = aQuote().withAuthor("Piper").withQuotation("quotation").build();
        Quote piperQuote2 = aQuote().withAuthor("Piper").withQuotation("quotation3").build();
        Quote otherQuote = aQuote().withAuthor("Jamie").withQuotation("quotation2").build();
        quoteRepository.save(Arrays.asList(piperQuote1, piperQuote2, otherQuote));

        List<Quote> quotes = quoteRepository.findByAuthor("Piper");

        assertThat(quotes).extracting(Quote::getQuotation).containsOnly("quotation", "quotation3");
    }
}