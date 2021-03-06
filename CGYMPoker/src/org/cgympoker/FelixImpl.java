package org.cgympoker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Felix;
import org.cgympoker.common.Player;
import org.cgympoker.common.Table;
import org.cgympoker.common.Tournament;

public class FelixImpl implements Felix {

    private Player player;
    private Table table;

    public FelixImpl(Player player, Table table) {
        this.player = player;
        this.table = table;
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(FelixImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void bet(int amount) {
        ((TableImpl)table).bet(player, amount);
        
    }

    @Override
    public void call() {
    // TODO Auto-generated method stub

    }

    @Override
    public void check() {
    // TODO Auto-generated method stub

    }

    @Override
    public void fold() {
    // TODO Auto-generated method stub

    }

    @Override
    public void leaveTournamnent() {
    // TODO Auto-generated method stub

    }

    @Override
    public void raise(int amount) {
    // TODO Auto-generated method stub

    }

    public void setTournament(Tournament t) {
    // TODO
    }

    public void setTable(Tournament t) {
    // TODO
    }

    public Player getMySelf() throws RemoteException {
        return player;
    }

    public ArrayList<Player> getOponents() throws RemoteException {
        ArrayList<Player> returnList = new ArrayList<Player>();
        Iterator<Player> iterator = table.getPlayers().iterator();
        while (iterator.hasNext()){
            Player p = iterator.next();
            if (p.equals(player))
                continue;
            returnList.add(p);
        }
         return returnList;
    }

    public Table getTable() throws RemoteException {
       return table;
    }
}
