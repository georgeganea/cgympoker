package org.cgympoker.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Felix extends Remote{
	public void leaveTournamnent() throws RemoteException;
	public void bet(int amount) throws RemoteException;
	public void raise(int amount) throws RemoteException;
	public void call() throws RemoteException;
	public void check() throws RemoteException;
	public void fold() throws RemoteException;
}
