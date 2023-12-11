package com.skilldistillery.blackjack.entities;

import java.util.HashMap;
import java.util.Map;

public class BettingSystem {
	private Map<Player, Integer> bets;
	private boolean isBettingOpen;

	public BettingSystem() {
		bets = new HashMap<>();
		isBettingOpen = false;
	}

	public void placeBet(Player player, int amount) {
		if (isBettingOpen) {
			int currentChips = player.getChips();
			if (amount > 0 && amount <= currentChips) {
				bets.put(player, amount);
				player.setChips(currentChips - amount);
				System.out.println(player + " placed a bet of " + amount + " chips.");
			} else {
				System.out.println("Invalid bet amount for " + player + ". Please place a valid bet.");
			}
		} else {
			System.out.println("Betting is closed. Cannot place a bet at the moment.");
		}
	}

	public boolean hasPlayerPlacedBet(Player player) {
		return bets.containsKey(player);
	}

	public void collectBets() {
		isBettingOpen = false;
		for (Map.Entry<Player, Integer> entry : bets.entrySet()) {
			Player player = entry.getKey();
			int betAmount = entry.getValue();
			player.setChips(player.getChips() + (2 * betAmount));
			System.out.println(player + " wins " + (2 * betAmount) + " chips.");
		}
		bets.clear();
	}

	public void openBetting() {
		isBettingOpen = true;
		System.out.println("Betting is now open.");
	}

	public void closeBetting() {
		isBettingOpen = false;
		System.out.println("Betting is now closed.");
	}

	public boolean isBettingOpen() {
		return isBettingOpen;
	}

	public int getBetAmount(Player player) {
	    return bets.getOrDefault(player, 0);
	}
}
