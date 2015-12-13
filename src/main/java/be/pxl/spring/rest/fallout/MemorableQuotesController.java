package be.pxl.spring.rest.fallout;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemorableQuotesController {

    private static final List<String> quotes;

    static {
        quotes = new ArrayList<>();
        quotes.add("War...War never changes"); // Narrator
        quotes.add("They asked me how well I understood theoretical physics. I said I had a theoretical degree in physics. They said welcome aboard"); // Mr. Fantastic
        quotes.add("Freedom is the sovereign right of every American"); // Liberty Prime
        quotes.add("Too many people have opnions on things they know nothing about. And the more ignorant they are, the more opinions they have"); // Thomas Hildern
        quotes.add("Here, take a few radiation chems, as my little way of saying, \"I'm sorry I twisted your DNA like a kitten with a ball of yarn.\""); // Moira Brown
    }

    @RequestMapping("/")
    public List<String> all(){
        return quotes;
    }
}
