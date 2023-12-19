package com.skilldistillery.blackjack.entities;

import java.util.List;
import java.util.Scanner;

public class Dealer extends Player {
	private String name;
	private BlackjackHand bjh = new BlackjackHand();
	
	
	public Dealer(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void printFirstHand() {
		System.out.println(this.hand.get(0));
		faceDown();
		System.out.println();
		System.out.println(getName() + "'s hand is valued at " + getFirstCardValue());
		System.out.println("----------------------------------------------");
	}

	public int getFirstCardValue() {
		List<Card> cards = this.hand;
		if (!this.hand.isEmpty()) {
			Card firstCard = this.hand.get(0);
			if (firstCard != null) {
				return firstCard.getValue();
			} else {
			}
		}

		return 0;
	}

	public void faceDown() {
		System.out.println();
		System.out.println("┌─────────┐");
		System.out.println("│ HIDDEN  │");
		System.out.println("│         │");
		System.out.println("│         │");
		System.out.println("│    ?    │");
		System.out.println("│         │");
		System.out.println("│         │");
		System.out.println("│  HIDDEN │");
		System.out.println("└─────────┘");
	}
	
	public void chooseTheDealer() {
		 Dealer[] dealers = {
	                new Dealer("Joker"),
	                new Dealer("Harley Quinn"),
	                new Dealer("Poison Ivy"),
	                new Dealer("The Riddler"),
	                new Dealer("Penguin")
	        };

	        System.out.println("Choose the villian for this game:");
	        for (int i = 0; i < dealers.length; i++) {
	            System.out.println((i + 1) + ". " + dealers[i].getName());
	        }

	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.print("Enter the number of your chosen villian: ");
	            while (!scanner.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next();
	        	 
	            }
	            choice = scanner.nextInt();
	        } while (choice < 1 || choice > dealers.length);

	        this.name = dealers[choice - 1].getName();
	        System.out.println("----------------------------------------------");
	    }
	}