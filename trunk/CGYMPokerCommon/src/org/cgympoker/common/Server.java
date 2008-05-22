package org.cgympoker.common;

import org.cgympoker.common.*;
import java.rmi.Remote;
import java.util.List;
import org.cgympoker.remoteobserver.Publisher;

public interface Server extends Publisher {
	public List<Tournament> getAllTournaments();
	public List<Tournament> getStartedTournaments();
	public List<Tournament> getOpenTournaments();
	public List<Player> getPlayers();
	public Felix getFelix();
	public void disconnect();
}
