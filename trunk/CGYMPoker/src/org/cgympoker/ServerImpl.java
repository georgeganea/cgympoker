package org.cgympoker;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Felix;
import org.cgympoker.common.Player;
import org.cgympoker.common.Server;
import org.cgympoker.common.Tournament;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.cgympoker.remoteobserver.Subscriber;

public class ServerImpl implements  Server,Serializable{
    public ServerImpl() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

	public void disconnect() throws RemoteException{
		// TODO Auto-generated method stub
		
	}


	public List<Tournament> getAllTournaments() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}


	public Felix getFelix() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}


	public List<Tournament> getOpenTournaments() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}


	public List<Player> getPlayers() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}


	public List<Tournament> getStartedTournaments() throws RemoteException{
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
