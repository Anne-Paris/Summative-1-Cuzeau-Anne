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

        wordList.add(new Word(id++, "blablabla1", "def1"));
        wordList.add(new Word(id++, "blablabla2", "def2"));
        wordList.add(new Word(id++, "blablabla3", "def3"));
        wordList.add(new Word(id++, "blablabla4", "def4"));
        wordList.add(new Word(id++, "blablabla5", "def5"));
        wordList.add(new Word(id++, "blablabla6", "def6"));
        wordList.add(new Word(id++, "blablabla7", "def7"));
        wordList.add(new Word(id++, "blablabla8", "def8"));
        wordList.add(new Word(id++, "blablabla9", "def9"));
        wordList.add(new Word(id++, "blablabla10", "def10"));
        wordList.add(new Word(id++, "blablabla11", "def11"));
        wordList.add(new Word(id++, "blablabla12", "def12"));
        wordList.add(new Word(id++, "blablabla13", "def13"));
        wordList.add(new Word(id++, "blablabla14", "def14"));
        wordList.add(new Word(id++, "blablabla15", "def15"));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word getRandomWord() {
        int randomId = (int) (1 + (Math.random() * 15));

        Word randomWord = null;
        for (Word word : wordList) {
            if (word.getId() == randomId) {
                randomWord = word;
                break;
            }
        }
        return randomWord;
    }


}
