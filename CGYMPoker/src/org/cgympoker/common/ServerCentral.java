/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ioana
 */
public interface ServerCentral extends Remote{
    public void createTournament(Date startTime, Date stopTime) throws RemoteException;
    public List<Tournament> getAllTournaments() throws RemoteException;
}
