package org.cgympoker;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
       /* if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
            
        try {     
            String name = "CgymPokerLogin";
            LoginImpl server = new LoginImpl() ;
            Login stub = (Login) UnicastRemoteObject.exportObject(server, 0);
           Registry registry = LocateRegistry.getRegistry();
            
            registry.rebind(name, stub);
        //    Naming.rebind(name, stub);
            
            System.out.println("CgymPokerLogin");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

        

}
