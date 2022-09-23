package com.company.Summative1.models;

public class Quote {

    private String quote;
    private String author;
    private int id;


    public Quote(){}

    public Quote(int id, String quote, String author){
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
