package org.cgympoker.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Card extends Remote{
    public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    
    public Rank getRank() throws RemoteException;
    public Suit getSuit() throws RemoteException;
    public boolean isFlipped() throws RemoteException;
    public String getImageName() throws RemoteException;
}
