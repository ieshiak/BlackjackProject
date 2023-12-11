package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BettingSystem;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;
import com.skilldistillery.blackjack.entities.PlayerManager;
import java.util.Random;

public class BlackjackApp {
    private PlayerManager playerManager;
    private Dealer dealer;
    private Deck deck;
    private BettingSystem bettingSystem;
    private Scanner scanner;

    public BlackjackApp() {
        playerManager = new PlayerManager();
        deck = new Deck(); 
        dealer = new Dealer(deck);
        bettingSystem = new BettingSystem();
        scanner = new Scanner(System.in);
    }

 public void startGame() {
     System.out.println("Welcome to Blackjack!");

     // Ask the user for the number of human players
     System.out.print("Enter the number of human players (1-3): ");
     int numHumanPlayers = scanner.nextInt();
     scanner.nextLine(); 

     // Validate and adjust the number of human players
     numHumanPlayers = Math.min(numHumanPlayers, 3);
     int maxTotalPlayers = 4;
     int numAIPlayers = maxTotalPlayers - numHumanPlayers;

     // Add human players to the manager based on user input
     for (int i = 1; i <= numHumanPlayers; i++) {
         System.out.print("Enter the name of Human Player " + i + ": ");
         String playerName = scanner.nextLine();
         playerManager.addPlayer(new Player(playerName));
     }

     // Add AI players to the manager based on the remaining slots with random names
     String[] aiPlayerNames = {"Mike", "Brandon", "Alicia", "Whitney", "Danny", "Lucy"};
     Random random = new Random();

     while (numAIPlayers > 0) {
         String aiPlayerName = aiPlayerNames[random.nextInt(aiPlayerNames.length)];
         playerManager.addPlayer(new Player(aiPlayerName));
         numAIPlayers--;
     }

     bettingSystem.openBetting();
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

        Player humanPlayer = playerManager.getNextPlayer();
        System.out.println("\n" + humanPlayer + "'s turn:");
        humanPlayer.takeTurn(deck, true, scanner);

        for (Player player : playerManager.getPlayers()) {
            if (player != humanPlayer) {
                System.out.println("\n" + player + "'s turn:");
                player.takeTurn(deck, false, scanner);
            }
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
