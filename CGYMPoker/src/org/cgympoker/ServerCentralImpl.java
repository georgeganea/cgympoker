package org.cgympoker;

import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.ListIterator;
import org.cgympoker.common.Felix;
import org.cgympoker.common.Login;
import org.cgympoker.common.Player;
import org.cgympoker.common.Tournament;
import org.cgympoker.common.Server;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import org.cgympoker.common.ServerCentral;
import org.cgympoker.common.Table.Status;

public class ServerCentralImpl implements ServerCentral{
    //singleton
    public static final ServerCentralImpl INSTANCE = new ServerCentralImpl();

    private ServerCentralImpl() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(ServerCentralImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
    private static ArrayList<Server> servers = new ArrayList<Server>();
    private static String rootdir="."; //the path where we put the userfiles
    public static void addServer(Server serv) {
        servers.add(serv);
    }

        /*
 * For testing purposes only
 */
    private static TableImpl table1;
    private static Tournament createDummyTournament( Date startTime, Date stopTime){
        Date date = Calendar.getInstance().getTime();
        Tournament t = new TournamentImpl("T1", startTime, stopTime);
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
            Logger.getLogger(ServerCentralImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return t;
    }
    
    public void createTournament(int maxPlayers, Date startTime, Date stopTime) {
        
        tournaments.add(createDummyTournament(startTime,stopTime));
        //TODO de impl cu ceva timer sa se apeleze start tournament
        Iterator<Server> it = servers.iterator();
        while (it.hasNext()) {
            Server s = it.next();
            try {
                s.update(tournaments);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerCentralImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ServerCentralImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServerCentralImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String name = "CgymPokerLogin";
            LoginImpl server = new LoginImpl();

            Login stub = (Login) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();

            registry.rebind(name, stub);

            System.out.println("CgymPokerLogin");
            System.out.println("UsersList:"+ServerCentralImpl.INSTANCE.getUserList().size());
            for(int i=0;i<ServerCentralImpl.INSTANCE.getUserList().size();i++){
                System.out.println("USER:"+ServerCentralImpl.INSTANCE.getUserList().get(i));
            }
            System.out.println("Deleted!");
            for(int i=0;i<ServerCentralImpl.INSTANCE.getUserList().size();i++){
                System.out.println("USER:"+ServerCentralImpl.INSTANCE.getUserList().get(i));
            }
            for (int i = 0; i < 1000; i++) {
              
                ServerCentralImpl.INSTANCE.createTournament(1, new Date(), new Date());
                Thread.sleep(2000);
                ((TableImpl)ServerCentralImpl.tournaments.get(0).getTables().get(0)).reset();
                ServerCentralImpl.INSTANCE.createTournament(1, new Date(), new Date());
                Thread.sleep(2000);
                ServerCentralImpl.removeOneTournament();
                System.out.println("i=" + i);
            }

        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
    
    public File getUserFile(String username,String directory){
        File folder = new File(directory+"/");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if(listOfFiles[i].getName().compareTo(username+".cgym")==0)
                    return listOfFiles[i];
            } 
        }
        return null;

    }
    public ArrayList<String> getUserList() {
        String directory=rootdir;
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> templist=new ArrayList<String>();
        for (int i = 0; i< listOfFiles.length ; i++) {
            if (listOfFiles[i].isFile()&&(listOfFiles[i].getName().contains(".cgym"))) {
                templist. add(listOfFiles[i].getName());
            } 
        }
        return templist;
    }
    

    public void deleteUser(String username){
        File file=ServerCentralImpl.INSTANCE.getUserFile(username, rootdir);
        if(file!=null){
            file.delete();
        }
    }

    public ArrayList<String> getUserInfo(String username)throws FileNotFoundException,IOException{
        ArrayList info=new ArrayList<String>();
        File file=ServerCentralImpl.INSTANCE.getUserFile(username, rootdir);
        String temp; 
        try {
            BufferedReader reader = new BufferedReader(new FileReader(username));
            info.add(username);
            while((temp=reader.readLine())!=null){
                info.add(temp);
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

/*    public void createTournament(Date startTime, Date stopTime) throws RemoteException {
        System.out.println("Create tournament");
    } */
}
