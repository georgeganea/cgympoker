package org.cgympoker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Card;

public class CardImpl implements Card {
    private Rank rank;
    private Suit suit;
    private boolean isFlipped;
    public CardImpl(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        isFlipped = false;
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(CardImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	@Override
	public Rank getRank() {
             return rank;
	}

	@Override
	public Suit getSuit() {
            return suit;
	}

	@Override
	public boolean isFlipped() {
            return isFlipped;
        }

    public String getImageName() throws RemoteException {
       String name = "";
       name += rank.toString()+suit.toString().toLowerCase().substring(0, 1)+".jpg"; 
       return name;
    }
}
