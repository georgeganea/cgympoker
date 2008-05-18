/*
 * CGYMServerView.java
 *
 * Created on 22 aprilie 2008, 00:10
 */

package org.cgympoker.gui;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.cgympoker.Server;
import org.cgympoker.Table;
import org.cgympoker.Tournament;
import org.cgympoker.gui.test.CGYMServerViewTest;

/**
 *
 * @author  Mihai
 */
public class CGYMServerView extends javax.swing.JFrame {
    private final Server server;
    private Object[][] tournaments, tables;
    private List<Tournament> tournamentList;
    private DefaultListSelectionModel listSelectionModel;
    private List<Table> tablesList;
    private DefaultTableModel tablesModel;
   
    /** Creates new form CGYMServerView */
    public CGYMServerView(Server server) {
        this.server = CGYMServerViewTest.createTestServer();//server;
        initListeners();
        initModels();
        initTournaments();
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        tablesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablesTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        playersPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        playersTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.cgympoker.gui.CGYMPokerApp.class).getContext().getResourceMap(CGYMServerView.class);
        tournamentsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("tournamentsPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("tournamentsPanel.border.titleColor"))); // NOI18N
        tournamentsPanel.setName("tournamentsPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tournamentsTable.setModel(new javax.swing.table.DefaultTableModel(tournaments, new String [] {"ID", "Status", "Start Time"}));
        tournamentsTable.setName("tournamentsTable"); // NOI18N
        tournamentsTable.setSelectionModel(listSelectionModel);
        tournamentsTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tournamentsTable);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout tournamentsPanelLayout = new javax.swing.GroupLayout(tournamentsPanel);
        tournamentsPanel.setLayout(tournamentsPanelLayout);
        tournamentsPanelLayout.setHorizontalGroup(
            tournamentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tournamentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tournamentsPanelLayout.setVerticalGroup(
            tournamentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tournamentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tablesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("tablesPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("tablesPanel.border.titleColor"))); // NOI18N
        tablesPanel.setName("tablesPanel"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tablesTable.setModel(tablesModel);
        tablesTable.setColumnSelectionAllowed(true);
        tablesTable.setName("tablesTable"); // NOI18N
        tablesTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tablesTable);
        tablesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("jPanel3.border.titleColor"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(890, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(29, 29, 29))
        );

        playersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("playersPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("playersPanel.border.titleColor"))); // NOI18N
        playersPanel.setName("playersPanel"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        playersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Player", "City", "Money"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        playersTable.setColumnSelectionAllowed(true);
        playersTable.setName("playersTable"); // NOI18N
        playersTable.setShowVerticalLines(false);
        jScrollPane3.setViewportView(playersTable);
        playersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N

        javax.swing.GroupLayout playersPanelLayout = new javax.swing.GroupLayout(playersPanel);
        playersPanel.setLayout(playersPanelLayout);
        playersPanelLayout.setHorizontalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playersPanelLayout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(jButton4))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        playersPanelLayout.setVerticalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
        );

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tournamentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tablesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(playersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tournamentsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel playersPanel;
    private javax.swing.JTable playersTable;
    private javax.swing.JPanel tablesPanel;
    private javax.swing.JTable tablesTable;
    private javax.swing.JPanel tournamentsPanel;
    private javax.swing.JTable tournamentsTable;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
      listSelectionModel = new DefaultListSelectionModel();
      listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    if (tournamentsTable.getSelectedRow() != -1)
                        updateTablesTable(tournamentList.get(tournamentsTable.getSelectedRow()));
                }
            }
        });
    }

    private void initModels() {
        tablesModel = new DefaultTableModel(tables, new String [] {"Status", "Blinds", "Players", "Avg Pot"});
    }
    // End of variables declaration

    private void updateTablesTable(Tournament tournament) {
        System.out.println("Se va face update la tabela pentru turneul:"+tournament.getID());
        tablesList = tournament.getTables();
        System.out.println(tournament.getTables().size());
        tables = new Object[tablesList.size()][4];
        Iterator<Table> iterator = tablesList.iterator();
        tablesModel.setRowCount(0);
        int i = 0;
        while(iterator.hasNext()){
            Table table = iterator.next();
            tables[i][0] = table.getStatus();
            tables[i][1] = table.getBlinds();
            tables[i][2] = table.getPlayers().size();
            tables[i][3] = table.getAveragePot();
            tablesModel.addRow(tables[i]);
            i++;
        }
        //To do:repaint the table
    }
    
    private void initTournaments() {
        tournamentList = server.getAllTournaments();
        tournaments = new Object[tournamentList.size()][3];
        Iterator<Tournament> iterator = tournamentList.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int i = 0;
        while(iterator.hasNext()){
            Tournament tournament = iterator.next();
            tournaments[i][0] = tournament.getID();
            tournaments[i][1] = tournament.getStatus();
            tournaments[i][2] = sdf.format(tournament.getStartTime());
            i++;
        }
    }
    
}