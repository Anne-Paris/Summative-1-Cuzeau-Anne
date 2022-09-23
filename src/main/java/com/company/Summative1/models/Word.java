package com.company.Summative1.models;

public class Word {

    private String word;
    private String definition;
    private int id;


    public Word(){}

    public Word(int id, String word, String definition){
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
