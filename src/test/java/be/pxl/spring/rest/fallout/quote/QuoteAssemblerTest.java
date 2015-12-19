package be.pxl.spring.rest.fallout.quote;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static be.pxl.spring.rest.fallout.quote.QuoteTestBuilder.aQuote;
import static org.assertj.core.api.Assertions.assertThat;

public class QuoteAssemblerTest {

    private QuoteAssembler quoteAssembler;

    @Before
    public void setUp() throws Exception {
        quoteAssembler = new QuoteAssembler();
    }

    @Test
    public void canTransformAQuoteToItsRepresentation() throws Exception {
        UUID id = UUID.randomUUID();
        String author = "Jamie";
        String quotation = "As ze mn pet aanraken ja dan flip ik altijd";
        Quote quote = aQuote().withId(id).withAuthor(author).withQuotation(quotation).build();

        QuoteR representation = quoteAssembler.toRepresentation(quote);

        assertThat(representation.getId()).isEqualTo(id.toString());
        assertThat(representation.getAuthor()).isEqualTo(author);
        assertThat(representation.getQuote()).isEqualTo(quotation);
    }
}