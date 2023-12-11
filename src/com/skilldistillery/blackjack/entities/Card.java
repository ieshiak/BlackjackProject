package com.skilldistillery.blackjack.entities;


public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        // System.out.println("Debug: Created card: " + this);
    }

    public int getValue() {
        switch (rank) {
            case ACE:
                return 11;
            case TWO:
                return 2;
            default:
                return 10;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(rank);
        builder.append(" of ");
        builder.append(suit);
        return builder.toString();
    }

    public Rank getRank() {
        return rank;
    }
}
