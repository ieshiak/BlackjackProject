package com.skilldistillery.blackjack.entities;


public enum Rank {
    // Enum constants representing each rank with its associated name and value
    ACE("Ace", 11),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four",4),
    FIVE("Five",5),
    SIX("Six",6),
    SEVEN("Seven",7),
    EIGHT("Eight",8),
    NINE("Nine",9),
    TEN("Ten",10),
    JACK("Jack",10),
    QUEEN("Queen",10),
    KING("King",10);

    // Instance variables for each enum constant
    private String name;
    private int value;

    // Constructor for each enum constant, initializing the rank name and value
    private Rank(String name, int getValue){
        this.name = name;
        this.setValue(getValue);
    }

    // Override the toString method to return the rank name
    public String toString(){
        return name;
    }

    // Getter method to retrieve the rank value
    public int getValue() {
        return value;
    }

    // Setter method to set the rank value
    public void setValue(int rankValue) {
        this.value = rankValue;
    }
}
