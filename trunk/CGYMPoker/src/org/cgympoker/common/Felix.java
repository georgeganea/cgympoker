package org.cgympoker.common;

public interface Felix {
	public void joinTournament(Tournament t);
	public void leaveTournamnent();
	public void bet(int amount);
	public void raise(int amount);
	public void call();
	public void check();
	public void fold();
}
