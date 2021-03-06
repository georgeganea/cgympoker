package org.cgympoker;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Player;
import org.cgympoker.common.Card;
import java.util.List;
import org.cgympoker.common.Server;

public class PlayerImpl implements Player{
    private Server server;
    private ArrayList<Card> cards = new ArrayList<Card>();
    


    public PlayerImpl(Server server) {
       this.server = server;
      
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void setCards(ArrayList<Card> cards){
        this.cards = cards;
    }
    
    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public int getChipCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName() {
        try {
            return server.getName();
        } catch (RemoteException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public int getNumberOfCards() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getState() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getStateOfCards() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void flipCards() {
    // TODO
    }

    public Integer getMoney() {
        try {
            return server.getMoney();
        } catch (RemoteException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public String toString(){
        try {
            return server.getName();
        } catch (RemoteException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "remote exception happened";
    }
}
