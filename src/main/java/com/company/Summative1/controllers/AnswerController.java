package com.company.Summative1.controllers;

import com.company.Summative1.models.Answer;
import com.company.Summative1.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@RestController
public class AnswerController {

    private List<Answer> answerList;

    private static int id = 1;

    public AnswerController(){
        answerList = new ArrayList<>();

        //Creating a list of answers
        answerList.add(new Answer(id++, "Yes"));
        answerList.add(new Answer(id++, "No"));
        answerList.add(new Answer(id++, "Maybe"));
        answerList.add(new Answer(id++, "Try Again"));
        answerList.add(new Answer(id++, "Without a doubt"));
        answerList.add(new Answer(id++, "Very doubtful"));
        answerList.add(new Answer(id++, "Most likely"));
        answerList.add(new Answer(id++, "My sources say no"));
    }

    //Request body is a question, Response body is the question, an ID (first ID available) and the random answer.
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer getAnswer(@RequestBody String question) {

        //Grab the Definition Maximum ID from the list
        Answer maxValue = answerList.stream().max(Comparator.comparingInt(Answer::getId))
                .get();

        //Grab the Definition Minimum ID from the list
        Answer minValue = answerList.stream().min(Comparator.comparingInt(Answer::getId))
                .get();

        int MAX = maxValue.getId();
        int MIN = minValue.getId();

        //Generate random number between min ID and max ID
        Random random = new Random();
        int randomID = random.nextInt((MAX - MIN) + 1) + MIN;

        Answer randomAnswer =  new Answer();

        //Set question as the string sent by user
        randomAnswer.setQuestion(question);
        randomAnswer.setId(0);

        //assign the Answer with randomID from answerList to randomAnswer
        for (Answer a : answerList) {
            if (a.getId() == randomID) {
                 randomAnswer.setAnswer(a.getAnswer());
                break;
            }
        }

        return randomAnswer;
    }
}
