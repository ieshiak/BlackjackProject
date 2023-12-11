package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BettingSystem;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;
import com.skilldistillery.blackjack.entities.BlackjackMessages;

public class BlackjackRules {
	private Scanner scanner = new Scanner(System.in);
	private Player player;
	private Dealer dealer;
	private BettingSystem bettingSystem;
	private BlackjackMessages messages = new BlackjackMessages();

	public BlackjackRules() {
		this.player = new Player();
		this.dealer = new Dealer(new Deck());
		this.bettingSystem = new BettingSystem(1000);
	}

	public void run() {
		
		
		System.out.println("    ------- ");
		System.out.println("   |A      |");
		System.out.println("   |       |");
		System.out.println("   |       |");
		System.out.println("   |       |");
		System.out.println("   |      A|");
		System.out.println("    ------- ");
		
		messages.welcomeMessage();
		System.out.println("----------------------------------------------");

		while (shouldContinueGame()) {
			startRound();
			takeBetFromPlayer();
			dealInitialCards();
			playerTurn();
			dealerTurn();
			determineWinner();
			printFinalHands();
			resetHands();
		}

		System.out.println("\nThanks for playing Blackjack!");
		System.out.println("----------------------------------------------");

		closeResources();
	}

	private void startRound() {
		System.out.println("\nStarting a new round...");
		System.out.println("----------------------------------------------");

		dealer.shuffleDeck();
	}

	private boolean shouldContinueGame() {
		System.out.println();
		messages.startGameMessage();
		String input = scanner.nextLine().trim().toLowerCase();
		System.out.println("----------------------------------------------");

		while (!input.equals("y") && !input.equals("n")) {

			input = scanner.nextLine().trim().toLowerCase();
		}

		return input.equals("y");
	}

	private void takeBetFromPlayer() {
		int betAmount = 0;

		while (betAmount < 50) {
			System.out.print("\nPlease enter your bet amount (minimum $50): ");

			if (scanner.hasNextInt()) {
				betAmount = scanner.nextInt();
				System.out.println("----------------------------------------------");

				if (betAmount < 50) {
					System.out.println("\nSorry, the minimum bet amount is $50. Please enter a valid amount.");
				}
			} else {
				System.out.println("\nInvalid input. Please enter a valid integer.");
				System.out.println("----------------------------------------------");

			}
		}

		bettingSystem.adjustBalance(-betAmount);
		System.out.println("\nA bet of $" + betAmount + " has been placed for " + player.getName() + ".");
		System.out.println("----------------------------------------------");
	}

	private void dealInitialCards() {

		player.addCardToHand(dealer.dealCard());
		player.addCardToHand(dealer.dealCard());

		dealer.addCardToHand(dealer.dealCard());
		dealer.addCardToHand(dealer.dealCard());
	}

	private void playerTurn() {
		while (true) {

			System.out.println("\nThe Dealer's hand looks like this:");
			System.out.println();

			dealer.displayPartialHand();

			System.out.println("\nPlayer's hand looks like this:");
			System.out.println();

			player.displayHand();
			System.out.println("----------------------------------------------");

			if (player.getHandValue() == 21) {
				System.out.println();
				messages.playerWinsMessage();
				System.out.println("----------------------------------------------");

				break;
			}

			// Ask the player to hit or stand
			System.out.println("\nWould you like to: 1) Hit or 2) Stand");
			System.out.println("----------------------------------------------");

			int choice = scanner.nextInt();

			if (choice == 1) {
				messages.playerHitsMessage();
				player.addCardToHand(dealer.dealCard());

				if (player.getHandValue() > 21) {
					System.out.println();
					messages.playerBustsMessage();
					System.out.println("----------------------------------------------");

					break;
				}
			} else if (choice == 2) {
				System.out.println();
				messages.playerStandsMessage();
				System.out.println("----------------------------------------------");

				break;
			} else {
				System.out.println("\nInvalid choice. Please enter 1 to hit or 2 to stand.");
				System.out.println("----------------------------------------------");

			}
		}
	}

	private void dealerTurn() {
		messages.dealerTurnMessage();
		while (dealer.getHandValue() < 17) {
			dealer.addCardToHand(dealer.dealCard());
		}
	}

	private void determineWinner() {

		int playerValue = player.getHandValue();
		int dealerValue = dealer.getHandValue();

		System.out.println("\nPlayer's hand value: " + playerValue);
		System.out.println("----------------------------------------------");

		System.out.println("\nDealer's hand value: " + dealerValue);
		System.out.println("----------------------------------------------");

		if (playerValue > 21) {
			System.out.println();
			messages.playerBustsMessage();
			System.out.println("----------------------------------------------");

		} else if (dealerValue > 21) {
			System.out.println();
			messages.dealerBustsMessage();
			System.out.println("----------------------------------------------");

		} else if (playerValue > dealerValue) {
			System.out.println();
			messages.playerWinsMessage();
			System.out.println("----------------------------------------------");

		} else if (playerValue < dealerValue) {
			System.out.println();
			messages.dealerWinsMessage();
			System.out.println("----------------------------------------------");

		} else {
			System.out.println();
			messages.itsATieMessages();
			System.out.println("----------------------------------------------");

		}
	}

	private void printFinalHands() {

		System.out.println("\nThe dealer's hand looks like this:");
		dealer.displayHand();
		System.out.println("----------------------------------------------");

		System.out.println("\nPlayer's hand looks like this:");
		player.displayHand();
		System.out.println("----------------------------------------------");

	}

	private void resetHands() {
		player.clearHand();
		dealer.clearHand();
	}

	private void closeResources() {

		scanner.close();
	}
}
