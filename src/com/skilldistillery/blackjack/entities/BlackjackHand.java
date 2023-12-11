package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	private List<Card> cards;

	public BlackjackHand() {
		cards = new ArrayList<>();
	}

	public void clear() {
		cards.clear();
		System.out.println("Cleared hand.");
	}

	public int getHandValue() {
		int value = 0;
		int numberOfAces = 0;

		for (Card card : cards) {
			value += card.getValue();
			if (card.getRank() == Rank.ACE) {
				numberOfAces++;
			}
		}

		while (numberOfAces > 0 && value > 21) {
			value -= 10;
			numberOfAces--;
		}

		System.out.println("Hand value: " + value);
		return value;
	}

	public boolean isBlackjack() {
		boolean blackjack = getHandValue() == 21 && cards.size() == 2;
		System.out.println("Is Blackjack: " + blackjack);
		return blackjack;
	}

	public boolean isBust() {
		boolean bust = getHandValue() > 21;
		System.out.println("Is Bust: " + bust);
		return bust;
	}

	public boolean isHard() {
		boolean hard = getHandValue() <= 21 && !isSoft();
		System.out.println("Is Hard: " + hard);
		return hard;
	}

	public boolean isSoft() {
		boolean soft = false;
		for (Card card : cards) {
			if (card.getRank() == Rank.ACE && card.getValue() == 11) {
				soft = true;
				break;
			}
		}
		System.out.println("Is Soft: " + soft);
		return soft;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		cards.add(card);
		System.out.println("Added card to hand: " + card);
	}

}
