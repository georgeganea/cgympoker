package org.cgympoker;

import java.rmi.RemoteException;
import org.cgympoker.common.Felix;
import org.cgympoker.common.Login;
import org.cgympoker.common.Player;
import org.cgympoker.common.Tournament;
import org.cgympoker.common.Server;
import java.io.File;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Table.Status;
import org.cgympoker.test.CGYMServerTest;

public class ServerCentral {
    //singleton
    public static final ServerCentral INSTANCE = new ServerCentral();

    private ServerCentral() {
    }
    private static ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
    private static ArrayList<Server> servers = new ArrayList<Server>();

    public static void addServer(Server serv) {
        servers.add(serv);
    }

        /*
 * For testing purposes only
 */
    private static TableImpl table1;
    private static Tournament createDummyTournament(){
        Date date = Calendar.getInstance().getTime();
        Tournament t = new TournamentImpl("T1", date, date);
        table1 = new TableImpl(Status.ANTE, "10", new ArrayList<Player>(), new Integer(4));
        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(new PlayerImpl("Ioana", 100));
        playerList.add(new PlayerImpl("George", 30));
        TableImpl table2 = new TableImpl(Status.BET, "20", playerList, 5);
        try {
            t.createTable(table1);
             t.createTable(table2);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(ServerCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return t;
    }
    
    public static void createTournament(int maxPlayers, Date startTime, Date stopTime) {
        
        tournaments.add(createDummyTournament());
        //TODO de impl cu ceva timer sa se apeleze start tournament
        Iterator<Server> it = servers.iterator();
        while (it.hasNext()) {
            Server s = it.next();
            try {
                s.update(tournaments);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerCentral.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void removeOneTournament() {
        tournaments.remove(0);
        Iterator<Server> it = servers.iterator();
        while (it.hasNext()) {
            Server s = it.next();
            try {
                s.update(tournaments);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerCentral.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void startTournament(Tournament tour) {

    }

    public void joinTournament(Felix felix, Tournament tour) {
    //TODO
    }

    public void leaveTournament(Felix felix, Tournament tour) {
    //TODO
    }

    public void disconnectPlayer(Felix felix) {

    }

    public Server createServerInstance(String user) {
        return new ServerImpl();
    }

    public List<Tournament> getAllTournaments() {
       return tournaments;
    }

    public List<Tournament> getOpenTournaments() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Player> getPlayers() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Tournament> getStartedTournaments() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "policy");
        try {
            File file = new File("config.cgym");
            String classPath = file.getCanonicalPath().replace("config.cgym", "");
            classPath = classPath + "build" + File.separator + "classes";
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            System.out.println(">>>" + classPath);
            System.out.println(classPath);
            new ClassFileServer(2001, classPath);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(ServerCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String name = "CgymPokerLogin";
            LoginImpl server = new LoginImpl();

            Login stub = (Login) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();

            registry.rebind(name, stub);

            System.out.println("CgymPokerLogin");
         //   for (int i = 0; i < 1000; i++) {
              
                ServerCentral.createTournament(1, new Date(), new Date());
                Thread.sleep(2000);
                ((TableImpl)ServerCentral.tournaments.get(0).getTables().get(0)).reset();
                ServerCentral.createTournament(1, new Date(), new Date());
                Thread.sleep(2000);
                ServerCentral.removeOneTournament();
               // System.out.println("i=" + i);
           // }

        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
