package com.company.Summative1.controllers;

import com.company.Summative1.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WordApiController {
    private List<Definition> wordList;

    private static int id = 1;
    private static int MAX = id;
    private static int MIN = 1;

    public WordApiController(){
        wordList = new ArrayList<>();

        //Creating list of words + definitions
        wordList.add(new Definition(id++, "Zenith", "The highest point of something"));
        wordList.add(new Definition(id++, "Bailiwick", "A person's area of skill, knowledge, authority, or work"));
        wordList.add(new Definition(id++, "Bamboozle", "To deceive, to confuse"));
        wordList.add(new Definition(id++, "Calamity", "A great misfortune or disaster"));
        wordList.add(new Definition(id++, "Ephemeral", "Lasting a very short time"));
        wordList.add(new Definition(id++, "Ersatz", "Serving as a substitute "));
        wordList.add(new Definition(id++, "Halcyon", "Calm"));
        wordList.add(new Definition(id++, "Infinitesimal", "Indefinitely or exceedingly small"));
        wordList.add(new Definition(id++, "Juggernaut", " Any large, overpowering, destructive force or object"));
        wordList.add(new Definition(id++, "Kerfuffle", "a fuss, a commotion"));
        wordList.add(new Definition(id++, "Raconteur", "a person who is skilled in relating stories and anecdotes interestingly"));
        wordList.add(new Definition(id++, "Ruckus", "a noisy, disorderly disturbance"));
        wordList.add(new Definition(id++, "Serendipity", "an aptitude for making desirable discoveries by accident"));
        wordList.add(new Definition(id++, "Smithereens", "small pieces"));
        wordList.add(new Definition(id++, "Surreptitious", "acting in a stealthy way"));
    }

    //Requests a word + definition at random (generates a random id)
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getRandomWord() {
        int MAX = id;
        int MIN = 1;

        int randomID = (int) (Math.random() * (MAX - MIN)) + MIN;

        Definition randomWord = new Definition();
        for (Definition word : wordList) {
            if (word.getId() == randomID) {
                randomWord = word;
                break;
            }
        }
        return randomWord;
    }


}
