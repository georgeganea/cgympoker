package org.cgympoker;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.cgympoker.common.Table;
import org.cgympoker.common.Player;
import org.cgympoker.common.Card;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.remoteobserver.BasicPublisher;
import org.cgympoker.remoteobserver.Subscriber;

public class TableImpl implements Table, Serializable {

    private Status status;
    private String blinds;
    private ArrayList<Player> playerList;
    private Integer averagePot;
    
    public TableImpl(Status status, String blinds, ArrayList<Player> playerList, Integer averagePot) {
        this.status = status;
        this.blinds = blinds;
        this.playerList = playerList;
        this.averagePot = averagePot;
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(ServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Player getActivePlayer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Card> getCards() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Player getDealer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Player> getPlayers() {
        return playerList;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public void reset() {
/*
        while(true){
            try {
                Thread.sleep(1000);
                 publisher.notifySubscribers("carmen");
                Thread.sleep(1000);
                 Thread.sleep(1000);
                 publisher.notifySubscribers("ioana");
                 Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TableImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
   
        }
 */
    }

    public void addPlayer(Player p) {
    // TODO
    }

    public void removePlayer(Player p) {
    // TODO
    }

    public void bet(Player p, int amount) {
    // TODO
    }

    public void fold(Player p) {
    // TODO
    }

    private void advanceState() {
    // TODO
    }

    public String getBlinds() {
        return blinds;
    }

    public Integer getAveragePot() {
       return averagePot;
    }
    
    private BasicPublisher publisher = new BasicPublisher();

    public void addSubscriber(Subscriber s) throws RemoteException {
        publisher.addSubscriber(s);
            
    }

    public void removeSubscriber(Subscriber s) throws RemoteException {
        publisher.removeSubscriber(s);
    }

    public void removeAllSubscribers() throws RemoteException {
        publisher.removeAllSubscribers();
    }
}
