/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.remoteobserver;

import org.cgympoker.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author george
 */
public class BasicPublisher implements Publisher { 
  protected Vector subscribers = new Vector(2); 

  public void addSubscriber(Subscriber s) { 
    subscribers.addElement(s); 
  } 

  public void removeSubscriber(Subscriber s) { 
    subscribers.removeElement(s); 
  } 

  public void removeAllSubscribers() { 
    subscribers.removeAllElements(); 
  } 

  public void notifySubscribers(Object pub, Object code) { 
    Vector deadSubs = null; 
    Enumeration e = subscribers.elements(); 
    while (e.hasMoreElements()) { 
      Subscriber s = (Subscriber) e.nextElement(); 
      try { s.update(pub, code); } 
      catch (java.rmi.ConnectException ce) { //serious 
        if (deadSubs == null) deadSubs = new Vector(); 
        deadSubs.addElement(s);// must be dead 
      } 
      catch (java.rmi.NoSuchObjectException nsoe){ //serious  
        if (deadSubs == null) deadSubs = new Vector(); 
        deadSubs.addElement(s);// must be dead 
      } 
      catch (java.rmi.RemoteException re) { 
        /*might recover?*/ 
      } 
    } 
    if (deadSubs != null) { 
      e = deadSubs.elements(); 
      while (e.hasMoreElements()) { 
        Subscriber s = (Subscriber) e.nextElement(); 
        removeSubscriber(s);  // forget this subscriber 
      } 
    } 
  } 

  public void notifySubscribers(Object pub) { 
    notifySubscribers(pub, null); 
  } 
} 

