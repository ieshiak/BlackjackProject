package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("♥", Color.RED),
    DIAMONDS("♦", Color.RED),
    CLUBS("♣", Color.BLACK),
    SPADES("♠", Color.BLACK);

   
    private String symbol;
    private Color color;

    Suit(String symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }
}
