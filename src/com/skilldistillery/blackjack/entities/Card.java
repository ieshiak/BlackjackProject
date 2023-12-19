package com.skilldistillery.blackjack.entities;
import java.util.ArrayList;
import java.util.Objects;

public class Card {
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	public int getValue(){
	    return rank.value;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public Color getColor() {
        return suit.getColor();
    }
	
	public Card(Card card){
	    this.suit = card.getSuit();
	    this.rank = card.getRank();
	}
	@Override
    public String toString() {
        String rankSymbol;

        switch (rank) {
            case TEN:
                rankSymbol = "10";
                break;
            case JACK:
                rankSymbol = "J";
                break;
            case QUEEN:
                rankSymbol = "Q";
                break;
            case KING:
                rankSymbol = "K";
                break;
            case ACE:
                rankSymbol = "A";
                break;
            default:
                rankSymbol = String.valueOf(getValue());
                break;
        }

        Color cardColor = suit.getColor();
        String colorCode = (cardColor == Color.RED) ? Color.RED.getCode() : Color.BLACK.getCode();

        // Create a formatted string representation of the card using ASCII art with color
        return colorCode +
                "\n" + "┌─────────┐\n" + "│ " + rankSymbol + "       │\n" + "│         │\n" + "│         │\n" +
                "│    " + suit.getSymbol() + "    │\n" + "│         │\n" + "│         │\n" + "│       " + rankSymbol + " │\n" +
                "└─────────┘\n" +
                "\u001B[0m"; // Reset color
    }
}