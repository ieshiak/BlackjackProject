package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {
	private Deck deck;
	private List<Card> hand;
	
	
	public Dealer(Deck deck) {
	this.deck = deck;
    this.hand = new ArrayList<>();
}

public void shuffleDeck() {
    deck.shuffle();
}

public Card dealCard() {
    return deck.dealCard();
}

public void addCardToHand(Card card) {
    hand.add(card);
}

public int getHandValue() {
    int value = 0;
    int numAces = 0;

    for (Card card : hand) {
        int cardValue = card.getValue();
        value += cardValue;

        if (cardValue == 11) { // Ace
            numAces++;
        }
    }

    // Adjust for Aces
    while (value > 21 && numAces > 0) {
        value -= 10;
        numAces--;
    }

    return value;
}

public void displayPartialHand() {
    System.out.println("[" + hand.get(0) + "]");
    System.out.println("[Face Down]");
    System.out.println("----------------------------------------------");
}

public void displayHand() {
    for (Card card : hand) {
        System.out.println("[" + card + "]");
    }
    System.out.println("Valued at: " + getHandValue());
}
}