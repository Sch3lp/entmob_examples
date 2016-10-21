package be.pxl.spring.rest.fallout.quote;

import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;

public class QuoteTestBuilder {
    public static final String AUTHOR = "Jamie";
    public static final String QUOTATION = "As ze mn pet aanraken ja dan flip ik altijd";

    private UUID id;
    private String author;
    private String quotation;

    public static QuoteTestBuilder aQuote() {
        return new QuoteTestBuilder();
    }

    public static QuoteTestBuilder aDefaultQuote() {
        return new QuoteTestBuilder().withId(UUID.randomUUID()).withAuthor(AUTHOR).withQuotation(QUOTATION);
    }

    public Quote build() {
        Quote quote = new Quote(author, quotation);
        if (id == null){
            id = UUID.randomUUID();
        }
        ReflectionTestUtils.setField(quote, "id", id);
        return quote;
    }

    public QuoteTestBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public QuoteTestBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public QuoteTestBuilder withQuotation(String quotation) {
        this.quotation = quotation;
        return this;
    }
}