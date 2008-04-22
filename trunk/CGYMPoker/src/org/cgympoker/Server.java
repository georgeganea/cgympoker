package org.cgympoker;

import java.util.List;

public interface Server {
	public List<Tournament> getAllTournaments();
	public List<Tournament> getStartedTournaments();
	public List<Tournament> getOpenTournaments();
	public List<Player> getPlayers();
	public Felix getFelix();
	public void disconnect();
}
