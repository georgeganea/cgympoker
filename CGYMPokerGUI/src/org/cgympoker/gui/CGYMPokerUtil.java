/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
     
     public static void saveUsernamePassword(boolean b, String username, String password) {
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter(new File("pass.cgym")));
            output.write(username);
            output.newLine();
            if (b){
                output.write(password);
            }
            output.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
