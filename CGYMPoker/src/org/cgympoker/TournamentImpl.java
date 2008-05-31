package org.cgympoker;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Table;
import org.cgympoker.common.Player;
import org.cgympoker.common.Tournament;
import java.util.List;

public class TournamentImpl implements Tournament {

    private String ID;
    private ArrayList<Table> tablesList = new ArrayList<Table>();
    private enum Status {JOIN_OPEN,STARTED};
    private Status status;

    public TournamentImpl(String ID) {
        this.ID = ID;
        this.status = Status.JOIN_OPEN;
        try {
            UnicastRemoteObject.exportObject((Remote) this, 0);
        } catch (RemoteException ex) {
            Logger.getLogger(TournamentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Player> getActivePlayers() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Player> getEliminatedPlayers() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Player> getPlayers() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Table> getTables() throws RemoteException {
        return tablesList;
    }

    public void addTable(Table table) throws RemoteException {
        tablesList.add(table);
    }

    public void start() throws RemoteException {
    // TODO porneste turneul
		/*
     * 1. creeaza mesele de joc
     * 2. repartizeaza jucatorii
     * 3. le da bani
     * 4. reseteaza mesele
     */
    }

    public void stop() throws RemoteException {
    // TODO
    }

    public String getID() throws RemoteException {
        //TO DO returneaza un identificator al turneului
        return ID;
    }

    public String getStatus() throws RemoteException {
        return status.toString();
    }

    public void createTable(Table tableImpl) throws RemoteException {
        tablesList.add(tableImpl);
    }
}
