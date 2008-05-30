/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.remoteobserver;

import org.cgympoker.remoteobserver.Subscriber;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author george
 */
public interface Publisher extends Remote {  
  public void addSubscriber(Subscriber s)  
    throws RemoteException; 

  public void removeSubscriber(Subscriber s)  
    throws RemoteException; 

  public void removeAllSubscribers()  
    throws RemoteException; 
} 
  
