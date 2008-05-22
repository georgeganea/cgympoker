package org.cgympoker;

import org.cgympoker.*;
import java.util.List;

public interface Player {

	public String getName();
	public int getChipCount();
	public int getNumberOfCards();
	public int getStateOfCards();
	public List<Card> getCards();
	public boolean getState(); // active, observer
        public Integer getMoney();
}
