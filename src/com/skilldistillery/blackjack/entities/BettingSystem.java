package com.skilldistillery.blackjack.entities;

public class BettingSystem {
	private int playerBalance;

	public BettingSystem(int initialBalance) {
		this.playerBalance = initialBalance;
	}

	public int getPlayerBalance() {
		return playerBalance;
	}

	public void adjustBalance(int amount) {
		playerBalance += amount;
	}
}
