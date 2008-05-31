/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ioana
 */
public interface ServerCentral extends Remote{
    public void createTournament(int nrMaxplayers,Date startTime, Date stopTime) throws RemoteException;
    public List<Tournament> getAllTournaments() throws RemoteException;
    public ArrayList<String> getUserList(String directory)throws RemoteException;
    public void deleteUser(String username)throws RemoteException;
    public ArrayList<String> getUserInfo(String username)throws FileNotFoundException,IOException,RemoteException;
}
