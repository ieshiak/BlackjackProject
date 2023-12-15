package com.skilldistillery.blackjack.entities;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealing {

    public static void main(String[] args) {
        Dealing d = new Dealing();
        d.run();
    }
//work
    private void run() {
        //System.out.println("Debug: Starting the run method.");

        Deck deck = new Deck();

        Scanner sc = new Scanner(System.in);
        System.out.print("How many cards: ");

        try {
            int numCards = sc.nextInt();
            if (numCards > 52) {
                throw new InputMismatchException();
            }
//work
            // Use BlackjackHand instead of List<Card>
            BlackjackHand hand = new BlackjackHand();
            int totalValue = 0;

            for (int i = 0; i < numCards; i++) {
                Card c = deck.dealCard();
                
                // Add card to the hand
                hand.addCard(c);
                
               //System.out.println("Debug: Dealt card: " + c);

                totalValue = hand.getHandValue(); // Update total value after adding each card
            }


        } catch (InputMismatchException e) {
            System.out.println("That is not a valid number of cards.");
        } finally {
            sc.close();
            //System.out.println("Debug: Scanner closed.");
        }
    }
}
