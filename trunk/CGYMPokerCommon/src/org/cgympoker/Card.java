package org.cgympoker;

public interface Card {
	public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    
    public Rank getRank();
    public Suit getSuit();
    public boolean isFlipped();
}
