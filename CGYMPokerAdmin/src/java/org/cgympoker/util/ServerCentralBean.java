/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cgympoker.util;
import org.cgympoker.common.*;
/**
 *
 * @author carmen
 */
public class ServerCentralBean {
    private ServerCentral server;
    public ServerCentralBean(){
        
    }
    public ServerCentral getServer(){
        return server;
    }
    public void setServer(ServerCentral s){
        server=s;
    }
    public String nimic(){
        return "nimic";
    }
}
