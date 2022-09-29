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
    private static int MAX = id;
    private static int MIN = 1;

    public QuoteController(){
        quoteList = new ArrayList<>();

        //Creating a list of quotes/author
        quoteList.add(new Quote(id++, "Be yourself; everyone else is already taken.", "Oscar Wilde"));
        quoteList.add(new Quote(id++, "Be the change that you wish to see in the world.", "Mahatma Gandhi "));
        quoteList.add(new Quote(id++, "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.", "Martin Luther King Jr."));
        quoteList.add(new Quote(id++, "The fool doth think he is wise, but the wise man knows himself to be a fool.", "William Shakespeare"));
        quoteList.add(new Quote(id++, "If you can't explain it to a six year old, you don't understand it yourself.", "Albert Einstein"));
        quoteList.add(new Quote(id++, "Not all those who wander are lost.", "J.R.R. Tolkien"));
        quoteList.add(new Quote(id++, "Definitions belong to the definers, not the defined.", "Toni Morrison"));
        quoteList.add(new Quote(id++, "A book must be the axe for the frozen sea within us.", "Franz Kafka"));
        quoteList.add(new Quote(id++, "A certain type of perfection can only be realized through a limitless accumulation of the imperfect.", "Haruki Murakami"));
        quoteList.add(new Quote(id++, "Each person feels pain in his own way, each has his own scars.", "Haruki Murakami"));
        quoteList.add(new Quote(id++, "Life appears to me too short to be spent in nursing animosity or registering wrongs.", "Charlotte Bronte"));
        quoteList.add(new Quote(id++, "Happiness quite unshared can scarcely be called happiness; it has no taste.", "Charlotte Bronte"));
        quoteList.add(new Quote(id++, "Do the best you can until you know better. Then when you know better, do better.", "Maya Angelou"));
        quoteList.add(new Quote(id++, "If you're always trying to be normal, you will never know how amazing you can be.", "Maya Angelou"));
        quoteList.add(new Quote(id++, "For while we have our eyes on the future, history has its eyes on us", "Amanda Gorman"));
    }

    //Requests a quote, get a quote at random (generates a random id)
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuoteOftheDay() {
        int MAX = id;
        int MIN = 1;

        int randomID = (int) (Math.random() * (MAX - MIN)) + MIN;

        Quote quoteOfTheDay = new Quote();

        for (Quote quote : quoteList) {
            if (quote.getId() == randomID) {
                quoteOfTheDay = quote;
                break;
            }
        }

        return quoteOfTheDay;
    }
}
