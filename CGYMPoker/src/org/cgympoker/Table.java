package org.cgympoker;

import java.util.List;
import org.cgympoker.common.Card;
import org.cgympoker.common.Player;

public interface Table {
	public enum Status { ANTE, DEAL, BLIND, BET, FLOP,
		BET_FLOP, TURN, BET_TURN, RIVER, BET_RIVER, RESULT }
	
	public Status getStatus();
	public List<Player> getPlayers();
	public Player getActivePlayer();
	public Player getDealer();
	public List<Card> getCards();
        public String getBlinds();
}
