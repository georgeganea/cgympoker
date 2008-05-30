/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ioana
 */
public class CGYMPokerUtil {
     public static String getServerAddress(){
         try {
            BufferedReader reader = new BufferedReader(new FileReader("config.cgym"));
            return reader.readLine(); 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return "127.0.0.1";
        } catch (IOException e) {
            e.printStackTrace();
            return "127.0.0.1";
        }
     }
}
