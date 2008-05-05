/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.gui.testrmi;


import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.cgympoker.Login;


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
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            Remote  login = (Remote) registry.lookup(name);
            //login.login();
            Login log = (Login) login;
            log.login();
            System.out.println("login to string "+log.toString());
        } catch (Exception e) {
            System.err.println("CgymPokerLogin exception:");
            e.printStackTrace();
        }

    }

}
