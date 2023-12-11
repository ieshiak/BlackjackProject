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

    private void run() {
        // System.out.println("Debug: Starting the run method.");

        Deck deck = new Deck();

        // Shuffle the deck before dealing cards
        deck.shuffle();

        Scanner sc = new Scanner(System.in);
        System.out.print("How many cards: ");

        try {
            int numCards = sc.nextInt();
            if (numCards > 52) {
                throw new InputMismatchException();
            }

            List<Card> hand = new ArrayList<>(numCards);
            int totalValue = 0;
            for (int i = 0; i < numCards; i++) {
                Card c = deck.dealCard();
                totalValue += c.getValue();
                hand.add(c);

                // System.out.println("Debug: Dealt card: " + c);
            }
            printHandAndValue(hand, totalValue);
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid number of cards.");
        } finally {
            sc.close();
            // System.out.println("Debug: Scanner closed.");
        }
    }

    private static void printHandAndValue(List<Card> hand, int value) {
        // System.out.println("Debug: Printing hand and value.");

        for (Card card : hand) {
            System.out.println(card);
        }
        System.out.println("Total value: " + value);
    }
}
