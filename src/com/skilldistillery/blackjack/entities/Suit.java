package com.skilldistillery.blackjack.entities;


public enum Suit {
    // Enum constants representing each suit with its associated name and symbol
    HEARTS("Hearts", "♥"),
    SPADES("Spades", "♠"),
    CLUBS("Clubs", "♣"),
    DIAMONDS("Diamonds", "♦");

    // Instance variables for each enum constant
    private String suit;
    private String symbol;

    // Constructor for each enum constant, initializing the suit name and symbol
    Suit(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }

    // Getter method to retrieve the suit name
    public String getName() {
        return suit;
    }

    // Getter method to retrieve the suit symbol
    public String getSymbol() {
        return symbol;
    }

    // Override the toString method to return the suit name
    @Override
    public String toString() {
        return suit;
    }
}
