package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;
    private int currentPlayerIndex;

    public PlayerManager() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void distributeInitialCards(Deck deck) {
        for (Player player : players) {
            player.addCardToHand(deck.drawCard());
            player.addCardToHand(deck.drawCard());
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public Player getNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return getCurrentPlayer();
    }

    public boolean isBettingRound() {
        for (Player player : players) {
            if (!player.hasPlacedBet()) {
                return true; // Betting round is not complete
            }
        }

        return false;
    }

    public boolean hasPlacedBet(BettingSystem bettingSystem) {
        for (Player player : players) {
            if (!bettingSystem.hasPlayerPlacedBet(player)) {
                return false; // At least one player has not placed a bet
            }
        }
        return true; // All players have placed bets
    }

    public void moveToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public Player[] getPlayers() {
        // Convert the list of players to an array
        Player[] playerArray = new Player[players.size()];
        return players.toArray(playerArray);
    }
    
    
}
