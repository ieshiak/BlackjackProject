package com.skilldistillery.blackjack.entities;
import java.util.Random;

public class BlackjackMessages {

    private final Random random = new Random();

    private final String[] welcomeMessages = {
            "Welcome to the blackjack rollercoaster! Buckle up for a wild ride!",
            "Get ready for an unforgettable blackjack experience!",
            "The cards are shuffled, and the adventure begins!",
            "Luck is on your side today! Enjoy the blackjack journey!",
            "Fasten your seatbelt! Blackjack excitement awaits you!",
    };

    private final String[] startGameMessages = {
    		"The deck is shuffled, and the stage is set for an exhilarating game. Are you in? (y/n)",
    		"Time to ante up! Test your blackjack skills in this daring game. Ready to play? (y/n)",
    		"The first cards are dealt! May the odds be in your favor. Want to start the game? (y/n)",
    		"Shuffling the deck, the stage is set for a thrilling game. Ready to roll the dice? (y/n)",
    		"Ante up! It's time to put your blackjack skills to the test. Are you game? (y/n)",
    		"Dealing the first cards! May the odds be in your favor. Ready to kick off the game? (y/n)",
    		"Strap in for another round! The cards are getting ready for a rematch, and so should you. (y/n)",
    	    "Round two, anyone? The cards are whispering sweet strategies, and the dealer is dealing up a storm! (y/n)",
    	    "Ready or not, here comes another round! The cards are doing jumping jacks, and the dealer is dealing joy. (y/n)",
    	    "Buckle up! The cards are doing their stretches, and the dealer is ready for another dance with destiny. (y/n)",
    	    "Game on! The cards are putting on their game faces, and the dealer is dealing out a fresh set of surprises. (y/n)",
    	    "Who's up for a sequel? The cards are practicing their plot twists, and the dealer is ready to deal some drama. (y/n)",
    	    "Double or nothing, right? The cards are doing a quick huddle, and the dealer is dealing out second chances. (y/n)",
    };

    private final String[] hitMessages = {
            "Hitting on a dream... and a 12.",
            "Taking a chance! Hit me!",
            "Feeling lucky? Another card is on the way!",
            "The thrill of the unknown! One more card, please.",
            "Strategizing! Let's see what the next card brings.",
    };

    private final String[] standMessages = {
            "Playing it safe, or just enjoying the view? Stands like a champ!",
            "The brave soul stands tall. No more cards needed.",
            "Locked in the decision! Stand and watch the game unfold.",
            "Strategic move! Patiently standing for the dealer's turn.",
            "Decisions made! Stands confidently with the current hand.",
    };

    private final String[] bustMessages = {
            "Bust happens. Let's blame it on the deck, shall we?",
            "Ouch! Over 21. The dealer thanks you.",
            "Unlucky draw! Busts with a heavy heart.",
            "Too close for comfort! Busts and hopes for better luck next time.",
            "Well, that escalated quickly! Busts and reflects on the choices made.",
    };

    private final String[] dealerTurnMessages = {
            "Time for the dealer to shine! Brace yourselves!",
            "Dealer's turn! What will fate deal this time?",
            "The spotlight is on the dealer! Will luck be on their side?",
            "Dealer's moment to impress! The cards are in their hands.",
            "Hold your breath! The dealer takes the stage for their turn.",
    };

    private final String[] dealerBustMessages = {
            "Dealer busts! Must be the pressure... or maybe just karma.",
            "Busted! The house always wins? Not this time!",
            "Dealer crosses the line! Busts with a surprising turn of events.",
            "Unexpected twist! The dealer busts, turning the tables.",
            "The dealer's luck runs out! A bust changes the game dynamics.",
    };

    private final String[] playerWinsMessages = {
            "Winner, winner, blackjack dinner! Somebody's on fire!",
            "Victory dance! Player takes the prize.",
            "Triumphant moment! Player wins with a winning hand.",
            "Cheers to success! The player emerges victorious.",
            "Incredible comeback! Player secures a well-deserved win.",
    };

    private final String[] dealerWinsMessages = {
            "It happens to the best of us. Even blackjack legends. Better luck next time!",
            "Tough luck! The dealer claims the victory.",
            "The house prevails! Dealer wins this round.",
            "A close call! The dealer emerges victorious.",
            "Fortune favors the dealer! A win for the house.",
    };
    private final String[] itsATieMessages = {
    "Looks like we've got a tie! The cards are as indecisive as a cat trying to choose a nap spot.",
    "Two peas in a pod! The game ends in a tie, just like mismatched socks that somehow work together.",
    "Tie game! It's like the cards couldn't decide which side to root for, so they went for a draw.",
    "Well, this is awkward. The game ends in a tie, leaving the cards in a state of confusion, like a GPS without a signal.",
    "A tie! The cards must be pulling a 'should I stay or should I go' routine. Game, you do you!",
    };


 
    public void itsATieMessages() {
        System.out.println(getRandomMessage(itsATieMessages));
    }
    
    public void welcomeMessage() {
        System.out.println(getRandomMessage(welcomeMessages));
    }

    public void startGameMessage() {
        System.out.println(getRandomMessage(startGameMessages));
    }

    public void playerHitsMessage() {
        System.out.println(getRandomMessage(hitMessages));
    }

    public void playerStandsMessage() {
        System.out.println(getRandomMessage(standMessages));
    }

    public void playerBustsMessage() {
        System.out.println(getRandomMessage(bustMessages));
    }

    public void dealerTurnMessage() {
        System.out.println(getRandomMessage(dealerTurnMessages));
    }

    public void dealerBustsMessage() {
        System.out.println(getRandomMessage(dealerBustMessages));
    }

    public void playerWinsMessage() {
        System.out.println(getRandomMessage(playerWinsMessages));
    }

    public void dealerWinsMessage() {
        System.out.println(getRandomMessage(dealerWinsMessages));
    }

    private String getRandomMessage(String[] messages) {
        return messages[random.nextInt(messages.length)];
    }
}
