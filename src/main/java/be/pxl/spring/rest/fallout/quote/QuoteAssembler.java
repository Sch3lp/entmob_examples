package be.pxl.spring.rest.fallout.quote;

public class QuoteAssembler {
    public QuoteR toRepresentation(Quote quote) {
        return QuoteR.of(quote.getId().toString(), quote.getAuthor(), quote.getQuotation());
    }
}
