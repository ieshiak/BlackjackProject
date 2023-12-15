package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Card {
	private Rank rank;
	private Suit suit;
	private int value;
	private ArrayList<Card> deck = new ArrayList<>();

//works
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		// System.out.println("Debug: Created card: " + this);
	}

//works
	public int getValue() {
        if (rank != null) {  // Assuming rank is a field in your Card class
            return rank.getValue();
        } else {
            return 0;  // Or some default value
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	
//	@Override
//	public int hashCode() {
//	    return Objects.hash(rank, suit);
//
//

}

//	@Override
//	public boolean equals(Object obj) {
//	    if (this == obj) return true;
//	    if (obj == null || getClass() != obj.getClass()) return false;
//	    Card otherCard = (Card) obj;
//	    return rank == otherCard.rank && suit == otherCard.suit;
//	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public Rank getRank() {
		return rank;
	}

	// Override the toString method to create a visual representation of the card
	@Override
	public String toString() {
		String rankSymbol;

		// Use a switch statement to convert the rank enum to a string symbol
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
			rankSymbol = String.valueOf(rank.getValue());
			break;
		}

		// Create a formatted string representation of the card using ASCII art
		return "\n" + "┌─────────┐\n" + "│ " + rankSymbol + "       │\n" + "│         │\n" + "│         │\n" + "│    "
				+ suit.getSymbol() + "    │\n" + "│         │\n" + "│         │\n" + "│       " + rankSymbol + " │\n"
				+ "└─────────┘\n";
	}

	public void resetRoundData() {
		rank = null;
		suit = null;
		
		value = 0;

	}


}
