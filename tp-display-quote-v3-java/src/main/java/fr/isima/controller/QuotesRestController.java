package fr.isima.controller;

import fr.isima.business.Quotes;
import fr.isima.business.SelectedQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/quotes")
public class QuotesRestController {

    private final Quotes quotes;

    @Autowired
    public QuotesRestController(Quotes quotes) {
        this.quotes = quotes;
    }

    @GetMapping("{quoteNumber}")
    public SelectedQuote displayQuote(@PathVariable Integer quoteNumber) {
        return quotes.selectQuote(quoteNumber);
    }
}
