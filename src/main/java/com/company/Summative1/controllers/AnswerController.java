package com.company.Summative1.controllers;

import com.company.Summative1.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnswerController {

    private List<Answer> answerList;

    private static int id = 1;
    private static int MAX = id;
    private static int MIN = 1;

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

        int randomID = (int) (Math.random() * (MAX - MIN)) + MIN;
        Answer randomAnswer =  new Answer();

        randomAnswer.setQuestion(question);
        randomAnswer.setId(0);

        for (Answer a : answerList) {
            if (a.getId() == randomID) {
                 randomAnswer.setAnswer(a.getAnswer());
                break;
            }
        }

        return randomAnswer;
    }
}
