package be.pxl.spring.rest.fallout.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Transactional(readOnly = true)
    public List<Quote> getAll() {
        return quoteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Quote> findByAuthor(String author) {
        return quoteRepository.findByAuthor(author);
    }

    @Transactional
    public Quote create(Quote newQuote) {
        return quoteRepository.save(newQuote);
    }
}
