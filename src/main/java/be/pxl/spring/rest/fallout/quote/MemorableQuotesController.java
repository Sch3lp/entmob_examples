package be.pxl.spring.rest.fallout.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RequestMapping(MemorableQuotesController.QUOTE_BASE_URL)
@RestController
public class MemorableQuotesController {

    public static final String QUOTE_BASE_URL = "/quote";

    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private QuoteAssembler quoteAssembler;

    @RequestMapping
    public List<QuoteR> all() {
        return quoteRepository
                .findAll()
                .stream()
                .map(quoteAssembler::toRepresentation)
                .collect(toList());
    }

    @RequestMapping(params = {"author"})
    public List<QuoteR> byAuthor(@RequestParam("author") String author) {
        return quoteRepository
                .findByAuthor(author)
                .stream()
                .map(quoteAssembler::toRepresentation)
                .collect(toList());
    }
}
