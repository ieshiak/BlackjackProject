// Player working debug prints
package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	private String name;
	private Hand hand;
	private Deck deck;

//works
	public Player() {
		this.hand = new BlackjackHand();
		// System.out.println("Debug: Player " + name + " created.");

	}

//works	
	// Method for the player to input their name during the game
	public void inputNameDuringGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		this.name = scanner.nextLine();
	}

//work	
	// Method for the player to decide whether to hit or stand
	public void hitOrStand() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		boolean getNum = true;

		// While getting a number...
		while (getNum) {
			try {
				System.out.println("\nWould you like to: 1) Hit or 2) Stand");
				System.out.println("----------------------------------------------");
				choice = scanner.nextInt();
				getNum = false;

			} catch (Exception e) {
				System.out.println("\nInvalid choice. Please enter 1 to hit or 2 to stand.");
				System.out.println("----------------------------------------------");
				scanner.next(); // Consume the invalid input
			}
		}

		// Print the player's name and choice for testing
		System.out.println(this.name + " you chose " + choice);
	}

	public String getName() {
		return name;
	}

//work	
	public void addCardToHand(Card card) {
		if (card != null) {
			hand.addCard(card);
			// System.out.println("Debug: Card added to " + getName() + "'s hand: " + card);
		} else {
			// System.out.println("Debug: Attempted to add a null card to the hand.");
		}
	}

//work
	public void clearHand() {
		hand.clear();
		// System.out.println("Debug: " + name + "'s hand cleared.");
	}

//work
	public int getHandValue() {
		int value = hand.getHandValue();
		// System.out.println("Debug: " + name + "'s hand value: " + value);
		return value;
	}

//works
	public boolean isBust() {
		boolean isBust = ((BlackjackHand) hand).isBust();
		// System.out.println("Debug: " + name + " is bust: " + isBust);
		return isBust;
	}

//works	
	public boolean isBlackjack() {
		boolean isBlackjack = ((BlackjackHand) hand).isBlackjack();
		// System.out.println("Debug: " + name + " has blackjack: " + isBlackjack);
		return isBlackjack;
	}

//works but same card is being displayed
	public void playersDisplayFirstHand() {
		List<Card> cards = hand.getCards();

		for (Card card : cards) {
			System.out.println(card);
		}

		System.out.println("----------------------------------------------");
		System.out.println("         " + name + "'s Hand Value: " + getHandValue());
		System.out.println("----------------------------------------------");
	}

//	public void playerDiscard() {
//		List<Card> usedCards = hand.getCards();
//		deck.addToDiscardPile(usedCards.toArray(new Card[0]));
//
//	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public boolean hasCards() {
		return deck.size() > 0;
	}

//public void hit(Card discard) {
//    // If there are no cards left in the deck
//    if (!hasCards()) {
//        reloadDeckFromDiscard(discard);
//    }
//
//    // Assuming 'takeCardFromDeck' is a method in the 'hand' object to add a card to the hand
//    cards.add(card);
//
//    System.out.println(name + " gets a card");
//    printHand();
//}
}
