/*
 * CGYMPokerView.java
 */

package org.cgympoker.gui;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.cgympoker.Server;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.cgympoker.Login;


/**
 * The application's main frame.
 */
public class CGYMPokerView extends FrameView {
    private CGYMServerView serverView = null;
    private CGYMCreateAccount createAccountView = null;
    private Server server;

    public CGYMPokerView(SingleFrameApplication app) {
        super(app);

        initComponents();
        readUsernameAndPassword();
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = CGYMPokerApp.getApplication().getMainFrame();
            aboutBox = new CGYMPokerAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        CGYMPokerApp.getApplication().show(aboutBox);
    }

    //TODO : check username and password
    private Server checkData(String username, String password) {
        try {
            String name = "CgymPokerLogin";
            System.out.println("Trying to connect to:"+CGYMPokerUtil.getServerAddress());
            Registry registry = LocateRegistry.getRegistry(CGYMPokerUtil.getServerAddress());
            System.out.println("1-"+registry);
            Remote  login = (Remote) registry.lookup(name);
            System.out.println("2");
            Login log = (Login) login;
            System.out.println("3");
            return   log.login(username,password);
        } catch (Exception e) {
            System.err.println("CgymPokerLogin exception:");
            e.printStackTrace();
        }
        
      return null;
    }

    private Server checkInfo() {
        String username = usernameTextField.getText();
        if (username.trim().compareTo("") == 0) {
            CGYMPokerUtil.showErrorMessage(mainPanel,"Username cannot be left empty");
            return null;
        }
        char[] pass = passwordField.getPassword();
        String password = new String(pass);
        if (password.trim().compareTo("") == 0) {
            CGYMPokerUtil.showErrorMessage(mainPanel,"Password cannot be left empty");
            return null;
        }
        CGYMPokerUtil.saveUsernamePassword(passwordCheckBox.isSelected(), username, password);
        return checkData(username, password);
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLoginButton = new javax.swing.JButton();
        loginPanel = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordCheckBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        createAccountButton = new javax.swing.JButton();
        jExitButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.cgympoker.gui.CGYMPokerApp.class).getContext().getResourceMap(CGYMPokerView.class);
        mainPanel.setForeground(resourceMap.getColor("mainPanel.foreground")); // NOI18N
        mainPanel.setName("mainPanel"); // NOI18N

        jLoginButton.setText(resourceMap.getString("loginButton.text")); // NOI18N
        jLoginButton.setName("loginButton"); // NOI18N
        jLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoginButtonMouseClicked(evt);
            }
        });

        loginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("loginPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("loginPanel.border.titleFont"), resourceMap.getColor("loginPanel.border.titleColor"))); // NOI18N
        loginPanel.setName("loginPanel"); // NOI18N
        loginPanel.setOpaque(false);

        usernameTextField.setText(resourceMap.getString("usernameTextField.text")); // NOI18N
        usernameTextField.setName("usernameTextField"); // NOI18N

        passwordField.setText(resourceMap.getString("passwordField.text")); // NOI18N
        passwordField.setName("passwordField"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        passwordCheckBox.setName("passwordCheckBox"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(passwordCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(passwordField)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordCheckBox)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
        );

        createAccountButton.setText(resourceMap.getString("createAccountButton.text")); // NOI18N
        createAccountButton.setName("createAccountButton"); // NOI18N
        createAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createAccountButtonMouseClicked(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(org.cgympoker.gui.CGYMPokerApp.class).getContext().getActionMap(CGYMPokerView.class, this);
        jExitButton.setAction(actionMap.get("quit")); // NOI18N
        jExitButton.setName("exitButton"); // NOI18N
        jExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jExitButtonMouseClicked(evt);
            }
        });

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLoginButton)
                        .addGap(88, 88, 88)
                        .addComponent(jExitButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap(283, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(createAccountButton)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLoginButton)
                    .addComponent(jExitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        statusPanel.setName("statusPanel"); // NOI18N
        statusPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N
        statusPanel.add(statusPanelSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N
        statusPanel.add(statusMessageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N
        statusPanel.add(statusAnimationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        progressBar.setName("progressBar"); // NOI18N
        statusPanel.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 160, -1));

        setComponent(mainPanel);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitButtonMouseClicked
        System.out.println("Mouse clicked");
}//GEN-LAST:event_jExitButtonMouseClicked

    private void jLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoginButtonMouseClicked
        server = checkInfo();
        if (server != null) {
            this.getFrame().setVisible(false);
            if (serverView == null) {
                serverView = new CGYMServerView(server);
            }
            CGYMPokerApp.getApplication().show(serverView);
        }
}//GEN-LAST:event_jLoginButtonMouseClicked

    private void createAccountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountButtonMouseClicked
        this.getFrame().setVisible(false);
        if (createAccountView == null) {
                createAccountView = new CGYMCreateAccount();
            }
            CGYMPokerApp.getApplication().show(createAccountView);
}//GEN-LAST:event_createAccountButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccountButton;
    private javax.swing.JButton jExitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JCheckBox passwordCheckBox;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    /**
     * read the saved username and the password and write the username and password text fields
     *
     */
    private void readUsernameAndPassword() {
           try{
            BufferedReader input = new BufferedReader(new FileReader("pass.cgym"));
            String line = input.readLine();
            if (line != null){
                usernameTextField.setText(line);
                line = input.readLine();
                if (line != null){
                    passwordField.setText(line);
                    passwordCheckBox.setSelected(true);
                }
            }
            input.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param b boolean
     * b = false - save only the username
     * b = true - save the password also
     */
   
}
