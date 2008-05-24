package org.cgympoker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
            return Calendar.getInstance().getTime();
	}

	@Override
	public Date getStopTime() {
            return Calendar.getInstance().getTime();
	}

	@Override
	public List<Table> getTables() {
            return new ArrayList<Table>();
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
        return "ID";
    }

    public String getStatus() {
        return "Started";
    }

}
