package be.pxl.spring.rest.fallout.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@RequestMapping(MemorableQuotesController.QUOTE_BASE_URL)
@RestController
public class MemorableQuotesController {

    public static final String QUOTE_BASE_URL = "/quote";

    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private QuoteAssembler quoteAssembler;

    private static final List<QuoteR> QUOTES;

    static {
        QUOTES = new ArrayList<>();
        QUOTES.add(QuoteR.of("1", "Narrator", "War...War never changes"));
        QUOTES.add(QuoteR.of("2", "Mr. Fantastic", "They asked me how well I understood theoretical physics. I said I had a theoretical degree in physics. They said welcome aboard"));
        QUOTES.add(QuoteR.of("3", "Liberty Prime", "Freedom is the sovereign right of every American"));
        QUOTES.add(QuoteR.of("4", "Thomas Hildern", "Too many people have opnions on things they know nothing about. And the more ignorant they are, the more opinions they have"));
        QUOTES.add(QuoteR.of("5", "Moira Brown", "Here, take a few radiation chems, as my little way of saying, \"I'm sorry I twisted your DNA like a kitten with a ball of yarn.\""));
    }


    @RequestMapping
    public List<QuoteR> all(){
        return quoteRepository
                .findAll()
                .stream()
                .map(quoteAssembler::toRepresentation)
                .collect(toList());
    }

    @RequestMapping(params = {"author"})
    public List<QuoteR> queried(@RequestParam("author") String author){
        return QUOTES.stream().filter(q -> author.equals(q.getAuthor())).collect(toList());
    }
}
