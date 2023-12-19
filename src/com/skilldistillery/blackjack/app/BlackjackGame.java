package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.DCQuotes;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.HiLoCardGame;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackGame {

	private BlackjackHand bjh = new BlackjackHand();
	private Dealer d = new Dealer("Dealer");
	private Player p = new Player();
	private int wins, losses, ties;
	private Deck deck = new Deck(true);
	private Deck usedCards = new Deck();
	private Scanner scanner;
	HiLoCardGame hiLo = new HiLoCardGame();
	private int currentBalance;
	DCQuotes dc = new DCQuotes();
	String randomQuote = dc.getRandomQuote();
	private int roundWins, roundLosses, roundTies;
	//private final int LOW_BALANCE_THRESHOLD = 100;

	public BlackjackGame() {
		this.scanner = new Scanner(System.in);

	}

	public void play() {
		System.out.println(randomQuote);
		titleScreen();
		p.inputNameDuringGame();
		d.chooseTheDealer();
		rounds();
	}

	public void rounds() {
		p.placeBet();
		shouldYouContinue();
		playOrExit();
	}

	public void shouldYouContinue() {
		deck.shuffle();
//			playOrExit();
		
		throwAwayUsedCards();
		if (deck.cardsLeft() < 4) {
			hiLo.doYouWantToPlayHiLo();
		}

		dealShowShuffle();
		p.hitOrStand(deck, usedCards);

		if (p.isBust()) {
		    losses++;
		} else {
		    if (p.isBlackjack()) {
		        wins++;
		        d.displayHandAndValue();
		        p.addBalance(2 * p.getBet()); // Earn 2x the bet on blackjack
		    } else {
		        while (d.valueOfCurrentHand() < 17) {
		            d.hit(deck, usedCards);
		            d.displayHandAndValue();
		        }

		        if (d.isBust() || p.valueOfCurrentHand() > d.valueOfCurrentHand()) {
		            wins++;
		        } else if (p.valueOfCurrentHand() < d.valueOfCurrentHand()) {
		            losses++;
		        } else {
		            ties++;
		        }
		    }
		}

		playOrExit();
	}

	public void dealShowShuffle() {
		d.takeCardFromDeck(deck);
		d.takeCardFromDeck(deck);

		p.takeCardFromDeck(deck);
		p.takeCardFromDeck(deck);

		d.printFirstHand();
		p.displayHandAndValue();

	}

	public void calculateRoundScores() {
		if (wins > 0) {
			p.addBalance(2 * p.getBet());
			System.out.println("Congratulations! You have won!");
			roundWins++;
		} else if (losses > 0) {
			System.out.println("Sorry, you have lost. Better luck next time.");
			roundLosses++;
		} else if (ties > 0) {
			System.out.println("It's a tie! ");
			p.addBalance(p.getBet());
			roundTies++;
		}
		wins = 0;
		losses = 0;
		ties = 0;

		currentBalance = p.getBalance();
	}

	public void displayStats() {
		System.out.println("W: " + roundWins + "\t" + "L: " + roundLosses + "\t" + "T: " + roundTies
				+ "\tCurrent Balance: " + currentBalance);
		System.out.println("----------------------------------------------");
		System.out.println();
	}

	public void playOrExit() {
		d.displayHandAndValue();
		p.displayHandAndValue();
		calculateRoundScores();
		System.out.println();
		displayStats();
		if (p.getBalance() <= 0) {
			hiLo.doYouWantToPlayHiLo();
		}
//		  if (p.getBalance() <= LOW_BALANCE_THRESHOLD) {
//		        hiLo.doYouWantToPlayHiLo();
//		    }

		while (true) {

			System.out.print("Do you want to continue with the game? (y/n): ");
			String userInput = scanner.nextLine().toLowerCase();
			System.out.println("----------------------------------------------");

			switch (userInput) {
			case "y":
				System.out.println("Restarting a new round...");
				System.out.println();
				rounds();

				break;
			case "n":
				hiLo.doYouWantToPlayHiLo();
				break;
			default:
				System.out.println("Invalid input. Please enter 'y' or 'n'.");
			}
		}
	}
	
	
    
	public void throwAwayUsedCards() {
		d.discardHandToDeck(usedCards);
		p.discardHandToDeck(usedCards);
	}

	public void titleScreen() {
		System.out.println("┌─────────┐┌─────────┐\n" + "│ A       ││ 10      │\n" + "│         ││         │\n"
				+ "│         ││         │\n" + "│    ♥    ││    ♥    │\n" + "│         ││         │\n"
				+ "│         ││         │\n" + "│       A ││      10 │\n" + "└─────────┘└─────────┘");
		System.out.println("Welcome to Blackjack, Java Style!");
		System.out.println("----------------------------------------------");
	}

}
