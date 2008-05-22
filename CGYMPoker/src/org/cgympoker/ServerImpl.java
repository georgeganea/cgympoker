package org.cgympoker;

import org.cgympoker.common.Felix;
import org.cgympoker.common.Player;
import org.cgympoker.common.Server;
import org.cgympoker.common.Tournament;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.cgympoker.remoteobserver.Subscriber;

public class ServerImpl implements  Server,Serializable{
    
    

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tournament> getAllTournaments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Felix getFelix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tournament> getOpenTournaments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tournament> getStartedTournaments() {
		// TODO Auto-generated method stub
		return null;
	}

    public void addSubscriber(Subscriber s) throws RemoteException {
       System.out.println("ceva subscriber adaugat ");
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeSubscriber(Subscriber s) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeAllSubscribers() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
	

}
