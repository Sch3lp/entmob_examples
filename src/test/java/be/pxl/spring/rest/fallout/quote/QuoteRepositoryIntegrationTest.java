package be.pxl.spring.rest.fallout.quote;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static be.pxl.spring.rest.fallout.quote.QuoteTestBuilder.aQuote;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuoteRepositoryIntegrationTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Before
    public void setUp() throws Exception {
        quoteRepository.deleteAll();
    }

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