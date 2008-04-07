package org.cgympoker;

import java.util.List;

public interface Table {
	Player getActivePlayer();
	List<Card> getCards();
}
