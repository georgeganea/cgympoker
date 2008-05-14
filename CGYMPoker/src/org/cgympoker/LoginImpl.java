package org.cgympoker;

import java.rmi.RemoteException;

public class LoginImpl implements Login{

    public Server login(String user, String pass)  {
        System.out.println("am apelat o metoda de pe server");
        return new ServerImpl();
    }

    public Server createAccount(String user, String pass, String firstName, String lastName, String eMail) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

}
