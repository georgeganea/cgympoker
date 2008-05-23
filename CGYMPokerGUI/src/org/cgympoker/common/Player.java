package org.cgympoker.common;

import org.cgympoker.common.*;
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