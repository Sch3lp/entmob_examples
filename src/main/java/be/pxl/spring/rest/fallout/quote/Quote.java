package be.pxl.spring.rest.fallout.quote;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "QUOTES")
public class Quote {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    private UUID id;
    private String author;
    private String quotation;

    // because ORM :(
    protected Quote(){}

    public Quote(String author, String quotation) {
        this.author = author;
        this.quotation = quotation;
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuotation() {
        return quotation;
    }
}
