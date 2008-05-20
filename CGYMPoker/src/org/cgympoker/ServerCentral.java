package org.cgympoker;
import java.io.File;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerCentral {
	//singleton
	public static final ServerCentral INSTANCE = new ServerCentral();
	private ServerCentral(){
	}
	
	private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
	
	public Tournament createTournament(int maxPlayers, Date startTime , Date stopTime){
		//TODO de impl cu ceva timer sa se apeleze start tournament
		return null;
	}
	public void startTournament(Tournament tour){
		
	}
	
	public void joinTournament (Felix felix, Tournament tour){
		//TODO
	}
	public void leaveTournament(Felix felix, Tournament tour){
		//TODO
	}
	public void disconnectPlayer(Felix felix){
		
	}
	
	public Server createServerInstance(String user){
		//TODO
		return null; 
	}
    


	public List<Tournament> getAllTournaments() {
		// TODO Auto-generated method stub
		return null;
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
        try {
            /* if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
            }*/
            File file = new File("config.cgym");
            String classPath = file.getCanonicalPath().replace("config.cgym", "");
            classPath = classPath+"build" + File.separator + "classes";
            new ClassFileServer(2001, classPath);
        } catch (IOException ex) {
            Logger.getLogger(ServerCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {     
            String name = "CgymPokerLogin";
            LoginImpl server = new LoginImpl() ;
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
