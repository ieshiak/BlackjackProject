package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> hand;
	private String name;

	// Default constructor without a name
	public Player() {
		this.name = "DefaultPlayer";
		this.hand = new ArrayList<>();
	}

	// Constructor with a name
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
	}

	public void addCardToHand(Card card) {
		hand.add(card);
	}

	public List<Card> getHand() {
		return hand;
	}

	public void clearHand() {
		hand.clear();
	}

	public String getName() {
		return name;
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

	public void displayHand() {
        for (Card card : hand) {
            System.out.println("[" + card + "] (" + card.getValue() + ")");
        }
        System.out.println("Valued at: " + getHandValue());
    }
}
