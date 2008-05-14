package org.cgympoker;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Login extends Remote{
	public Server login(String user,String pass) throws RemoteException;
        
        public Server createAccount(String user,String pass,String firstName,String lastName,String eMail) throws RemoteException;
}

