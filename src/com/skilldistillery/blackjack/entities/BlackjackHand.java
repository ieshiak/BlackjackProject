package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {
	private int value;
//work
	public BlackjackHand() {
		super();
		// System.out.println("Debug: BlackjackHand created.");
		value = 0;
	}

//works
	@Override
	public int getHandValue() {
		int value = 0;
		int aceCount = 0;

		// For each card in this hand
		for (Card card : cards) {
			// Add the card value to the hand
			value += card.getValue();
			// Count how many aces have been added
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

	public void reset() {
        value = 0;
    }

//work
	public boolean isBlackjack() {
		boolean isBlackjack = (cards.size() == 2 && getHandValue() == 21);
		// System.out.println("Debug: Is Blackjack: " + isBlackjack);
		return isBlackjack;
	}

//work
	public boolean isBust() {
		boolean isBust = (getHandValue() > 21);
		// System.out.println("Debug: Is Bust: " + isBust);
		return isBust;
	}

//work
	public boolean isHard() {
		for (Card card : cards) {
			if (card.getRank() == Rank.ACE && card.getValue() == 11) {
				// System.out.println("Debug: Hand is not hard.");
				return false;
			}
		}
		// System.out.println("Debug: Hand is hard.");
		return true;
	}

//work
	public boolean isSoft() {
		for (Card card : cards) {
			if (card.getRank() == Rank.ACE && card.getValue() == 11) {
				// System.out.println("Debug: Hand is soft.");
				return true;
			}
		}
		// System.out.println("Debug: Hand is not soft.");
		return false;
	}
	public void clear(){
		
	}
	
}
