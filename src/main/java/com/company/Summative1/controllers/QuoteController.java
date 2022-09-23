package com.company.Summative1.controllers;

import com.company.Summative1.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class QuoteController {

    private List<Quote> quoteList;

    private static int id = 1;

    public QuoteController(){
        quoteList = new ArrayList<>();

        quoteList.add(new Quote(id++, "blablabla1", "author1"));
        quoteList.add(new Quote(id++, "blablabla2", "author2"));
        quoteList.add(new Quote(id++, "blablabla3", "author3"));
        quoteList.add(new Quote(id++, "blablabla4", "author4"));
        quoteList.add(new Quote(id++, "blablabla5", "author5"));
        quoteList.add(new Quote(id++, "blablabla6", "author6"));
        quoteList.add(new Quote(id++, "blablabla7", "author7"));
        quoteList.add(new Quote(id++, "blablabla8", "author8"));
        quoteList.add(new Quote(id++, "blablabla9", "author9"));
        quoteList.add(new Quote(id++, "blablabla10", "author10"));
        quoteList.add(new Quote(id++, "blablabla11", "author11"));
        quoteList.add(new Quote(id++, "blablabla12", "author12"));
        quoteList.add(new Quote(id++, "blablabla13", "author13"));
        quoteList.add(new Quote(id++, "blablabla14", "author14"));
        quoteList.add(new Quote(id++, "blablabla15", "author15"));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuoteOftheDay() {
        int randomId = (int) (1 + (Math.random() * 15));

        Quote quoteOftheDay = null;
        for (Quote quote : quoteList) {
            if (quote.getId() == randomId) {
                quoteOftheDay = quote;
                break;
            }
        }
        return quoteOftheDay;
    }
}
