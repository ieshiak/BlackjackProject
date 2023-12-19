package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();

	}

	public void addCard(Card card) {
		deck.add(card);
	}

	public Deck(boolean createDeck) {
		deck = new ArrayList<Card>();
		if (createDeck) {
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					deck.add(new Card(rank, suit));
				}
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck, new Random());
	}

	public Card dealCard() {
		Card cardToTake = new Card(deck.get(0));
		deck.remove(0);
		return cardToTake;

	}

	public boolean hasCards() {
		if (deck.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void emptyDeck() {
		deck.clear();
	}

	public void addAllCards(List<Card> cards) {
		deck.addAll(cards);
	}

	public void reloadFromUsedCards(Deck usedCards) {
		List<Card> cardsToAdd = usedCards.getCards();

		for (Card card : cardsToAdd) {
			if (!deck.contains(card)) {
				deck.add(card);
			}
		}

		shuffle();
		usedCards.emptyDeck();
		System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
	}

	public int cardsLeft() {
		return deck.size();
	}

	public List<Card> getCards() {
		return new ArrayList<>(deck);
	}

}
