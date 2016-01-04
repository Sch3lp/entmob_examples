package be.pxl.spring.rest.fallout.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    public List<QuoteR> all() {
        return quoteRepository
                .findAll()
                .stream()
                .map(quoteAssembler::toRepresentation)
                .collect(toList());
    }

    @RequestMapping(method = RequestMethod.GET, params = {"author"})
    public List<QuoteR> byAuthor(@RequestParam("author") String author) {
        return quoteRepository
                .findByAuthor(author)
                .stream()
                .map(quoteAssembler::toRepresentation)
                .collect(toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addQuote(@RequestBody QuoteR newQuoteR){
        Quote newQuote = new Quote(newQuoteR.getAuthor(),newQuoteR.getQuote());
        UUID newlyPersistedQuoteID = quoteRepository.save(newQuote).getId();
        return ResponseEntity.ok(newlyPersistedQuoteID.toString());
    }
}
