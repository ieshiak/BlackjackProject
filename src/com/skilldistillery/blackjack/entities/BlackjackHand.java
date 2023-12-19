package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {
	private int value;

	public BlackjackHand() {
		super();
	}

	public boolean isBlackjack() {
		if (valueOfCurrentHand() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		boolean isBust = (valueOfCurrentHand() > 21);
		return isBust;
	}
}
