package be.pxl.spring.rest.fallout.quote;

public class QuoteR {
    private String id;
    private String author;
    private String quote;

    public static QuoteR of(String id, String author, String quote) {
        return new QuoteR(id, author, quote);
    }

    private QuoteR(String id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }
}
