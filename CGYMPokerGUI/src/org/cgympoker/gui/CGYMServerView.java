/*
 * CGYMServerView.java
 *
 * Created on 22 aprilie 2008, 00:10
 */

package org.cgympoker.gui;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.cgympoker.common.Player;
import org.cgympoker.common.Server;
import org.cgympoker.common.Table;
import org.cgympoker.common.Tournament;
import org.cgympoker.remoteobserver.Subscriber;

/**
 *
 * @author  Mihai
 */
public class CGYMServerView extends javax.swing.JFrame {
     private class ViewSubscriber implements Subscriber {

        public ViewSubscriber() {
            try {
                UnicastRemoteObject.exportObject(this, 0);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        public void update(Object pub, Object code) throws RemoteException {
            System.out.println("Se va face un update");
            updateTournamentsTable((ArrayList)pub);
        }
    }
    
    private Subscriber subscriber = new ViewSubscriber();
    public Subscriber getSubscriber(){
      return subscriber;
    }
    private final Server server;
    private Object[][] tournaments, tables, players;
    private List<Tournament> tournamentList;
    private DefaultListSelectionModel tournamentsSelectionModel;
    private List<Table> tablesList;
    private DefaultTableModel tablesModel, playersModel;
    private List<Player> playersList;
    private DefaultListSelectionModel tablesSelectionModel;
    private DefaultTableModel tournamentsModel;
   
    /** Creates new form CGYMServerView */
    public CGYMServerView(Server server) {
        this.server = server;
        initListeners();
        initModels();
        initComponents();
        initTournaments();
    }
    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tournamentsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tournamentsTable = new javax.swing.JTable();
        joinTournamentButton = new javax.swing.JButton();
        tablesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablesTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        playersPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        playersTable = new javax.swing.JTable();
        observeTableButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.cgympoker.gui.CGYMPokerApp.class).getContext().getResourceMap(CGYMServerView.class);
        tournamentsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("tournamentsPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("tournamentsPanel.border.titleColor"))); // NOI18N
        tournamentsPanel.setName("tournamentsPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tournamentsTable.setModel(tournamentsModel);
        tournamentsTable.setName("tournamentsTable"); // NOI18N
        tournamentsTable.setSelectionModel(tournamentsSelectionModel);
        tournamentsTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tournamentsTable);

        joinTournamentButton.setText(resourceMap.getString("joinTournamentButton.text")); // NOI18N
        joinTournamentButton.setName("joinTournamentButton"); // NOI18N
        joinTournamentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                joinTournamentButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tournamentsPanelLayout = new javax.swing.GroupLayout(tournamentsPanel);
        tournamentsPanel.setLayout(tournamentsPanelLayout);
        tournamentsPanelLayout.setHorizontalGroup(
            tournamentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tournamentsPanelLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(joinTournamentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tournamentsPanelLayout.setVerticalGroup(
            tournamentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tournamentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joinTournamentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tablesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("tablesPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("tablesPanel.border.titleColor"))); // NOI18N
        tablesPanel.setName("tablesPanel"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tablesTable.setModel(tablesModel);
        tablesTable.setName("tablesTable"); // NOI18N
        tablesTable.setSelectionModel(tablesSelectionModel);
        tablesTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tablesTable);

        javax.swing.GroupLayout tablesPanelLayout = new javax.swing.GroupLayout(tablesPanel);
        tablesPanel.setLayout(tablesPanelLayout);
        tablesPanelLayout.setHorizontalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        tablesPanelLayout.setVerticalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("jPanel3.border.titleColor"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        statusLabel.setText(resourceMap.getString("statusLabel.text")); // NOI18N
        statusLabel.setName("statusLabel"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addContainerGap(574, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(statusLabel)
                .addGap(29, 29, 29))
        );

        playersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("playersPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("playersPanel.border.titleColor"))); // NOI18N
        playersPanel.setName("playersPanel"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        playersTable.setModel(playersModel);
        playersTable.setName("playersTable"); // NOI18N
        playersTable.setShowVerticalLines(false);
        jScrollPane3.setViewportView(playersTable);

        observeTableButton.setText(resourceMap.getString("observeTableButton.text")); // NOI18N
        observeTableButton.setName("observeTableButton"); // NOI18N
        observeTableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                observeTableButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout playersPanelLayout = new javax.swing.GroupLayout(playersPanel);
        playersPanel.setLayout(playersPanelLayout);
        playersPanelLayout.setHorizontalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playersPanelLayout.createSequentialGroup()
                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(observeTableButton)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playersPanelLayout.setVerticalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(observeTableButton))
        );

        disconnectButton.setText(resourceMap.getString("disconnectButton.text")); // NOI18N
        disconnectButton.setName("disconnectButton"); // NOI18N
        disconnectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disconnectButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tournamentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tablesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(playersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(disconnectButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tournamentsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(disconnectButton)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-885)/2, (screenSize.height-480)/2, 885, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void joinTournamentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joinTournamentButtonMouseClicked
        int currentSelection = tournamentsTable.getSelectedRow();
        if (currentSelection!=-1)
            try {
            System.out.println("S-a facut join pentru turneul:" + tournamentList.get(currentSelection).getID());
        } catch (RemoteException ex) {
            Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_joinTournamentButtonMouseClicked

    private void observeTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_observeTableButtonMouseClicked
        int currentSelection = tablesTable.getSelectedRow();
        if (currentSelection!=-1)
            try {
            System.out.println("Observe pentru masa:" + tablesList.get(currentSelection).getStatus());
        } catch (RemoteException ex) {
            Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_observeTableButtonMouseClicked

    private void disconnectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disconnectButtonMouseClicked
        try {
            server.disconnect();//GEN-LAST:event_disconnectButtonMouseClicked
        } catch (RemoteException ex) {
            Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                             
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CGYMServerView(null).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton disconnectButton;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton joinTournamentButton;
    private javax.swing.JButton observeTableButton;
    private javax.swing.JPanel playersPanel;
    private javax.swing.JTable playersTable;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel tablesPanel;
    private javax.swing.JTable tablesTable;
    private javax.swing.JPanel tournamentsPanel;
    private javax.swing.JTable tournamentsTable;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
      tournamentsSelectionModel = new DefaultListSelectionModel();
      tournamentsSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    if (tournamentsTable.getSelectedRow() != -1)
                        updateTablesTable(tournamentList.get(tournamentsTable.getSelectedRow()));
                }
            }
        });
        
      tablesSelectionModel = new DefaultListSelectionModel();
      tablesSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    if (tablesTable.getSelectedRow() != -1)
                        updatePlayersTable(tablesList.get(tablesTable.getSelectedRow()));
                }
            }
        });
    }

    private void initModels() {
        tournamentsModel = new DefaultTableModel(tournaments, new String [] {"ID", "Status"});
        tablesModel = new DefaultTableModel(tables, new String [] {"Status", "Blinds", "Players", "Avg Pot"});
        playersModel = new DefaultTableModel(players, new String [] {"Player", "Money"});
    }
    // End of variables declaration

    private void updateTablesTable(Tournament tournament) {
        try {
            tablesList = tournament.getTables();
        System.out.println(tournament.getTables().size());
        } catch (RemoteException ex) {
            Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        tables = new Object[tablesList.size()][4];
        Iterator<Table> iterator = tablesList.iterator();
        tablesModel.setRowCount(0);
        int i = 0;
        while(iterator.hasNext()){
            Table table = iterator.next();
            try {
                tables[i][0] = table.getStatus();
                tables[i][1] = table.getBlinds();
            tables[i][2] = table.getPlayers().size();
            tables[i][3] = table.getAveragePot();
            } catch (RemoteException ex) {
                Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            tablesModel.addRow(tables[i]);
            i++;
        }
    }
    
   
    
    private void updatePlayersTable(Table table) {
        try {
            playersList = table.getPlayers();
        } catch (RemoteException ex) {
            Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        players = new Object[playersList.size()][2];
        Iterator<Player> iterator = playersList.iterator();
        playersModel.setRowCount(0);
        int i = 0;
        while(iterator.hasNext()){
            Player player = iterator.next();
            players[i][0] = player.getName();
            players[i][1] = player.getMoney();
            playersModel.addRow(players[i]);
            i++;
        }
    }

    private void updateTournamentsTable(ArrayList list) {
        System.out.println("Update pentru tournaments table");
        tournamentList = list;
        tournaments = new Object[list.size()][2];
        Iterator<Tournament> iterator = list.iterator();
        tournamentsModel.setRowCount(0);
        int i = 0;
        while (iterator.hasNext()) {
            Tournament tournament = iterator.next();
            try {
                tournaments[i][0] = tournament.getID();
                tournaments[i][1] = tournament.getStatus();
            } catch (RemoteException ex) {
                Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            tournamentsModel.addRow(tournaments[i]);
            i++;
        }

    }

    private void initTournaments() {
        try {
            tournamentList = server.getAllTournaments();
            tournaments = new Object[tournamentList.size()][2];
            Iterator<Tournament> iterator = tournamentList.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Tournament tournament = iterator.next();
                tournaments[i][0] = tournament.getID();
                tournaments[i][1] = tournament.getStatus();
                tournamentsModel.addRow(tournaments[i]);
                i++;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(CGYMServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
