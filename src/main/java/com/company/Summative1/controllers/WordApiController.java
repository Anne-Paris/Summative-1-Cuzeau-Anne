package com.company.Summative1.controllers;

import com.company.Summative1.models.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WordApiController {
    private List<Word> wordList;

    private static int id = 1;

    public WordApiController(){
        wordList = new ArrayList<>();

        wordList.add(new Word(id++, "Zenith", "The highest point of something"));
        wordList.add(new Word(id++, "Bailiwick", "A person's area of skill, knowledge, authority, or work"));
        wordList.add(new Word(id++, "Bamboozle", "To deceive, to confuse"));
        wordList.add(new Word(id++, "Calamity", "A great misfortune or disaster"));
        wordList.add(new Word(id++, "Ephemeral", "Lasting a very short time"));
        wordList.add(new Word(id++, "Ersatz", "Serving as a substitute "));
        wordList.add(new Word(id++, "Halcyon", "Calm"));
        wordList.add(new Word(id++, "Infinitesimal", "Indefinitely or exceedingly small"));
        wordList.add(new Word(id++, "Juggernaut", " Any large, overpowering, destructive force or object"));
        wordList.add(new Word(id++, "Kerfuffle", "a fuss, a commotion"));
        wordList.add(new Word(id++, "Raconteur", "a person who is skilled in relating stories and anecdotes interestingly"));
        wordList.add(new Word(id++, "Ruckus", "a noisy, disorderly disturbance"));
        wordList.add(new Word(id++, "Serendipity", "an aptitude for making desirable discoveries by accident"));
        wordList.add(new Word(id++, "Smithereens", "small pieces"));
        wordList.add(new Word(id++, "Surreptitious", "acting in a stealthy way"));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word getRandomWord() {
        int MAX = id;
        int MIN = 1;

        int randomID = (int) (Math.random() * (MAX - MIN)) + MIN;

        Word randomWord = new Word();
        for (Word word : wordList) {
            if (word.getId() == randomID) {
                randomWord = word;
                break;
            }
        }
        return randomWord;
    }


}
