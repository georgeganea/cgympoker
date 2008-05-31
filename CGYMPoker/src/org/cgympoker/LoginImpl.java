package org.cgympoker;


import org.cgympoker.common.Login;
import org.cgympoker.common.Server;
import org.cgympoker.common.ServerCentral;
import org.cgympoker.users.UserFile;

public class LoginImpl implements Login{
    public  ServerImpl server;
    
    public Server login(String user, String pass)  {
        server = new ServerImpl(user, 1000);
        ServerCentralImpl.INSTANCE.addServer(server);
        System.out.println("am apelat o metoda de pe server");
        if (UserFile.checkPass(user, pass)){
            System.out.println("iese pe aici");
            return server;
        }
        else {
            System.out.println("e false");
            return null;
        }
    }

    public ServerCentral loginAdmin(String user, String pass)  {
        if (user.compareTo("admin")!=0)
            return null;
        if (UserFile.checkPass("admin", pass)){
            return ServerCentralImpl.INSTANCE;
        }
        else {
            System.out.println("e false");
            return null;
        }
    }
    
    public Server createAccount(String user, String pass, String firstName, String lastName, String eMail){
        server = new ServerImpl(user,1000);
        ServerCentralImpl.INSTANCE.addServer(server);
        System.out.println("am apelat o metoda de pe server");
        if (UserFile.createUserFile(user, pass, firstName, lastName, eMail) == false)
            return null;
        return server;
    }
}