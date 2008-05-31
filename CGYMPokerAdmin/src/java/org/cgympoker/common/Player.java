package org.cgympoker.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Player extends Remote{

	public String getName() throws RemoteException;
	public int getChipCount() throws RemoteException;
	public int getNumberOfCards() throws RemoteException;
	public int getStateOfCards() throws RemoteException;
	public List<Card> getCards() throws RemoteException;
	public boolean getState() throws RemoteException; // active, observer
        public Integer getMoney() throws RemoteException;
}
