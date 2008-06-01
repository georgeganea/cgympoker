package org.cgympoker;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Server;
import org.cgympoker.common.Table;
import org.cgympoker.common.Player;
import org.cgympoker.common.Tournament;
import java.util.List;
import org.cgympoker.remoteobserver.BasicPublisher;
import org.cgympoker.remoteobserver.Subscriber;

public class TournamentImpl implements Tournament {
   
    private String ID;
    private ArrayList<Table> tablesList = new ArrayList<Table>();
    private ArrayList<Player> players = new ArrayList<Player>();
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
       return players;
    }

    @Override
    public List<Table> getTables() throws RemoteException {
        return tablesList;
    }

    public void addTable(Table table) throws RemoteException {
        tablesList.add(table);
    }

    public void start() throws RemoteException {
        this.status = Status.STARTED;
        ArrayList<Player> tablePlayers = new ArrayList<Player>();
        for(int i=0;i<players.size();i++){
            if (i%8 == 0 && i!=0){
                tablesList.add(new TableImpl(TableImpl.Status.ANTE, "2/4", tablePlayers, 10));
                tablePlayers = new ArrayList<Player>();
            }
            else{
                tablePlayers.add(players.get(i));
            }
        }
        if (tablePlayers.size() > 0)
            tablesList.add(new TableImpl(TableImpl.Status.ANTE, ID+(players.size()/8), tablePlayers, 10));
        System.out.println("Numarul de mese:"+tablesList.size());
        System.out.println("Player-ii de la prima masa:"+tablesList.get(0).getPlayers());
    // TODO porneste turneul
		/*
     * 1. creeaza mesele de joc
     * 2. repartizeaza jucatorii
     * 3. le da bani
     * 4. reseteaza mesele
     */
        
        //notificam masa cu masa, player cu player 
        Iterator<Table> it = tablesList.iterator();
        while(it.hasNext()){
            Table table = it.next();
            Iterator<Player> playerIt = table.getPlayers().iterator();
            while(playerIt.hasNext()){
                Player player = playerIt.next();
                subscriberHash.get(player).update(new FelixImpl(/*de adaugat stuff in constructor*/), table);
            }
        }
      
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
    private HashMap<Player,Subscriber> subscriberHash = new HashMap<Player, Subscriber>();
    
    public Player join(Server server,Subscriber subscriber) throws RemoteException {
        boolean exists = false;
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()){
            Player player = iterator.next();
            if (player.getName().compareTo(server.getName()) == 0){
                    exists = true;
                    break;
            }
        }
        if (exists)
            return null;
        else {
            PlayerImpl player = new PlayerImpl(server);
            players.add(player);
            subscriberHash.put(player, subscriber);
            return player;
        }
    }

    public void addSubscriber(Subscriber s) throws RemoteException {
       // publisher.addSubscriber(s);
    }

    public void removeSubscriber(Subscriber s) throws RemoteException {
        //publisher.removeSubscriber(s);
    }

    public void removeAllSubscribers() throws RemoteException {
        //publisher.removeAllSubscribers(); 
        //TODO trebuie scos Publisher de la Tournament !!
    }
}
