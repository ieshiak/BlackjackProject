package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class Player extends Deck implements Decisions {

	private BlackjackHand hand;
	private String name;
	private int chips;
	private int betAmount;

	public Player(String name) {
		this.name = name;
		hand = new BlackjackHand();
		chips = 0;
		betAmount = 0;
	}

	public void takeTurn(Deck deck) {
		while (!hand.isBust() && wantsToHit()) {
			Card card = deck.dealCard();
			addCardToHand(card);
			System.out.println(name + " draws: " + card);
		}
		if (!hand.isBust()) {
			stand();
		}
	}

	private boolean wantsToHit() {
		Scanner scanner = new Scanner(System.in);

		System.out.print(name + ", do you want to hit? (y/n): ");
		String input = scanner.nextLine().toLowerCase();

		boolean wantsToHit = input.equals("y");
		System.out.println(name + " wants to hit: " + wantsToHit); // Debug print
		return wantsToHit;
	}

	public void resetHand() {
		hand.clear();
		System.out.println(name + "'s hand is reset."); // Debug print
	}

	@Override
	public void addCardToHand(Card dealtCard) {
		hand.addCard(dealtCard);
		System.out.println(name + " receives a " + dealtCard); // Debug print
	}

	@Override
	public void stand() {
		System.out.println(name + " stands."); // Debug print
	}

	@Override
	public int getHandTotal() {
		int total = hand.getHandValue();
		System.out.println(name + "'s total hand value: " + total); // Debug print
		return total;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean hasPlacedBet() {
		return betAmount > 0;
	}

	public void placeBet(int amount) {
		if (amount > 0 && amount <= chips) {
			betAmount = amount;
			chips -= amount;
			System.out.println(name + " placed a bet of " + amount + " chips."); // Debug print
		} else {
			System.out.println("Invalid bet amount for " + name + ". Please place a valid bet."); // Debug print
		}

	}
	public void hit(Deck deck) {
        Card card = deck.drawCard();
        addCardToHand(card);
        System.out.println(name + " draws: " + card);
    }


	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}
}
