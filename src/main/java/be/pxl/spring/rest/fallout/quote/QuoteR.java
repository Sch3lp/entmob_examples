package be.pxl.spring.rest.fallout.quote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteR {
    private String id;
    private String author;
    private String quote;

    public static QuoteR of(String id, String author, String quote) {
        return new QuoteR(id, author, quote);
    }

    public static QuoteR of(String author, String quote) { return new QuoteR(null, author, quote); }

    @JsonCreator
    private QuoteR(@JsonProperty("id")String id, @JsonProperty("author")String author, @JsonProperty("quote")String quote) {
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

    @Override
    public String toString() {
        return "QuoteR{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
