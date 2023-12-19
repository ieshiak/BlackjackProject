package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class HiLoCardGame {

	private Deck hiLoDeck = new Deck(true);
	private int score;
	Scanner scanner = new Scanner(System.in);

	public HiLoCardGame() {
		this.score = 0;
	}

	public void doYouWantToPlayHiLo() {
		while (true) {
			System.out.println();
			System.out.print("Do you want to play the High Low Card Game? (y/n): ");
			String userInput = scanner.next().toLowerCase().trim();

			switch (userInput) {
			case "y":
				guessTheNextcard();
				break;
			case "n":
				System.out.println("----------------------------------------------");
				System.out.println("Until we meet again, stay vigilant \nand stand for what is right...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid input. Please enter 'y' or 'n'.");
			}
		}
	}

	public void guessTheNextcard() {
		resetScore();
		hiLoDeck.shuffle();
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.println("Guess if the next card is Higher or Lower");
		System.out.println("----------------------------------------------");
		Card currentCard = hiLoDeck.dealCard();
		System.out.println("First card: " + currentCard);

		while (true) {
			System.out.print("Higher (h) or Lower (l)? ");
			char guess = scanner.next().toLowerCase().charAt(0);

			Card nextCard = hiLoDeck.dealCard();
			System.out.println("Next card: " + nextCard);

			int comparison = compareCards(currentCard, nextCard);

			if ((guess == 'h' && comparison == 1) || (guess == 'l' && comparison == -1)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect. Your score: " + score);
				System.out.println("----------------------------------------------");
				break;
			}
			currentCard = nextCard;
		}
	}

	public void resetScore() {
		score = 0;
	}

	public int compareCards(Card currentCard, Card nextCard) {
		Rank current = currentCard.getRank();
		Rank next = nextCard.getRank();

		int currentValue = current.getHighLowValue();
		int nextValue = next.getHighLowValue();

		if (nextValue > currentValue) {
			return 1;
		} else if (nextValue < currentValue) {
			return -1;
		} else {
			return 0;
		}
	}

}