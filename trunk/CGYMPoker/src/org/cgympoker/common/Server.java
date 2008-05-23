package org.cgympoker.common;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.util.List;
import org.cgympoker.remoteobserver.Publisher;

public interface Server extends Publisher {
	public List<Tournament> getAllTournaments() throws RemoteException;
	public List<Tournament> getStartedTournaments() throws RemoteException;
	public List<Tournament> getOpenTournaments()throws RemoteException;
	public List<Player> getPlayers()throws RemoteException;
	public Felix getFelix()throws RemoteException;
	public void disconnect()throws RemoteException;

        public void update(ArrayList<Tournament> tournaments) throws RemoteException;
}

