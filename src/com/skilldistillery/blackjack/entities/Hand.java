package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    protected List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
        System.out.println("Debug: Hand created.");
    }

    public void addCard(Card card) {
        cards.add(card);
        System.out.println("Debug: Added card to hand: " + card);
    }

    public void clear() {
        cards.clear();
        System.out.println("Debug: Cleared hand.");
    }

    public int getHandValue() {
        int value = 0;
        int ace = 0;

        for (Card card : cards) {
            Rank rank = card.getRank();
            if (rank != null) {
                value += rank.getValue();
                if (rank == Rank.ACE) {
                    ace++;
                }
                System.out.println("Debug: Card value added: " + rank.getValue());
            }
        }

        while (value > 21 && ace > 0) {
            value -= 10;
            ace--;
            System.out.println("Debug: Adjusted value for ACE.");
        }

        System.out.println("Debug: Hand value calculated: " + value);
        return value;
    }

    @Override
    public String toString() {
        System.out.println("Debug: Hand toString called.");
        return cards.toString();
    }
}
