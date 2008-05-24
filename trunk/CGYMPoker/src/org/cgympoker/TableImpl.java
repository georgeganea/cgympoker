package org.cgympoker;

import java.io.Serializable;
import org.cgympoker.common.Table;
import org.cgympoker.common.Player;
import org.cgympoker.common.Card;
import java.util.List;

public class TableImpl implements Table,Serializable {

	@Override
	public Player getActivePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> getCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getDealer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void reset() {
		// TODO
	}
	
	public void addPlayer(Player p) {
		// TODO
	}
	
	public void removePlayer(Player p) {
		// TODO
	}

	public void bet(Player p, int amount) {
		// TODO
	}
	
	public void fold(Player p) {
		// TODO
	}
	
	private void advanceState() {
		// TODO
	}

        public String getBlinds() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    public Integer getAveragePot() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
