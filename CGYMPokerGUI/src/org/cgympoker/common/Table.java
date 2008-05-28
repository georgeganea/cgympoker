package org.cgympoker.common;
import java.rmi.RemoteException;
import java.util.List;
import org.cgympoker.remoteobserver.Publisher;

public interface Table extends Publisher {
	public enum Status { ANTE, DEAL, BLIND, BET, FLOP,
		BET_FLOP, TURN, BET_TURN, RIVER, BET_RIVER, RESULT }
	
	public Status getStatus() throws RemoteException;
	public List<Player> getPlayers()throws RemoteException;
	public Player getActivePlayer()throws RemoteException;
	public Player getDealer()throws RemoteException;
	public List<Card> getCards()throws RemoteException;
        public String getBlinds()throws RemoteException;
        public Integer getAveragePot()throws RemoteException;
}
