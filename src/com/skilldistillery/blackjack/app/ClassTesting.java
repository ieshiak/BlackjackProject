package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;

public class ClassTesting {

	public static void main(String[] args) {

		System.out.println("Welcome to this Testing Site!");
		System.out.println(" Be aware, I suck at this.");
		System.out.println();

		 BlackjackGame game = new BlackjackGame();
		 game.play();
		 
		//HiLoCardGame hi = new HiLoCardGame();
		//hi.doYouWantToPlayHiLo();
		 
		// System.out.println("This is a test of the suit class ");
		// System.out.println(Suit.CLUBS);
		// System.out.println("This is a test of the Ace and its value");
		// System.out.println(Rank.ACE + " has a value of " + Rank.ACE.value);
		// System.out.println();

		// Card creation and test
		// Deck testDeck = new Deck();
		// Card aCard = new Card(Rank.QUEEN, Suit.CLUBS);
		// Card bCard = new Card(Rank.ACE,Suit.DIAMONDS);
		// Card cCard = new Card(Rank.SIX, Suit.SPADES);

		 //Card redCard = new Card(Rank.ACE, Suit.HEARTS);
		 //Card blackCard = new Card(Rank.KING, Suit.SPADES);

		 //System.out.println("Red card: " + redCard.getColor());   // Output: Red
		 //System.out.println("Black card: " + blackCard.getColor()); // Output: Black
		 
		 
		// Add the cards to the deck
		// testDeck.addCard(aCard);
		// testDeck.addCard(bCard);
		// testDeck.addCard(cCard);

		// Print out the deck
		// System.out.println(testDeck);
		// System.out.println();

		// print of sample full deck and shuffled
		//Deck testDeck2 = new Deck(true);
		// System.out.println("This is a test of a set of 52 cards");
		// System.out.println(testDeck2);
		// System.out.println("Shuffled deck");
		// System.out.println(testDeck2);

		// checking if the deck is removing cards
//		Deck testDeck3 = new Deck(true);
//		BlackjackHand testHand = new BlackjackHand();
//		 testHand.takeCardFromDeck(testDeck3);
//		 testHand.takeCardFromDeck(testDeck3);
//		 testHand.takeCardFromDeck(testDeck3);
//		 System.out.println("testHand now has the following cards:");
//		 System.out.println(testHand);
//		 System.out.println("testDeck now looks like this:");
//		 System.out.println(testDeck3);

		// checking the printing card values
//		 Deck testDeck4 = new Deck();
//		 testDeck4.addCard(new Card(Rank.ACE, Suit.CLUBS));
//		 testDeck4.addCard(new Card(Rank.ACE, Suit.CLUBS));
//		 testDeck4.addCard(new Card(Rank.ACE, Suit.CLUBS));
//		 testDeck4.addCard(new Card(Rank.ACE, Suit.CLUBS));
//		 BlackjackHand testHand4 = new BlackjackHand();
//		 testHand4.takeCardFromDeck(testDeck4);
//		 testHand4.takeCardFromDeck(testDeck4);
//		 testHand4.takeCardFromDeck(testDeck4);
//		 testHand4.takeCardFromDeck(testDeck4);
//		 System.out.println("The value of this hand is: " + testHand4.calculatedValue());

		// testing Dealer name

//		Dealer dealer = new Dealer();
//		System.out.println("The dealer's name is: " + dealer.getName());
//
//		Player player = new Player();
//
//		player.inputNameDuringGame();
//		
//		Deck testDeck5 = new Deck(true);
//		dealer.takeCardFromDeck(testDeck5);
//		dealer.takeCardFromDeck(testDeck5);
//
//		// Give the player two cards
//		player.takeCardFromDeck(testDeck5);
//		player.takeCardFromDeck(testDeck5);
//		
//		player.printHand();
//		dealer.printFirstHand();
//		dealer.printHand();
		
		// Rank rank = Rank.ACE; // or any other valid Rank value
		// Suit suit = Suit.HEARTS; // or any other valid Suit value
		// Card card = new Card(rank, suit);
		// Rank rank = Rank.ACE;
		// Suit suit = Suit.HEARTS;

		// Card card = new Card(rank, suit);
		// card.getValue();

		// Deck deck = new Deck();
		// deck.displayDeck();
		// deck.checkDeckSize();
		// deck.cardsLeftInDeck();
		// deck.dealCard();
		// deck.shuffle();
		// deck.dealCard();
		// deck.size();

		// System.out.println("Debug: Before adding cards - " + deck.getCards());
		// deck.addCards(newCards);
		// System.out.println("Debug: After adding cards - " + deck.getCards());

		// List<Card> usedCards = new ArrayList<>();
		// usedCards.add(new Card(Rank.ACE, Suit.HEARTS));

		// deck.addToDiscardPile(usedCards);

		// Display the initial state of the discard pile
		// System.out.println("Debug: Discard Pile initially - " + deck.getDiscard());
		// deck.resetRoundData();

//dont work
		// List<Card> discardedCards = deck.getDiscard();
		// System.out.println("Debug: Discarded cards - " + discardedCards);

		// Display the state of the discard pile after adding cards
		// System.out.println("Debug: Discard Pile after adding cards - " +
		// deck.getDiscard();

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

		// Dealer d = new Dealer();
		// d.addCardToHand(card);
		// d.clearHand();
		// d.getHandValue();
		// d.isBlackjack();
		// d.isBust();
		// d.displayPartialHand();
		// d.dealerFirstHand();
		// d.revealFirstCard();
		// d.dealerDiscard();

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
