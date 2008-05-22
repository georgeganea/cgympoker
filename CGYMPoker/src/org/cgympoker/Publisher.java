/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author carmen
 */
public interface Publisher extends Remote {  
  public void addSubscriber(Subscriber s)  
    throws RemoteException; 

  public void removeSubscriber(Subscriber s)  
    throws RemoteException; 

  public void removeAllSubscribers()  
    throws RemoteException; 
} 
  
