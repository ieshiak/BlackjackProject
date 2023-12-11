package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackjackHand extends Hand {
	public BlackjackHand(List<Card> cards) {
		super(cards);
	}

	public boolean isBlackjack() {
		return getCards().size() == 2 && calculateHandValue() == 21;
	}

	public boolean isBust() {
		return calculateHandValue() > 21;
	}
}
