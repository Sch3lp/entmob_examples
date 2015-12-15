package be.pxl.spring.rest.fallout;

public class Quote {
    private String author;
    private String quote;
    private String id;

    public static Quote of(String author, String quote) {
        return new Quote(author, quote);
    }

    Quote(){}

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
