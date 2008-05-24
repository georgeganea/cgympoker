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

        private String ID;
        private String status;
        private Date startTime;
        private Date stopTime;
        private ArrayList<Table> tablesList = new ArrayList<Table>();
        
        public TournamentImpl(String ID,Date startDate,Date stopDate){
               this.ID = ID;
               this.status = "WAITING TO START";
               this.startTime = startDate;
               this.stopTime = stopDate;
        }
        
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
            return startTime;
	}

	@Override
	public Date getStopTime() {
            return stopTime;
	}

	@Override
	public List<Table> getTables() {
            return tablesList;
	}
        
        public void addTable(Table table){
            tablesList.add(table);
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
        return ID;
    }

    public String getStatus() {
        return "Started";
    }

    public void createTable(TableImpl tableImpl) {
        tablesList.add(tableImpl);
    }

}
