/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ioana
 */
public class CGYMPokerUtil {
     public static void showErrorMessage(JPanel mainPanel, String errorMessage){
        JOptionPane.showMessageDialog(mainPanel,
                  errorMessage,
                  "CGYM error",
                 JOptionPane.ERROR_MESSAGE);
    }
}
