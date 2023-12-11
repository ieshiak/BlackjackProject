package com.skilldistillery.blackjack.entities;

public interface Decisions {

	void addCardToHand(Card dealtCard);
	void stand();
	int getHandTotal();
	
}

