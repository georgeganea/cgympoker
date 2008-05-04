package org.cgympoker;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Login extends Remote{
	public void login() throws RemoteException;
}

