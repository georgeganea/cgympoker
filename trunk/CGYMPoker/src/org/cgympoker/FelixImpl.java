package org.cgympoker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Felix;
import org.cgympoker.common.Tournament;

public class FelixImpl implements Felix {

        public FelixImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(FelixImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	@Override
	public void bet(int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void call() {
		// TODO Auto-generated method stub

	}

	@Override
	public void check() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fold() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leaveTournamnent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void raise(int amount) {
		// TODO Auto-generated method stub

	}
	
	public void setTournament(Tournament t) {
		// TODO
	}
	
	public void setTable(Tournament t) {
		// TODO
	}

}
