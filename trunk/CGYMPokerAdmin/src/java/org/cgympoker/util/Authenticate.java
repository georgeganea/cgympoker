/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cgympoker.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cgympoker.common.Login;
import org.cgympoker.common.ServerCentral;

/**
 *
 * @author Ioana
 */
public class Authenticate {
//default constructor
    public Authenticate() {
    }


//method that is called from validateuser.jsp and this checks for the authentic user and
    public ServerCentral authenticate(String user, String pass) {
        try {
            String name = "CgymPokerLogin";
            File f = new File(".");
            Registry registry = LocateRegistry.getRegistry(CGYMPokerUtil.getServerAddress());
            System.out.println(registry.lookup(name));
            Remote login = (Remote) registry.lookup(name);
            Login log = (Login) login;
            return log.loginAdmin(user, pass);
        } catch (Exception ex) {
            Logger.getLogger(Authenticate.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

