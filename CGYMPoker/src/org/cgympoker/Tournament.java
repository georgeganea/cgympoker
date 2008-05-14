package org.cgympoker;

import java.util.Date;
import java.util.List;

public interface Tournament {

	public List<Table> getTables();
	public List<Player> getPlayers();
	public List<Player> getActivePlayers();
	public List<Player> getEliminatedPlayers();
	public String getID();
	public Date getStartTime();
	public Date getStopTime();
       /**
        * 
        * @return the status of the Tournament:STARTED,...
        */ 
        public String getStatus();
}
