// Dealer working debug prints
package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	private Hand hand;
	private Deck deck;

//works
	public Dealer() {
		this.hand = new BlackjackHand();
		// System.out.println("Debug: Dealer created.");
	}

//works
	public void addCardToHand(Card card) {
		hand.addCard(card);
		// System.out.println("Debug: Card added to dealer's hand: " + card);
	}

//works
	public void clearHand() {
		hand.clear();
		// System.out.println("Debug: Dealer's hand cleared.");
	}

//works
	public int getHandValue() {
		int value = hand.getHandValue();
		// System.out.println("Debug: Dealer's hand value: " + value);
		return value;
	}

//works
	public boolean isBust() {
		boolean isBust = ((BlackjackHand) hand).isBust();
		// System.out.println("Debug: Dealer is bust: " + isBust);
		return isBust;
	}

//works
	public boolean isBlackjack() {
		boolean isBlackjack = ((BlackjackHand) hand).isBlackjack();
		// System.out.println("Debug: Dealer has blackjack: " + isBlackjack);
		return isBlackjack;
	}

//works
	public void partialHand() {
		List<Card> cards = hand.getCards();

		// Check if the hand is not empty before displaying
		if (!cards.isEmpty()) {
			// Display the first card (partial hand)
			System.out.println(cards.get(0));

			// Optionally, you can also display the remaining cards if needed
			for (int i = 1; i < cards.size(); i++) {
				// Display additional cards in the hand
				// System.out.println(cards.get(i));
			}
		} else {
			System.out.println("No cards in the hand.");
		}

	}

//works but same card is being displayed
	public void dealerPartialHand() {
		partialHand();
		faceDown();
		System.out.println("----------------------------------------------");
		System.out.println("      Dealer's Hand Valued : " + getFirstCardValue());
		System.out.println("----------------------------------------------");
	}

//work
	public void faceDown() {
		System.out.println();
		System.out.println("┌─────────┐");
		System.out.println("│ HIDDEN  │");
		System.out.println("│         │");
		System.out.println("│         │");
		System.out.println("│    ?    │");
		System.out.println("│         │");
		System.out.println("│         │");
		System.out.println("│  HIDDEN │");
		System.out.println("└─────────┘");
	}

//work
	public int getFirstCardValue() {
		List<Card> cards = hand.getCards();

		// System.out.println("Debug: Cards in hand: " + cards);

		if (!cards.isEmpty()) {
			Card firstCard = cards.get(0);
			if (firstCard != null) {
				// System.out.println("Debug: First card in hand: " + firstCard);
				return firstCard.getValue();
			} else {
				// System.out.println("Debug: First card is null.");
			}
		} else {
			// System.out.println("Debug: Hand is empty.");
		}

		return 0;
	}

	public void revealDealerFullHand() {
		List<Card> cards = hand.getCards();

		for (Card card : cards) {
			System.out.println(card);
		}

		System.out.println("----------------------------------------------");
		System.out.println("Dealer's Hand Value: " + getHandValue());
		System.out.println("----------------------------------------------");
	}
}
	
	

