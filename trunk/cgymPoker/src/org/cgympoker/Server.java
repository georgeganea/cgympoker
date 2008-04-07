package org.cgympoker;

import java.util.List;

public interface Server {
	List<Tournament> getAllTournaments();
	List<Tournament> getStartedTournaments();
	List<Tournament> getOpenTournaments();
	List<Player> getPlayers();
	Felix getFelix();
	void disconnect();
}
