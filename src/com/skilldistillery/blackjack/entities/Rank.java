package com.skilldistillery.blackjack.entities;

public enum Rank {
	// Enum constants representing each rank with its associated name and value
	ACE("Ace", 11), TWO("Two", 2), THREE("Three", 3), FOUR("Four", 4), FIVE("Five", 5), SIX("Six", 6),
	SEVEN("Seven", 7), EIGHT("Eight", 8), NINE("Nine", 9), TEN("Ten", 10), JACK("Jack", 10), QUEEN("Queen", 10),
	KING("King", 10);

	String name;
	int value;

	Rank(String name, int value) {
		this.name = name;
		this.value = value;

	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return name;
	}
	public int getHighLowValue() {
        switch (this) {
            case JACK:
                return 11;
            case QUEEN:
                return 12;
            case KING:
                return 13;
            case ACE:
                return 14;
            default:
                return value;
        }
    }

}
