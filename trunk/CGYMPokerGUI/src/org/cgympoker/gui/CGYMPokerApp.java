/*
 * CGYMPokerApp.java
 */

package org.cgympoker.gui;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class CGYMPokerApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new CGYMPokerView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of CGYMPokerApp
     */
    public static CGYMPokerApp getApplication() {
        return Application.getInstance(CGYMPokerApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
         if (System.getSecurityManager() == null) {
                    System.setSecurityManager(new SecurityManager());
                }
        launch(CGYMPokerApp.class, args);
    }
}
