package com.nikolas.studysetapp;

public class Card {
    private String term;
    private String definition;

    public Card(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return this.term;
    }

    public String getDefinition() {
        return this.definition;
    }

}
