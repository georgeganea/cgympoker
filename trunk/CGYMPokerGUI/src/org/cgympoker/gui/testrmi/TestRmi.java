/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.gui.testrmi;


import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.cgympoker.common.Login;


/**
 *
 * @author george
 */
public class TestRmi {
    public static void main( String args[]){
                //if (System.getSecurityManager() == null) {
            //System.setSecurityManager(new SecurityManager());
       // }
         try {
            String name = "CgymPokerLogin";
            Registry registry = LocateRegistry.getRegistry("10.11.1.11");
            System.out.println("gigi "+registry.list()[0]);
            Remote  login = (Remote) registry.lookup(name);
            //login.login();
            System.out.println("after remote!  "+login.toString());
            Login log = (Login) login;
            System.out.println("  "+log.login("username","password").toString());
        
           // System.out.println("login to string "+log.toString());
        } catch (Exception e) {
            System.err.println("CgymPokerLogin exception:");
            e.printStackTrace();
        }

    }

}
