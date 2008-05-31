package org.cgympoker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Card;

public class CardImpl implements Card {
    public CardImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(CardImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	@Override
	public Rank getRank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFlipped() {
		// TODO Auto-generated method stub
		return false;
	}

}
