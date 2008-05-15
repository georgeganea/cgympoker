/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.gui.test;

import java.util.*;
import java.util.ArrayList;
import org.cgympoker.Card;
import org.cgympoker.Felix;
import org.cgympoker.Player;
import org.cgympoker.PlayerImpl;
import org.cgympoker.Server;
import org.cgympoker.Table;
import org.cgympoker.Tournament;

public class CGYMServerViewTest{
    public static Server createTestServer(){
        return new Server() {

            public List<Tournament> getAllTournaments() {
                List<Tournament> list = new ArrayList<Tournament>();
                Tournament t1 = new Tournament() {

                    public List<Table> getTables() {
                        List <Table> tableList = new ArrayList<Table>();
                        Table t1 = new Table() {

                            public Status getStatus() {
                                return Status.ANTE;
                            }

                            public List<Player> getPlayers() {
                                List<Player> playerList = new ArrayList<Player>();
                                playerList.add(new PlayerImpl());
                                return playerList;
                            }

                            public Player getActivePlayer() {
                                throw new UnsupportedOperationException("Not supported yet.");
                            }

                            public Player getDealer() {
                                throw new UnsupportedOperationException("Not supported yet.");
                            }

                            public List<Card> getCards() {
                                throw new UnsupportedOperationException("Not supported yet.");
                            }

                            public String getBlinds() {
                                return "1/2";
                            }

                            public Integer getAveragePot() {
                                return 10;
                            }
                        };
                        tableList.add(t1);
                        return tableList;
                    }

                    public List<Player> getPlayers() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public List<Player> getActivePlayers() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public List<Player> getEliminatedPlayers() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public String getID() {
                        return "Tournament 1";
                    }

                    public Date getStartTime() {
                        return Calendar.getInstance().getTime();
                    }

                    public Date getStopTime() {
                        return Calendar.getInstance().getTime();
                    }

                    public String getStatus() {
                        return "Started";
                    }
                };
                list.add(t1);
                Tournament t2 = new Tournament() {

                    public List<Table> getTables() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public List<Player> getPlayers() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public List<Player> getActivePlayers() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public List<Player> getEliminatedPlayers() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public String getID() {
                        return "Tournament 2";
                    }

                    public Date getStartTime() {
                        return Calendar.getInstance().getTime();
                    }

                    public Date getStopTime() {
                        return Calendar.getInstance().getTime();
                    }

                    public String getStatus() {
                        return "Started";
                    }
                };
                list.add(t2);
                list.add(t1);
                return list;
            }

            public List<Tournament> getStartedTournaments() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<Tournament> getOpenTournaments() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<Player> getPlayers() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Felix getFelix() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void disconnect() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
}
