//all deck debugs working
package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deck {
	// List to hold the cards in the deck
	private List<Card> cards;
	private List<Card> usedCards;
	private List<Card> discard = new ArrayList<>();
	private Deck deck;

//work
	// Constructor: initializes the deck by creating a list of cards
	public Deck() {
		cards = createDeck();
		discard = new ArrayList<>();
		// System.out.println("Debug: Deck created with " + cards.size() + " cards.");
		// displayDeck(); // Add this line to display cards
	}

	public List<Card> getDiscard() {
		return discard;
	}

	public List<Card> getCards() {
		return cards;
	}

//work
	public void displayDeck() {
		// System.out.println("Debug: Cards in the deck:");
		for (Card card : cards) {
			System.out.println(card);
		}
	}

//work
	// Private method to create a standard deck of 52 cards
	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				// Creates a new card and adds it to the deck
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

//work
	// Returns the current size of the deck
	public int checkDeckSize() {
		int deckSize = cards.size();
		// System.out.println("Debug: Deck size is " + deckSize + " cards.");
		return deckSize;
	}

//work
	// Shuffles the deck using the Collections.shuffle method
	public void shuffle() {
		// System.out.println("Debug: Shuffling the deck.");
		Collections.shuffle(cards);
	}

//work
	// Removes and returns the top card from the deck (dealing a card)
	public Card dealCard() {
		// System.out.println("Debug: Dealing a card.");
		return cards.remove(0);
	}

//work
	// Returns the current number of cards left in the deck
	public int cardsLeftInDeck() {
		int remainingCards = cards.size();
		// System.out.println("Debug: Cards left in the deck: " + remainingCards);
		return remainingCards;
	}

//work
	// Returns the size of the deck (number of cards)
	public int size() {
		int deckSize = cards.size();
		// System.out.println("Debug: Deck size is " + deckSize + " cards.");
		return deckSize;
	}
}
