package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Hand {
	private List<Card> cards;

	public Hand(List<Card> cards) {
		this.cards = cards;
	}

	public int calculateHandValue() {
		int value = 0;
		int numAces = 0;

		for (Card card : cards) {
			value += card.getValue();
			if (card.getRank() == Rank.ACE) {
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
}
