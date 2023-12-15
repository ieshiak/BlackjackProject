package com.skilldistillery.blackjack.entities;


import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    protected List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
        //System.out.println("Debug: Hand created.");
    }

    public void addCard(Card card) {
        cards.add(card);
        //System.out.println("Debug: Card added to hand: " + card);
    }

    public void clear() {
        cards.clear();
        //System.out.println("Debug: Hand cleared.");
    }

    public abstract int getHandValue();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Card card : cards) {
            builder.append(card).append("\n");
        }
        return builder.toString();
    }

    public List<Card> getCards() {
        return cards;
   
    }
}