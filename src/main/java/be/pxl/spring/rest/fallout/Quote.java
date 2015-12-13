package be.pxl.spring.rest.fallout;

public class Quote {
    private String author;
    private String quote;

    public static Quote of(String author, String quote) {
        return new Quote(author, quote);
    }

    private Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }
}
