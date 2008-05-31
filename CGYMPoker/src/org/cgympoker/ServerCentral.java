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
    
    public static void createTournament(String ID, Date startTime, Date stopTime) {
        
        tournaments.add(new TournamentImpl(ID));
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
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
