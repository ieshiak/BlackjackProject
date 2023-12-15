package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;

public class ClassTesting {

	public static void main(String[] args) {

		System.out.println("Welcome to this Testing Site!");
		System.out.println(" Be aware, I suck at this.");		
		
		BlackjackGame game = new BlackjackGame();
		game.play();
		

        //Rank rank = Rank.ACE; // or any other valid Rank value
       //Suit suit = Suit.HEARTS; // or any other valid Suit value
       //Card card = new Card(rank, suit);
		//Rank rank = Rank.ACE;
		//Suit suit = Suit.HEARTS;

		 //Card card = new Card(rank, suit);
		// card.getValue();

		//Deck deck = new Deck();
		// deck.displayDeck();
		// deck.checkDeckSize();
		// deck.cardsLeftInDeck();
		// deck.dealCard();
		// deck.shuffle();
		// deck.dealCard();
		// deck.size();

		
		
		//System.out.println("Debug: Before adding cards - " + deck.getCards());
		//deck.addCards(newCards);
		//System.out.println("Debug: After adding cards - " + deck.getCards());

		
		
		
		
		//List<Card> usedCards = new ArrayList<>();
		//usedCards.add(new Card(Rank.ACE, Suit.HEARTS));
		

		//deck.addToDiscardPile(usedCards);

	
		// Display the initial state of the discard pile
		//System.out.println("Debug: Discard Pile initially - " + deck.getDiscard());
		//deck.resetRoundData();
		
//dont work
		//List<Card> discardedCards = deck.getDiscard();
        //System.out.println("Debug: Discarded cards - " + discardedCards);
		
		
		
		// Display the state of the discard pile after adding cards
		 //System.out.println("Debug: Discard Pile after adding cards - " +
		//deck.getDiscard();

		// deck.reloadDeckFromDiscard();

		// Dealing deal = new Dealing();

		// Player p = new Player();
		// p.inputNameDuringGame();
		// p.hitOrStand();
		// p.addCardToHand(card);
		// p.clearHand();
		// p.getHandValue();
		// p.isBlackjack();
		// p.isBust();
		// p.displayCardsAndValue();

		//Dealer d = new Dealer();
		// d.addCardToHand(card);
		// d.clearHand();
		// d.getHandValue();
		// d.isBlackjack();
		// d.isBust();
		// d.displayPartialHand();
		// d.dealerFirstHand();
		// d.revealFirstCard();
		//d.dealerDiscard();

		// BlackjackHand bjh = new BlackjackHand();
		// bjh.isSoft();
		// bjh.isBust();
		// bjh.isBlackjack();
		// bjh.isHard();
		// bjh.getHandValue();

		// BlackjackGame game = new BlackjackGame();
		// game.playGame();

		// p.addCardToHand(deck.dealCard());
		// d.addCardToHand(deck.dealCard());
		// p.addCardToHand(deck.dealCard());
		// d.addCardToHand(deck.dealCard());

		// d.partialHand();
		// d.getFirstCardValue();
		// Print the dealer's first card and the player's initial hand
		// d.dealerPartialHand();
		// d.revealDealerFullHand();
		// p.playersDisplayFirstHand();

	}
}
