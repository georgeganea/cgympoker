package org.cgympoker;

import java.io.Serializable;
import org.cgympoker.common.Player;
import org.cgympoker.common.Card;
import java.util.List;

public class PlayerImpl implements Player,Serializable {
    private String name;
    private Integer money;

    public PlayerImpl(String name, Integer money){
        this.name = name;
        this.money = money;
    }
    
    @Override
    public List<Card> getCards() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getChipCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfCards() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getState() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getStateOfCards() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void flipCards() {
    // TODO
    }

    public Integer getMoney() {
        return money;
    }
}
