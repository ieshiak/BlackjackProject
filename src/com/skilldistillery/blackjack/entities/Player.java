package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class Player extends Deck implements Decisions {

	private BlackjackHand hand;
	private String name;
	private int chips;
	private int betAmount;
	private Scanner scanner;
	private BettingSystem bettingSystem;

	public Player(String name) {
		this.name = name;
		this.bettingSystem = bettingSystem;
		hand = new BlackjackHand();
		chips = 0;
		betAmount = 0;
		Scanner scanner = new Scanner(System.in);
	}

	public void takeTurn(Deck deck, boolean isHuman, Scanner scanner) {

		// Betting step
		if (isHuman) {
			System.out.print(name + ", enter your bet (up to 100 chips): ");
	        int amount = scanner.nextInt();
	        int maxBet = 100;

	        if (amount > 0 && amount <= chips && amount <= maxBet) {
	            bettingSystem.placeBet(this, amount);
	            System.out.println(name + " placed a bet of " + amount + " chips.");
	        } else {
	            System.out.println("Invalid bet amount for " + name + ". Please place a valid bet (up to " + maxBet + " chips).");
	        }
	    } else {
			// AI logic for betting
			int maxBet = 50; // Set a maximum bet for AI players
			int minBet = 10; // Set a minimum bet for AI players
			int amount = (int) (Math.random() * (maxBet - minBet + 1)) + minBet;

			if (amount <= chips) {
				bettingSystem.placeBet(this, amount); // Call placeBet from BettingSystem
			} else {
				// AI player cannot place a bet. Insufficient chips.
				System.out.println("AI player " + name + " cannot place a bet. Insufficient chips.");
			}
		}

		// Playing step
		while (!hand.isBust() && (isHuman || wantsToHit())) {
			Card card = deck.dealCard();
			addCardToHand(card);
			System.out.println(name + " draws: " + card);

			// If it's the human player, display the hand value after each draw
			if (isHuman) {
				System.out.println(name + "'s total hand value: " + getHandTotal());
			}
		}

		if (!hand.isBust()) {
			stand();
		}
	}

	private boolean wantsToHit() {

		System.out.print(name + ", do you want to hit? (y/n): ");
		String input = scanner.nextLine().toLowerCase();

		// Check if the input is 'y' (yes)
		return input.equals("y");
	}

	public void placeBet(Scanner scanner, boolean isHuman) {
		if (isHuman) {
			// Human player input
			System.out.print(name + ", enter your bet (up to 100 chips): ");
			int amount = scanner.nextInt();
			int maxBet = 100;

			if (amount > 0 && amount <= chips && amount <= maxBet) {
				betAmount = amount;
				chips -= amount;
				System.out.println(name + " placed a bet of " + amount + " chips.");
			} else {
				System.out.println(
						"Invalid bet amount for " + name + ". Please place a valid bet (up to " + maxBet + " chips).");
			}
		} else {
			// AI player automatic bet assignment (you can modify this logic)
			int maxBet = 50; // Set a maximum bet for AI players
			int minBet = 10; // Set a minimum bet for AI players
			int amount = (int) (Math.random() * (maxBet - minBet + 1)) + minBet;

			if (amount <= chips) {
				betAmount = amount;
				chips -= amount;
				System.out.println(name + " placed a bet of " + amount + " chips.");
			} else {
				System.out.println("AI player " + name + " cannot place a bet. Insufficient chips.");
			}
		}
	}

	private boolean shouldHit() {
		// Implement logic for non-human players (AI)
		// Return true if the AI decides to hit, false otherwise
		return false;
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
