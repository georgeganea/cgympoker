package org.cgympoker;

import java.io.Serializable;
import org.cgympoker.common.Table;
import org.cgympoker.common.Player;
import org.cgympoker.common.Tournament;
import java.util.Date;
import java.util.List;

public class TournamentImpl implements Tournament,Serializable {

	@Override
	public List<Player> getActivePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getEliminatedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getStopTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Table> getTables() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void start() {
		// TODO porneste turneul
		/*
		 * 1. creeaza mesele de joc
		 * 2. repartizeaza jucatorii
		 * 3. le da bani
		 * 4. reseteaza mesele
		 */
	}
	
	public void stop() {
		// TODO
	}

    public String getID() {
       //TO DO returneaza un identificator al turneului
        return "";
    }

    public String getStatus() {
        return "Started";
    }

}
