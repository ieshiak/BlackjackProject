package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();

	}

	public void takeCardFromDeck(Deck deck) {
		hand.add(deck.dealCard());
	}

	public ArrayList<Card> getHand() {
		return this.hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public int valueOfCurrentHand() {
		int value = 0;
		int aceCount = 0;

		for (Card card : hand) {
			value += card.getValue();
			if (card.getValue() == 11) {
				aceCount++;
			}
		}
		if (value > 21 && aceCount > 0) {
			while (aceCount > 0 && value > 21) {
				aceCount--;
				value -= 10;
			}
		}
		return value;

	}

	public String toString() {
		StringBuilder output = new StringBuilder();

		for (Card card : hand) {
			output.append(card.toString());
			output.append(" - ");
		}

		if (output.length() > 0) {
			output.delete(output.length() - 3, output.length());
		}

		return output.toString();
	}

	public Card getCard(int idx) {
		return hand.get(idx);
	}

	public void discardHandToDeck(Deck usedCardsDeck) {

		usedCardsDeck.addAllCards(hand);

		hand.clear();
	}
}
