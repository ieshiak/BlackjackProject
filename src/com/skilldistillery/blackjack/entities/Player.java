package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends BlackjackHand {
	private String name;
	private int bet;
	private int balance;
	Scanner scanner = new Scanner(System.in);
	public Player() {
		this.balance = 1000;
	}
	public String getName(){
	    return this.name;
	}
	public void inputNameDuringGame() {
		System.out.print("Enter your name: ");
		this.name = scanner.nextLine();
		System.out.println("----------------------------------------------");
	}
	public void placeBet() {
	    System.out.println("Current balance: " + balance);
	    System.out.print("Enter your bet: ");

	    int selectedBet;
	    while (true) {
	        try {
	            selectedBet = Integer.parseInt(scanner.nextLine());
	            System.out.println("----------------------------------------------");

	            if (selectedBet > 0 && selectedBet <= balance) {
	                balance -= selectedBet;
	                this.bet = selectedBet;

	                break;
	            } else {
	                System.out.println("Invalid bet. Please enter a valid amount within your balance.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
	    }

	    System.out.println("Bet placed: " + this.bet);
	    System.out.println("Updated balance: " + balance);
	    System.out.println("----------------------------------------------");
	}

	public int getBet() {
        return bet;
    }
	
	public int getBalance() {
        return balance;
    }
	public void deductBalance(int amount) {
            balance -= amount;
	}

    public void addBalance(int amount) {
        balance += amount;
    }

public void displayHandAndValue(){
	for (Card card : this.getHand()) {
		System.out.println(card);
	}	
    System.out.println(getName() + "'s hand is valued at "+ valueOfCurrentHand());
    System.out.println("----------------------------------------------");
    }


public void hitOrStand(Deck deck, Deck usedCards) {
	Scanner scanner = new Scanner(System.in);
	int  decision = 0;
    boolean getNum = true;

    while(getNum){

        try{
            System.out.println("Would you like to: 1) Hit or 2) Stand");
            decision = scanner.nextInt();
            getNum = false;

        }
        catch(Exception e){
            System.out.println("Invalid");
            scanner.next();
        }
    }

    if (decision == 1) {
        this.hit(deck, usedCards);
        if(this.valueOfCurrentHand()>20){
            return;
        }
        else{
            this.hitOrStand(deck, usedCards);
        }

    } else {
        System.out.println("You stand.");
    }
}

public void hit(Deck deck, Deck usedCards){

    if (!deck.hasCards()) {
        deck.reloadFromUsedCards(usedCards);
    }
    this.takeCardFromDeck(deck);
    this.displayHandAndValue();
}
}
