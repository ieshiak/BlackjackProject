package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackGame {

	// Declare variables needed for the Game class

	private BlackjackHand bjh = new BlackjackHand(); // Object representing the player's hand
	private Dealer d = new Dealer(); // Dealer object
	private Player p = new Player(); // Player object
	private int wins, losses, ties; // Variables to track game outcomes
	private Deck deck = new Deck();
	private boolean playAgain;
	private Scanner scanner;
	
	
    
	
	public BlackjackGame() {
		this.playAgain = false;
		this.scanner = new Scanner(System.in);
		
	}

	// Method to start and play the game
	public void play() {
		
		titleScreen();
		p.inputNameDuringGame();
		deck.shuffle();
		deck.shuffle();
		shouldYouContinue();
		displayStats();
		deck.cardsLeftInDeck();
		playOrExit();
	}

//    // Method to check if the game should continue to the next round
	public void shouldYouContinue() {

		resetHands();
		//refreshGame();
		deck.shuffle();

		// Check if the player wants to continue
		if (wins > 0 || losses > 0 || ties > 0) {
			System.out.println();
			// d.dealerDiscard();
			// p.playerDiscard();
		}
		if (deck.cardsLeftInDeck() < 4) {
			//deck.reloadDeckFromDiscard();
		}
		// Deal two cards to the player and the dealer
		p.addCardToHand(deck.dealCard());
		d.addCardToHand(deck.dealCard());
		p.addCardToHand(deck.dealCard());
		d.addCardToHand(deck.dealCard());
		// show hands
		d.dealerPartialHand();
		p.playersDisplayFirstHand();

		// Check hands

		if (d.isBlackjack()) {
			d.revealDealerFullHand();
			// player
			if (p.isBlackjack()) {
				System.out.println("You both have 21 - Tie.");
				ties++;
				printFinalHands();
				resetHands();
				clearScreen();
				// shouldYouContinue();
			} else {
				System.out.println("Dealer has Blackjack. You lose.");
				losses++;
			}
		}

		if (p.isBlackjack()) {
			System.out.println("You have Blackjack! You win!");
			wins++;
			// Start a new round
			printFinalHands();
			resetHands();
			clearScreen();
			// shouldYouContinue();
			return; // Return to avoid executing the rest of the method
		}

		// Let the player decide what to do next (hit or stand)
		p.hitOrStand();

		// Check if the player busted
		if (p.getHandValue() > 21) {
			System.out.println("You have gone over 21.");
			losses++;
			printFinalHands();
			resetHands();
			clearScreen();
			// shouldYouContinue();
		}
		d.revealDealerFullHand();

		// Dealer keeps hitting until their hand value is at least 17
		while (d.getHandValue() < 17) {
			Card card = deck.dealCard(); // Assuming you have a method to deal a card from the deck
			d.addCardToHand(card);
			d.revealDealerFullHand();
			// System.out.println("Dealer draws: " + card);
		}

		// Check who wins or if it's a push
		if (d.getHandValue() > 21) {
			System.out.println("Dealer busts");
			wins++;

		} else if (d.getHandValue() > p.getHandValue()) {
			System.out.println("You lose.");
			losses++;
		} else if (p.getHandValue() > d.getHandValue()) {
			System.out.println("You win.");
			wins++;
		} else {
			System.out.println("Push.");
			ties++;
		}
		//printFinalHands();
		//resetHands();
		//clearScreen();
		//clearConsole();
		deck.shuffle();
		d.revealDealerFullHand();
		//deck.addToDiscardPile();
		// shouldYouContinue();
	}

	private void printFinalHands() {

		System.out.println("\nThe dealer's hand looks like this:");
		d.revealDealerFullHand();
		// dSystem.out.println("----------------------------------------------");

		System.out.println("\nPlayer's hand looks like this:");
		p.playersDisplayFirstHand();
		// System.out.println("----------------------------------------------");
	}

	public void displayStats() {
		System.out.println("Starting Next Round... Wins: " + wins + " Losses: " + losses + " Ties: " + ties);
	}

	private void resetHands() {
		p.clearHand();
		d.clearHand();

	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void refreshGame() {
		System.out.println("Refreshing the game...");
		//deck.initializeDeck();
		wins = 0;
		losses = 0;

	}

	public void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	private void titleScreen() {
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.println("            -------         -------           ");
		System.out.println("           |A      |       |10     |          ");
		System.out.println("           |       |       |       |          ");
		System.out.println("           |       |       |       |          ");
		System.out.println("           |       |       |       |          ");
		System.out.println("           |      A|       |     10|          ");
		System.out.println("            -------         -------           ");
		System.out.println();
		System.out.println("        The Blackjack App Java Style!!        ");
		System.out.println("----------------------------------------------");
		System.out.println();

	}

	

	public void playOrExit() {
		while (true) {
			System.out.print("Do you want to continue with the game? (y/n): ");
			String userInput = scanner.nextLine().toLowerCase();

			switch (userInput) {
			case "y":
				shouldYouContinue();
				break;
			case "n":
				System.out.println("Exiting the program...");
				return;
			default:
				System.out.println("Invalid input. Please enter 'y' or 'n'.");
			}
		}
	}
}
