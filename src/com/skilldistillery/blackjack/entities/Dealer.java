package com.skilldistillery.blackjack.entities;

public class Dealer implements Decisions {
    private BlackjackHand hand;
    private boolean isDealerTurn;

    public Dealer(Deck deck) {
        hand = new BlackjackHand();
        isDealerTurn = false;
        drawCard(deck);
        drawCard(deck);
    }

    public void revealCard() {
        System.out.println("Dealer reveals: " + hand.getCards().get(1)); // Assuming the second card is the face-down card
    }

    public void play(Deck deck) {
        startDealerTurn(); 
        while (getHandTotal() < 17) {
            drawCard(deck);
        }
        stand(); 
        endDealerTurn();
    }

    public void dealCard(Deck deck) {
        Card card = deck.dealCard();
        addCardToHand(card);
        System.out.println("Dealer draws: " + card);
    }

    @Override
    public void addCardToHand(Card dealtCard) {
        hand.addCard(dealtCard);
    }

    @Override
    public void stand() {
        System.out.println("Dealer stands.");
    }

    @Override
    public int getHandTotal() {
        return hand.getHandValue();
    }

    public void startDealerTurn() {
        isDealerTurn = true;
        System.out.println("Dealer's turn has started.");
    }

    public void endDealerTurn() {
        isDealerTurn = false;
        System.out.println("Dealer's turn has ended.");
    }

    public boolean isDealerTurn() {
        return isDealerTurn;
    }

    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        addCardToHand(card);
        if (isDealerTurn) {
            System.out.println("Dealer draws: " + card);
        }
    }
}
