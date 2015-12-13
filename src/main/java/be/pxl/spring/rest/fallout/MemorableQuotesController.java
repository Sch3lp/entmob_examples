package be.pxl.spring.rest.fallout;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(MemorableQuotesController.QUOTE_BASE_URL)
@RestController
public class MemorableQuotesController {

    public static final String QUOTE_BASE_URL = "/quote/";
    private static final List<Quote> quotes;

    static {
        quotes = new ArrayList<>();
        quotes.add(Quote.of("Narrator", "War...War never changes"));
        quotes.add(Quote.of("Mr. Fantastic", "They asked me how well I understood theoretical physics. I said I had a theoretical degree in physics. They said welcome aboard"));
        quotes.add(Quote.of("Liberty Prime","Freedom is the sovereign right of every American"));
        quotes.add(Quote.of("Thomas Hildern","Too many people have opnions on things they know nothing about. And the more ignorant they are, the more opinions they have"));
        quotes.add(Quote.of("Moira Brown", "Here, take a few radiation chems, as my little way of saying, \"I'm sorry I twisted your DNA like a kitten with a ball of yarn.\""));
    }

    @RequestMapping("/")
    public List<Quote> all(){
        return quotes;
    }

    public List<Quote> queried(){
        return quotes;
    }
}
