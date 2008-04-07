package org.cgympoker;

public interface Felix {
	public void joinTournament(Tournament t);
	public void leaveTournamnent(Tournament t);
	public void bet(int amount);
	public void raise(int amount);
	public void call();
	public void check();
	public void fold();
}
