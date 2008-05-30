/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.remoteobserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author george
 */
public interface Subscriber extends Remote {  
  public void update(Object pub, Object code)  
    throws RemoteException; 
} 

