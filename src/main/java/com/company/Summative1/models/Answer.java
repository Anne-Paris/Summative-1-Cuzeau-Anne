package com.company.Summative1.models;

public class Answer {
    private String question;
    private String answer;
    private int id;


    public Answer(){}

    public Answer(int id, String answer){
        this.id = id;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
