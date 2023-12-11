package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BettingSystem;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;
import com.skilldistillery.blackjack.entities.PlayerManager;


public class BlackjackApp {
    private PlayerManager playerManager;
    private Dealer dealer;
    private Deck deck;
    private BettingSystem bettingSystem;

    public BlackjackApp() {
        playerManager = new PlayerManager();
        deck = new Deck(); 
        dealer = new Dealer(deck);
        bettingSystem = new BettingSystem();
    }

    public void startGame() {
        System.out.println("Welcome to Blackjack!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter the name of Player " + i + ": ");
            String playerName = scanner.next();
            playerManager.addPlayer(new Player(playerName));
        }

    }

    public void dealInitial() {
        System.out.println("Dealing initial cards...");

        playerManager.distributeInitialCards(deck);

        dealer.dealCard(deck);
        dealer.dealCard(deck);

    }

    public void playRound() {
        System.out.println("Playing a round...");

        if (playerManager.getNumberOfPlayers() < 1) {
            System.out.println("Not enough players to start the round.");
            return;
        }

        bettingSystem.openBetting();

        dealInitial();

        for (Player player : playerManager.getPlayers()) {
            System.out.println("\n" + player + "'s turn:");
            player.takeTurn(deck);
        }

        bettingSystem.closeBetting();

        dealer.startDealerTurn();
        dealer.play(deck);
        dealer.endDealerTurn();

        determineWinners();

        displayRoundResults();

    }

    private void determineWinners() {
        int dealerTotal = dealer.getHandTotal();

        for (Player player : playerManager.getPlayers()) {
            int playerTotal = player.getHandTotal();

            if (playerTotal > 21) {
                // Player busted, dealer wins
                System.out.println(player + " busted. Dealer wins!");
            } else if (dealerTotal > 21) {
                // Dealer busted, player wins
                System.out.println(player + " wins! Dealer busted.");
                player.setChips(player.getChips() + 2 * bettingSystem.getBetAmount(player));
            } else if (playerTotal > dealerTotal) {
                // Player has a higher hand value, player wins
                System.out.println(player + " wins!");
                player.setChips(player.getChips() + 2 * bettingSystem.getBetAmount(player));
            } else if (playerTotal == dealerTotal) {
                // It's a push (tie), return the player's bet
                System.out.println(player + " pushes. Bet returned.");
                player.setChips(player.getChips() + bettingSystem.getBetAmount(player));
            } else {
                // Dealer has a higher hand value, dealer wins
                System.out.println(player + " loses. Dealer wins!");
            }
        }
    }

    private void displayRoundResults() {
        System.out.println("***** Round Results *****");

        System.out.println("Dealer's hand: " + dealer.getHandTotal());

        for (Player player : playerManager.getPlayers()) {
            int playerTotal = player.getHandTotal();

            System.out.println(player + "'s hand: " + playerTotal);

            // Determine if the player won, lost, or pushed
            int dealerTotal = dealer.getHandTotal();
            if (playerTotal > 21) {
                System.out.println(player + " busted. Dealer wins!");
            } else if (dealerTotal > 21) {
                System.out.println(player + " wins! Dealer busted.");
            } else if (playerTotal > dealerTotal) {
                System.out.println(player + " wins!");
            } else if (playerTotal == dealerTotal) {
                System.out.println(player + " pushes. Bet returned.");
            } else {
                System.out.println(player + " loses. Dealer wins!");
            }
        }
    }

    public void endRound() {
        System.out.println("Ending the round...");
    }

    public static void main(String[] args) {
        BlackjackApp blackjackApp = new BlackjackApp();
        blackjackApp.startGame();
        blackjackApp.dealInitial();
        blackjackApp.playRound();
        blackjackApp.endRound();
    }
}
