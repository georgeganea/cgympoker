package org.cgympoker;

import java.util.List;




public class LoginImpl implements Login{


    public Server login(String user, String pass)  {
        System.out.println("am apelat o metoda de pe server");
        return new ServerImpl();
    }

   

}
