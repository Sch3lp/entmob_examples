package be.pxl.spring.rest.fallout.quote;

import be.pxl.spring.rest.fallout.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.UUID;

import static be.pxl.spring.rest.fallout.quote.QuoteTestBuilder.aDefaultQuote;
import static be.pxl.spring.rest.fallout.quote.QuoteTestBuilder.aQuote;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
// Use production time wiring, but different database via src/test/resources/application.properties
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class MemorableQuotesControllerIntegrationTest {

    // Spring-test utility class that queries Spring's DispatcherServlet to perform assertions
    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    public QuoteRepository quoteRepository;

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {
        mappingJackson2HttpMessageConverter = asList(converters)
                .stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .get();

        assertThat(mappingJackson2HttpMessageConverter)
                .isNotNull()
                .describedAs("the JSON message converter must not be null");
    }

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @Test
    public void all_ListsAllTheQuotes() throws Exception {
        Quote quote = aDefaultQuote().build();
        UUID persistedUUID = quoteRepository.save(quote).getId();

        mockMvc.perform(get(MemorableQuotesController.QUOTE_BASE_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(asJson(
                        singletonList(QuoteR.of(persistedUUID.toString(),
                        "Jamie",
                        "As ze mn pet aanraken ja dan flip ik altijd"))
                )));
    }

    @Test
    public void query_ListsOnlyQuotesByAuthor() throws Exception {
        quoteRepository.save(aDefaultQuote().build()).getId();
        UUID narratorQuoteId1 = quoteRepository.save(aQuote()
                .withAuthor("Piper")
                .withQuotation("Watch your digits, Blue. Ferals.")
                .build())
                .getId();
        UUID narratorQuoteId2 = quoteRepository.save(aQuote()
                .withAuthor("Piper")
                .withQuotation("The Brotherhood sure knows how to take the fun out of dressing up in rivets and leather.")
                .build())
                .getId();

        String author = "Piper";
        QuoteR firstQuote = QuoteR.of(narratorQuoteId1.toString(), author, "Watch your digits, Blue. Ferals.");
        QuoteR secondQuote = QuoteR.of(narratorQuoteId2.toString(), author, "The Brotherhood sure knows how to take the fun out of dressing up in rivets and leather.");
        mockMvc.perform(get(MemorableQuotesController.QUOTE_BASE_URL).param("author", author))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(asJson(asList(firstQuote, secondQuote))));
    }

    @Test
    public void post_PersistsANewQuote() throws Exception {
        mockMvc.perform(post(MemorableQuotesController.QUOTE_BASE_URL)
                .content(asJson(QuoteR.of("Dreft", "Niks verdikt! M'n trui is gekrompen!")))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        assertThat(quoteRepository.findAll()).extracting(Quote::getQuotation).containsOnly("Niks verdikt! M'n trui is gekrompen!");
    }

    @SuppressWarnings("unchecked")
    protected String asJson(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}