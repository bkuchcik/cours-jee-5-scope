package fr.isima.controller;

import fr.isima.business.Quote;
import fr.isima.business.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quotes")
public class QuotesMVCController {

    private final Quotes quotes;

    @Autowired
    public QuotesMVCController(Quotes quotes) {
        this.quotes = quotes;
    }

    @GetMapping("{quoteNumber}")
    public ModelAndView displayQuote(@PathVariable(required = false) Integer quoteNumber) {
        return getQuote("quote", quoteNumber);
    }

     ModelAndView getQuote(String viewName, Integer quoteNumber) {
        return new ModelAndView(viewName, "quote", createQuoteViewBean(quoteNumber));
    }


    private QuoteViewBean createQuoteViewBean(Integer quoteNumber) {
        if (quoteNumber == null) {
            return QuoteViewBean
                    .withExternalQuote(new Quote("L'auteur de l'application", "Vous devez fournir un numero de quote pour que je puisse l'afficher"));
        }
        return QuoteViewBean.withNumero(quotes, quoteNumber);
    }
}
