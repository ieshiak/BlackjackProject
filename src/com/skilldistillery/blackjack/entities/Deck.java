package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		System.out.println("Debug: Shuffling the deck.");
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		System.out.println("Debug: Dealing a card.");
		return cards.remove(0);
	}

	public int cardsLeftInDeck() {
		return cards.size();
	}

	public int size() {
		return cards.size();
	}

	public Card drawCard() {
        if (cards.isEmpty()) {
            
            System.out.println("The deck is empty. Reshuffling...");
            initializeDeck();
        }
        return cards.remove(0);
	}

	private void initializeDeck() {
	    cards = new ArrayList<>();

	    for (Suit suit : Suit.values()) {
	        for (Rank rank : Rank.values()) {
	            cards.add(new Card(rank, suit));
	        }
	    }

	    shuffle();
	}
}
