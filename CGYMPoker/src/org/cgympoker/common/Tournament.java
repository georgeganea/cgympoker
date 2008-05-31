package org.cgympoker.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Tournament extends Remote {

        public void createTable(Table tableImpl)throws RemoteException;
        public Player join(Server server) throws RemoteException;
	public List<Table> getTables()throws RemoteException;
	public List<Player> getPlayers()throws RemoteException;
	public List<Player> getActivePlayers()throws RemoteException;
	public List<Player> getEliminatedPlayers()throws RemoteException;
	public String getID()throws RemoteException;
       /**
        * 
        * @return the status of the Tournament:STARTED,...
        */ 
        public String getStatus()throws RemoteException;
}
